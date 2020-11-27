package net.javaguides.usermanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.usermanagement.dao.DocumentDAO;
import net.javaguides.usermanagement.dao.Document_demanderDAO;
import net.javaguides.usermanagement.model.Document;
import net.javaguides.usermanagement.model.Document_demander;



/**
 * Servlet implementation class DocumentDemander
 */
@WebServlet( name = "DocumentDemander", urlPatterns = {"/DocumentDemander"})

public class DocumentDemander extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Document_demanderDAO docdeamnderDAO;
	public static int BUFFER_SIZE = 1024 * 100;
	public static final String UPLOAD_DIR = "resources";
	public static String fileName = null;
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocumentDemander() {
      //  super();
        this.docdeamnderDAO =  new Document_demanderDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		  String action = request.getServletPath();
			switch (action) {
			case "/newdocDemander" : showNewFormtestDemander(request,response);break;
			case "/insertDocDemander" :try {

					insertDocDemander(request,response);
				} catch (ServletException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} break;
			case "/deleteDocDemander" :try {
					deleteDocDemander(request,response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} break;
			case "/editDocDemander" : showEditFormDemander(request,response); break;
			case "/updateDocDemander" :try {
					updateDocDemander(request,response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} break;
			
			default : try {
			
					listDocDemander(request,response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
			}
	}
	
	private void listDocDemander(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		
		  List<Document_demander> listDocDemander = docdeamnderDAO.selectAllAdmins();
	       // request.setAttribute("listDocDemander", listDocDemander);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("documentDemander/document-list.jsp");
	        dispatcher.forward(request, response);
	}
	
	private void updateDocDemander(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
		int id = Integer.parseInt(request.getParameter("id"));
		int document = Integer.parseInt(request.getParameter("document"));
		int user = Integer.parseInt(request.getParameter("user"));
		String name = request.getParameter("filename");
		String path = request.getParameter("path");
		Document_demander	test = new Document_demander(id,document,user,name,path);		
		docdeamnderDAO.updateUser(test);
		response.sendRedirect("listDoc");
	}
	
	private void showEditFormDemander(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =  Integer.parseInt(request.getParameter("id"));
		Document_demander existingUser = docdeamnderDAO.selectAdmin(id);
		RequestDispatcher dr = request.getRequestDispatcher("documentDemander/document-form.jsp");
		request.setAttribute("documenttest", existingUser);
		dr.forward(request, response);
	}
	
	private void showNewFormtestDemander(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dr = request.getRequestDispatcher("documentDemander/document-form.jsp");
		dr.forward(request, response);
	}
	
	private void insertDocDemander(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {

		int document = Integer.parseInt(request.getParameter("document"));
		int user = Integer.parseInt(request.getParameter("user"));
		String path = request.getParameter("path");
		String name = request.getParameter("filename");

//User user = new User(id,name,email,country);
		Document_demander	test = new Document_demander(document,user,name,path);
		docdeamnderDAO.insertdoc(test);

		
		response.sendRedirect("listDoc");
	}
	private void deleteDocDemander(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		int id = Integer.parseInt(request.getParameter("id"));
		
		docdeamnderDAO.deleteAdmin(id);
		response.sendRedirect("DocumentDemander");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
