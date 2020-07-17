package alumno.model;
import java.util.Date;
public class Alumno {
	private int id;
	private String CUI;
	private String DNI;
	private String paterno;
	private String apellidomaterno;
	private java.sql.Date fechanacimiento;
	private String direccion;
	private String telefono;
	private String nivel;
	private String documentos;
	
	public Alumno(int id, String CUI, String DNI, String paterno, String apellido_materno, Date fecha_nacimiento,String direccion,
			String telefono,String nivel, String documentos) {
		this.id = id;
		this.CUI = CUI;
		this.DNI = DNI;
		this.paterno = paterno;
		this.apellidomaterno = apellido_materno;
		this.fechanacimiento = new java.sql.Date(fecha_nacimiento.getTime());
		this.direccion = direccion;
		this.telefono = telefono;
		this.nivel = nivel;
		this.documentos = documentos;
	}
	public Alumno(int id, String CUI, String DNI, String paterno, String apellido_materno, java.sql.Date fecha_nacimiento,String direccion,
			String telefono,String nivel, String documentos) {
		this.id = id;
		this.CUI = CUI;
		this.DNI = DNI;
		this.paterno = paterno;
		this.apellidomaterno = apellido_materno;
		this.fechanacimiento = fecha_nacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.nivel = nivel;
		this.documentos = documentos;
	}
	//getters y setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCUI() {
		return CUI;
	}
	public void setCUI(String CUI) {
		this.CUI = CUI;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String DNI) {
		this.DNI = DNI;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getApellidomaterno() {
		return apellidomaterno;
	}
	public void setApellidomaterno(String apellido_materno) {
		this.apellidomaterno = apellido_materno;
	}
	public java.sql.Date getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(java.sql.Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono (String telefono) {
		this.telefono = telefono;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getDocumentos() {
		return documentos;
	}
	public void setDocumentos(String documentos) {
		this.documentos = documentos;
	}
}
