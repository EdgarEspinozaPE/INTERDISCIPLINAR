package alumno.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alumno.dao.DocumentoDAO;
import alumno.model.Alumno;
import alumno.model.Documento;

/**
 * Servlet implementation class AdminDocumento
 */
@WebServlet("/AdminDocumento")
public class AdminDocumento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DocumentoDAO documentoDAO;
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {

			documentoDAO = new DocumentoDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDocumento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "nuevo":
				nuevo(request, response);
				break;
			case "register":
				System.out.println("entro");
				registrar(request, response);
				break;
			case "mostrar":
				mostrar(request, response);
				break;
			case "mostrarporNroserie":
				mostrarporNroserie(request, response);
				break;
			case "mostrarporId":
				mostrarporId(request, response);
				break;
			case "showedit":
				showEditar(request, response);
				break;	
			case "editar":
				editar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			default:
				break;
			}			
		} catch (SQLException e) {
			e.getStackTrace(); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		doGet(request, response);
	}
	private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		SimpleDateFormat formato=new SimpleDateFormat("yyyy/MM/dd");
		Documento documento;
		try {
			documento = new Documento(Integer.parseInt(request.getParameter("id")), request.getParameter("categoria"),formato.parse(request.getParameter("fechadoc")),request.getParameter("nroserie"),
					request.getParameter("direccionimagen"));
			documentoDAO.insertar(documento);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		String idpaso= request.getParameter("id");
		request.setAttribute("id", idpaso);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/registerdocument.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrardocument.jsp");
		List<Documento> listaDocumentos= documentoDAO.listarDocumentos(Integer.parseInt(request.getParameter("id")));
		String idpaso=request.getParameter("id");
		request.setAttribute("id", idpaso);
		request.setAttribute("lista", listaDocumentos);
		dispatcher.forward(request, response);
	}
	private void mostrarporId(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrar.jsp");
		Documento documento = documentoDAO.obtenerPorNroserie("1");
		request.setAttribute("documento", documento);
		dispatcher.forward(request, response);
	}	
	
	private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Documento documento = documentoDAO.obtenerPorNroserie(request.getParameter("nroserie"));
		request.setAttribute("documento", documento);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editardocument.jsp");
		dispatcher.forward(request, response);
	}
	private void mostrarporNroserie(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		List<Documento> listaDocumentos;
		if(request.getParameter("nroserie")=="") {
			listaDocumentos= documentoDAO.listarDocumentos(Integer.parseInt(request.getParameter("id")));
		}
		else {
			listaDocumentos= documentoDAO.listarUnitario(request.getParameter("nroserie"));
		}
		request.setAttribute("lista", listaDocumentos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrardocument.jsp");
		dispatcher.forward(request, response);
	}
	private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		SimpleDateFormat formato=new SimpleDateFormat("yyyy/MM/dd");
		Documento documento;
		try {
			documento = new Documento(Integer.parseInt(request.getParameter("id")), request.getParameter("categoria"),formato.parse(request.getParameter("fechadoc")),request.getParameter("nroserie"),
					request.getParameter("direccionimagen"));
			documentoDAO.actualizar(documento);
			index(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Documento documento = documentoDAO.obtenerPorNroserie(request.getParameter("nroserie"));
		documentoDAO.eliminar(documento);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
	}

}
