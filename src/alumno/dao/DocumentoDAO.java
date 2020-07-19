package alumno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import alumno.model.Documento;
import alumno.model.Conexion;

public class DocumentoDAO {
	private Conexion con;
	private Connection connection;

	public DocumentoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// insertar artículo
	public boolean insertar(Documento documento) throws SQLException {
		String sql = "INSERT INTO document (id, categoria, fechadoc, nroserie, direccionimagen) "
				+ "VALUES (?, ?, ?,?,?)";
		System.out.println(documento.getCategoria());
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, null);
		statement.setString(2, documento.getCategoria());
		statement.setDate( 3, documento.getFechadoc());
		statement.setString(4, documento.getNroserie());
		statement.setString(5, documento.getDireccionimagen());
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todos los productos
	public List<Documento> listarDocumentos(int id) throws SQLException {

		List<Documento> listaDocumentos = new ArrayList<Documento>();
		String sql = "SELECT * FROM document WHERE id= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resulSet = statement.executeQuery();
		while (resulSet.next()) {
			String categoria = resulSet.getString("categoria");
			java.sql.Date fechadoc = resulSet.getDate("fecha_doc");
			String nroserie = resulSet.getString("nro_serie");
			String direccionimagen = resulSet.getString("direccion_imagen");
			Documento documento = new Documento(id, categoria,fechadoc,nroserie,direccionimagen);
			listaDocumentos.add(documento);
		}
		con.desconectar();
		return listaDocumentos;
	}

	// obtener por id
	public Documento obtenerPorId(int id) throws SQLException {
		Documento documento = null;

		String sql = "SELECT * FROM document WHERE id= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			documento = new Documento(res.getInt("id"), res.getString("categoria"), res.getDate("fecha_doc"),
					res.getString("nro_serie"), res.getString("direccion_imagen"));
		}
		res.close();
		con.desconectar();

		return documento;
	}

	// actualizar
	public boolean actualizar(Documento documento) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE document SET categoria=?, fecha_doc=?,nro_serie=?,direccion_imagen=? WHERE id=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, documento.getCategoria());
		System.out.println(documento.getCategoria());
		statement.setInt(2, documento.getId());
		statement.setDate( 3, documento.getFechadoc());
		statement.setString(4, documento.getNroserie());
		statement.setString(5, documento.getDireccionimagen());
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//eliminar
	public boolean eliminar(Documento documento) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM document WHERE ID=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, documento.getId());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
}
