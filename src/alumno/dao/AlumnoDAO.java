package alumno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import alumno.model.Alumno;
import alumno.model.Conexion;

public class AlumnoDAO {
	private Conexion con;
	private Connection connection;

	public AlumnoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// insertar artículo
	public boolean insertar(Alumno alumno) throws SQLException {
		String sql = "INSERT INTO student (id, CUI, DNI, apellido_paterno, apellido_materno, fecha_nacimiento, direccion, telefono, nivel, documentos) "
				+ "VALUES (?, ?, ?,?,?,?,?,?,?,?)";
		System.out.println(alumno.getCUI());
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, null);
		statement.setString(2, alumno.getCUI());
		statement.setString(3, alumno.getDNI());
		statement.setString(4, alumno.getPaterno());
		statement.setString(5, alumno.getApellidomaterno());
		statement.setDate( 6, alumno.getFechanacimiento());
		statement.setString(7, alumno.getDireccion());
		statement.setString(8, alumno.getTelefono());
		statement.setString(9, alumno.getNivel());
		statement.setString(10, alumno.getDocumentos());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todos los productos
	public List<Alumno> listarAlumnos() throws SQLException {

		List<Alumno> listaAlumnos = new ArrayList<Alumno>();
		String sql = "SELECT * FROM student";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int id = resulSet.getInt("id");
			String CUI = resulSet.getString("CUI");
			String DNI = resulSet.getString("DNI");
			String paterno = resulSet.getString("apellido_paterno");
			String apellido_materno = resulSet.getString("apellido_materno");
			java.sql.Date fecha_nacimiento = resulSet.getDate("fecha_nacimiento");
			String direccion = resulSet.getString("direccion");
			String telefono = resulSet.getString("telefono");
			String nivel = resulSet.getString("nivel");
			String documentos = resulSet.getString("documentos");
			Alumno alumno = new Alumno(id, CUI, DNI, paterno, apellido_materno, fecha_nacimiento,direccion,telefono,nivel,documentos);
			listaAlumnos.add(alumno);
		}
		con.desconectar();
		return listaAlumnos;
	}

	// obtener por id
	public Alumno obtenerPorId(int id) throws SQLException {
		Alumno alumno = null;

		String sql = "SELECT * FROM student WHERE id= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			alumno = new Alumno(res.getInt("id"), res.getString("CUI"), res.getString("DNI"),
					res.getString("apellido_paterno"), res.getString("apellido_materno"), res.getDate("fecha_nacimiento"),
					res.getString("direccion"), res.getString("telefono"), res.getString("nivel"), res.getString("documentos"));
		}
		res.close();
		con.desconectar();

		return alumno;
	}
	public Alumno obtenerPorCUI(String CUI) throws SQLException {
		Alumno alumno = null;

		String sql = "SELECT * FROM student WHERE CUI= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, CUI);
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			alumno = new Alumno(res.getInt("id"), res.getString("CUI"), res.getString("DNI"),
					res.getString("apellido_paterno"), res.getString("apellido_materno"), res.getDate("fecha_nacimiento"),
					res.getString("direccion"), res.getString("telefono"), res.getString("nivel"), res.getString("documentos"));
		}
		res.close();
		con.desconectar();

		return alumno;
	}

	// actualizar
	public boolean actualizar(Alumno alumno) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE student SET CUI=?, DNI=?,apellido_paterno=?,apellido_materno=?, fecha_nacimiento=?,direccion=?,telefono=?,nivel=?,documentos=? WHERE id=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, alumno.getCUI());
		statement.setString(2, alumno.getDNI());
		statement.setString(3, alumno.getPaterno());
		statement.setString(4, alumno.getApellidomaterno());
		System.out.println(alumno.getCUI());
		statement.setInt(5, alumno.getId());
		statement.setDate( 6, alumno.getFechanacimiento());
		statement.setString(7, alumno.getDireccion());
		statement.setString(8, alumno.getTelefono());
		statement.setString(9, alumno.getNivel());
		statement.setString(10, alumno.getDocumentos());
		

		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//eliminar
	public boolean eliminar(Alumno alumno) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM student WHERE ID=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, alumno.getId());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
}
