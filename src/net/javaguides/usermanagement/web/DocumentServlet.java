package net.javaguides.usermanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*; 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.usermanagement.dao.DocumentDAO;

import net.javaguides.usermanagement.model.Document;

/**
 * Servlet implementation class DocumentServlet
 */
@WebServlet( name = "DocumentServlet", urlPatterns = {"/DocumentServlet"})

public class DocumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DocumentDAO docDAO;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocumentServlet() {
       // super();
        this.docDAO =  new DocumentDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
        String action = request.getServletPath();
		switch (action) {
		case "/newdoc" : showNewFormtest(request,response);break;
		case "/insertDoc" :try {

				insertDoc(request,response);
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
		case "/deleteDoc" :try {
				deleteDoc(request,response);
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
		case "/editDoc" : showEditForm(request,response); break;
		case "/updateDoc" :try {
				updateDoc(request,response);
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
			
				listDoc(request,response);
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

	private void listDoc(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		
		  List<Document> listDoc = docDAO.selectAllAdmins();
	        request.setAttribute("listDoc", listDoc);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("document/document-list.jsp");
	        dispatcher.forward(request, response);
	}
	
	private void updateDoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Document	user = new Document(id,name);

		
		docDAO.updateUser(user);
		response.sendRedirect("listDoc");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =  Integer.parseInt(request.getParameter("id"));
Document existingUser = docDAO.selectAdmin(id);
		RequestDispatcher dr = request.getRequestDispatcher("document/document-form.jsp");
		request.setAttribute("document", existingUser);
		dr.forward(request, response);
	}
	
	private void showNewFormtest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dr = request.getRequestDispatcher("document/document-form.jsp");
		dr.forward(request, response);
	}
	
	private void insertDoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {

		String name = request.getParameter("name");

//User user = new User(id,name,email,country);
		Document	user = new Document(name);
		docDAO.insertAdmin(user);

		
		response.sendRedirect("listDoc");
	}
	private void deleteDoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		int id = Integer.parseInt(request.getParameter("id"));
		
		docDAO.deleteAdmin(id);
		response.sendRedirect("listDoc");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
