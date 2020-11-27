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

import net.javaguides.usermanagement.dao.Document_demanderDAO;
import net.javaguides.usermanagement.model.Document_demander;

/**
 * Servlet implementation class DocumentDemanderProfesseur
 */

@WebServlet( name = "DocumentDemanderProfesseur", urlPatterns = {"/DocumentDemanderProfesseur"})
public class DocumentDemanderProfesseur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Document_demanderDAO docdeamnderDAO;
	public static int BUFFER_SIZE = 1024 * 100;
	public static final String UPLOAD_DIR = "resources";
	public static String fileName = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocumentDemanderProfesseur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String action = request.getServletPath();
			switch (action) {
			case "/newdocDemander" :// showNewFormtestDemander(request,response);break;
			
			default : try {
			
					listDocDemandertest(request,response);
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

	
	private void listDocDemandertest(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		
		 // List<Document_demander> listDocDemandertest = docdeamnderDAO.selectAllAdmins();
	       // request.setAttribute("listDocDemandertest", listDocDemandertest);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("professeur/document-list.jsp");
	        dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
