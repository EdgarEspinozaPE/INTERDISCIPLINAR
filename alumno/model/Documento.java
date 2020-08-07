package alumno.model;
import java.util.Date;
public class Documento {
	private int id;
	private String categoria;
	private java.sql.Date fechadoc;
	private String nroserie;
	private String direccionimagen;
	
	public Documento(int id, String categoria, Date fechadoc,String nroserie,
			String direccionimagen) {
		this.id = id;
		this.categoria = categoria;
		this.fechadoc = new java.sql.Date(fechadoc.getTime());
		this.nroserie = nroserie;
		this.direccionimagen = direccionimagen;
	}
	public Documento(int id, String categoria, java.sql.Date fechadoc,String nroserie,
			String direccionimagen) {
		this.id = id;
		this.categoria = categoria;
		this.fechadoc = fechadoc;
		this.nroserie = nroserie;
		this.direccionimagen = direccionimagen;
	}
	//getters y setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public java.sql.Date getFechadoc() {
		return fechadoc;
	}
	public void setFechadoc(java.sql.Date fechadoc) {
		this.fechadoc = fechadoc;
	}
	public String getNroserie() {
		return nroserie;
	}
	public void setNroserie(String nroserie) {
		this.nroserie = nroserie;
	}
	public String getDireccionimagen() {
		return direccionimagen;
	}
	public void setDireccionimagen (String direccionimagen) {
		this.direccionimagen = direccionimagen;
	}
}
