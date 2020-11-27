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

import net.javaguides.usermanagement.dao.DemandeDAO;
import net.javaguides.usermanagement.dao.DocumentDAO;
import net.javaguides.usermanagement.model.Demande;
import net.javaguides.usermanagement.model.Document;

/**
 * Servlet implementation class DemandeServlet
 */
@WebServlet( name = "DemandeServlet", urlPatterns = {"/DemandeServlet"})

public class DemandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   private DemandeDAO doctDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemandeServlet() {
        super();
        this.doctDAO =  new DemandeDAO();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String action = request.getServletPath();
			switch (action) {
			case "/newde" : showNewFormtestde(request,response);break;
			case "/insertde" :try {

					insertDocde(request,response);
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
			case "/deletede" :try {
					deleteDocde(request,response);
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
			case "/editde" : showEditFormde(request,response); break;
			case "/updatede" :try {
					updateDocde(request,response);
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
				
					listDocde(request,response);
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

	
	private void listDocde(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		
		  List<Demande> listDocde = doctDAO.selectAllAdmins();
	        request.setAttribute("listDocde", listDocde);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("demande/demande-list.jsp");
	        dispatcher.forward(request, response);
	}
	
	private void updateDocde(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
		int id = Integer.parseInt(request.getParameter("id"));
		String date = request.getParameter("date");
		String etat = "Envoye";
		int user = Integer.parseInt(request.getParameter("user"));
		int document = Integer.parseInt(request.getParameter("document"));
		Demande	usert = new Demande(id,date,etat,user,document);

		
		doctDAO.updateUser(usert);
		response.sendRedirect("DemandeServlet");
	}
	
	private void showEditFormde(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =  Integer.parseInt(request.getParameter("id"));
		Demande existingUser = doctDAO.selectAdmin(id);
		RequestDispatcher dr = request.getRequestDispatcher("demande/document-form.jsp");
		request.setAttribute("demande", existingUser);
		dr.forward(request, response);
	}
	
	private void showNewFormtestde(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dr = request.getRequestDispatcher("demande/document-form.jsp");
		dr.forward(request, response);
	}
	
	private void insertDocde(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {

		String date = request.getParameter("date");
		String etat = "Envoye";
		int user = Integer.parseInt(request.getParameter("user"));
		int document = Integer.parseInt(request.getParameter("document"));
//User user = new User(id,name,email,country);
		Demande	usert = new Demande(date,etat,user,document);
		doctDAO.insertAdmin(usert);

		
		response.sendRedirect("DemandeServlet");
	}
	private void deleteDocde(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		int id = Integer.parseInt(request.getParameter("id"));
		
		doctDAO.deleteAdmin(id);
		response.sendRedirect("DemandeServlet");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
