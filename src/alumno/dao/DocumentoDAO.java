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
		String sql = "INSERT INTO documents (CUI, categoria, fecha_doc, nro_serie, direccion_imagen) "
				+ "VALUES (?, ?, ?,?,?)";
		System.out.println(documento.getCategoria());
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, documento.getCUI());
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
	public List<Documento> listarDocumentos(String CUI) throws SQLException {

		List<Documento> listaDocumentos = new ArrayList<Documento>();
		String sql = "SELECT * FROM documents WHERE CUI= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, CUI);
		ResultSet resulSet = statement.executeQuery();
		while (resulSet.next()) {
			String categoria = resulSet.getString("categoria");
			java.sql.Date fechadoc = resulSet.getDate("fecha_doc");
			String nroserie = resulSet.getString("nro_serie");
			String direccionimagen = resulSet.getString("direccion_imagen");
			Documento documento = new Documento(CUI, categoria,fechadoc,nroserie,direccionimagen);
			listaDocumentos.add(documento);
		}
		con.desconectar();
		return listaDocumentos;
	}
	public List<Documento> listarUnitario(String CUI,String nroserie) throws SQLException {

		List<Documento> listaDocumentos = new ArrayList<Documento>();
		String sql = "SELECT * FROM documents WHERE nro_serie= ? AND CUI=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, nroserie);
		statement.setString(2, CUI);
		ResultSet resulSet = statement.executeQuery();
		while (resulSet.next()) {
			String categoria = resulSet.getString("categoria");
			java.sql.Date fechadoc = resulSet.getDate("fecha_doc");
			String direccionimagen = resulSet.getString("direccion_imagen");
			Documento documento = new Documento(CUI, categoria,fechadoc,nroserie,direccionimagen);
			listaDocumentos.add(documento);
		}
		con.desconectar();
		return listaDocumentos;
	}
	public List<Documento> listarFecha(String CUI,String fecha_doc,String categoria) throws SQLException {

		List<Documento> listaDocumentos = new ArrayList<Documento>();
		String sql = "SELECT * FROM documents WHERE fecha_doc= ? AND CUI=? AND categoria=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, fecha_doc);
		statement.setString(2, CUI);
		statement.setString(3, categoria);
		ResultSet resulSet = statement.executeQuery();
		while (resulSet.next()) {
			//String categoria = resulSet.getString("categoria");
			String nroserie = resulSet.getString("nro_serie");
			java.sql.Date fechadoc = resulSet.getDate("fecha_doc");
			String direccionimagen = resulSet.getString("direccion_imagen");
			Documento documento = new Documento(CUI, categoria,fechadoc,nroserie,direccionimagen);
			listaDocumentos.add(documento);
		}
		con.desconectar();
		return listaDocumentos;
	}
	public List<Documento> listarFechaTodos(String CUI,String fecha_doc) throws SQLException {

		List<Documento> listaDocumentos = new ArrayList<Documento>();
		String sql = "SELECT * FROM documents WHERE fecha_doc= ? AND CUI=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, fecha_doc);
		statement.setString(2, CUI);
		ResultSet resulSet = statement.executeQuery();
		while (resulSet.next()) {
			String categoria = resulSet.getString("categoria");
			String nroserie = resulSet.getString("nro_serie");
			java.sql.Date fechadoc = resulSet.getDate("fecha_doc");
			String direccionimagen = resulSet.getString("direccion_imagen");
			Documento documento = new Documento(CUI, categoria,fechadoc,nroserie,direccionimagen);
			listaDocumentos.add(documento);
		}
		con.desconectar();
		return listaDocumentos;
	}
	public List<Documento> listarPorCategoria(String CUI,String categoria) throws SQLException {

		List<Documento> listaDocumentos = new ArrayList<Documento>();
		String sql = "SELECT * FROM documents WHERE categoria=? AND CUI=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, categoria);
		statement.setString(2, CUI);
		ResultSet resulSet = statement.executeQuery();
		while (resulSet.next()) {
			//String categoria = resulSet.getString("categoria");
			String nroserie = resulSet.getString("nro_serie");
			java.sql.Date fechadoc = resulSet.getDate("fecha_doc");
			String direccionimagen = resulSet.getString("direccion_imagen");
			Documento documento = new Documento(CUI, categoria,fechadoc,nroserie,direccionimagen);
			listaDocumentos.add(documento);
		}
		con.desconectar();
		return listaDocumentos;
	}
	// obtener por id
	public Documento obtenerPorNroserie(String nroserie) throws SQLException {
		Documento documento = null;

		String sql = "SELECT * FROM documents WHERE nro_serie= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, nroserie);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			documento = new Documento(res.getString("CUI"), res.getString("categoria"), res.getDate("fecha_doc"),
					res.getString("nro_serie"), res.getString("direccion_imagen"));
		}
		res.close();
		con.desconectar();
		return documento;
	}

	// actualizar
	public boolean actualizar(Documento documento) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE documents SET categoria=?, fecha_doc=?,direccion_imagen=? WHERE nro_serie=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, documento.getCategoria());
		System.out.println(documento.getCategoria());
		statement.setDate( 2, documento.getFechadoc());
		statement.setString(3, documento.getDireccionimagen());
		statement.setString(4, documento.getNroserie());
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	public List<String> listarCategories() throws SQLException {

		List<String> listaCategorias = new ArrayList<String>();
		String sql = "SELECT * FROM categories";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resulSet = statement.executeQuery();
		while (resulSet.next()) {
			String categoria = resulSet.getString("categoria");
			listaCategorias.add(categoria);
		}
		con.desconectar();
		return listaCategorias;
	}
	
	//eliminar
	public boolean eliminar(Documento documento) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM documents WHERE nro_serie=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, documento.getNroserie());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
}
