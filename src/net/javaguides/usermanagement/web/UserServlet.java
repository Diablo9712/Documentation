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

import net.javaguides.usermanagement.dao.AccountDAO;
import net.javaguides.usermanagement.dao.AdminDAO;
import net.javaguides.usermanagement.dao.DemandeDAO;
import net.javaguides.usermanagement.dao.DocumentDAO;
import net.javaguides.usermanagement.dao.Document_demanderDAO;
import net.javaguides.usermanagement.dao.EtudiantDAO;
import net.javaguides.usermanagement.dao.ProfesseurDAO;
import net.javaguides.usermanagement.dao.UserDAO;
import net.javaguides.usermanagement.model.Account;
import net.javaguides.usermanagement.model.Admin;
import net.javaguides.usermanagement.model.Demande;
import net.javaguides.usermanagement.model.Document;
import net.javaguides.usermanagement.model.Document_demander;
import net.javaguides.usermanagement.model.Etudiant;
import net.javaguides.usermanagement.model.Professeur;
import net.javaguides.usermanagement.model.User;
import net.javaguides.usermanagement.dao.DocumentDAO;

import net.javaguides.usermanagement.model.Document;

/**
 * Servlet implementation class UserServlet
 */

@WebServlet( name = "/", urlPatterns = {"/"})

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private UserDAO userDAO;
       private AdminDAO adminDAO;
       private ProfesseurDAO profDAO;
       private EtudiantDAO etdDAO;
       private AccountDAO accountDAO;
       private DocumentDAO docDAO;
       private Document_demanderDAO docdeamnderDAO;
	   private DemandeDAO doctDAO;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
      this.userDAO =  new UserDAO();
      this.adminDAO = new AdminDAO();
      this.profDAO = new ProfesseurDAO();
      this.etdDAO = new EtudiantDAO();
      this.accountDAO = new AccountDAO();
      this.docDAO =  new DocumentDAO();
      this.docdeamnderDAO =  new Document_demanderDAO();
      this.doctDAO =  new DemandeDAO();


    }
   // DocumentServlet/newdoc
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getServletPath();
		switch (action) {
		case "/new" : showNewForm(request,response);break;
		case "/insert" :try {
				insertUser(request,response);
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
		case "/delete" :try {
				deleteUser(request,response);
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
		case "/edit" : showEditForm(request,response); break;
		case "/update" :try {
				updateUser(request,response);
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
		case "/editDoc" : showEditFormDoc(request,response); break;
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
			
		case "/insertdetudiant" :try {

			insertDocdetudiant(request,response);
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
	case "/deletedeetudiant" :try {
			deleteDocdeetudiant(request,response);
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
	case "/insertdprofesseur" :try {

		insertDocdprofesseur(request,response);
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
case "/deletedeprofesseur" :try {
		deleteDocdeprofesseur(request,response);
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
	
	
	
		
		default : try {
				listUser(request,response);
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

	private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dr = request.getRequestDispatcher("user-list.jsp");
		
		dr.forward(request, response);
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
		int id = Integer.parseInt(request.getParameter("id"));
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String gender = request.getParameter("gender");
		String cin = request.getParameter("cin");
		String address = request.getParameter("address");
		//Date startDate=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date_birth")); //get the parameter convert it to a data type Date.
		String date_birth =  request.getParameter("date_birth");			
		String place_birth = request.getParameter("place_birth");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String photo = request.getParameter("photo");
		//User user = new User(id,name,email,country);
		User	user = new User(id,first_name,last_name,gender,cin,date_birth,place_birth,address,email,phone,photo);

		
		userDAO.updateUser(user);
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =  Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.selectUser(id);
		RequestDispatcher dr = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dr.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dr = request.getRequestDispatcher("user-form.jsp");
		dr.forward(request, response);
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {

		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String gender = request.getParameter("gender");
		String cin = request.getParameter("cin");
		String address = request.getParameter("address");
		String date_birth =  request.getParameter("date_birth");
	
		String place_birth = request.getParameter("place_birth");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String photo = request.getParameter("photo");
		String role = request.getParameter("role");
		String pass = request.getParameter("pass");
		Admin ad =null;

		Professeur prof =null;
		Etudiant etd =null;
//User user = new User(id,name,email,country);
		User	user = new User(first_name,last_name,gender,cin,date_birth,place_birth,address,email,phone,photo);
		userDAO.insertUser(user);

		if(role.equals("admin")) {
			ad = new Admin(email);
			adminDAO.insertAdmin(ad);
		}else {
			if(role.equals("professeur")) {
				prof = new Professeur(email);
				profDAO.insertProfesseur(prof);
			}else {
				if(role.equals("etudiant")) {
					etd = new Etudiant(email);
					etdDAO.insertEtudiant(etd);
				}
			}
		}
		
		Account ac = new Account(email,pass,role);
		accountDAO.insertAccount(ac);
		
		
		response.sendRedirect("list");
	}
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		int id = Integer.parseInt(request.getParameter("id"));
		
		userDAO.deleteUser(id);
		response.sendRedirect("list");
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
		response.sendRedirect("DocumentServlet");
	}
	
	private void showEditFormDoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		
		response.sendRedirect("DocumentServlet");
	}
	private void deleteDoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		int id = Integer.parseInt(request.getParameter("id"));
		
		docDAO.deleteAdmin(id);
		response.sendRedirect("DocumentServlet");
	}
	
	
	private void listDocDemander(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		
		  List<Document_demander> listDocDemander = docdeamnderDAO.selectAllAdmins();
	        request.setAttribute("listDocDemander", listDocDemander);
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
	
	
	
	private void listDocde(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		
		  List<Demande> listDocde = doctDAO.selectAllAdmins();
	        request.setAttribute("listDocde", listDocde);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("demande/demande-list.jsp");
	        dispatcher.forward(request, response);
	}
	
	private void updateDocde(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
		int id = Integer.parseInt(request.getParameter("id"));
		String date = request.getParameter("date");
		String etat = "attente";
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
	
	private void deleteDocdeetudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		int id = Integer.parseInt(request.getParameter("id"));
		
		doctDAO.deleteAdmin(id);
		response.sendRedirect("DemandeEtudiant");
	}
	
	private void insertDocdetudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {

		String date = request.getParameter("date");
		String etat = "Envoye";
		int user = Integer.parseInt(request.getParameter("user"));
		int document = Integer.parseInt(request.getParameter("document"));
//User user = new User(id,name,email,country);
		Demande	usert = new Demande(date,etat,user,document);
		doctDAO.insertAdmin(usert);

		
		response.sendRedirect("DemandeEtudiant");
	}
	
	
	private void insertDocdprofesseur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {

		String date = request.getParameter("date");
		String etat = "Envoye";
		int user = Integer.parseInt(request.getParameter("user"));
		int document = Integer.parseInt(request.getParameter("document"));
//User user = new User(id,name,email,country);
		Demande	usert = new Demande(date,etat,user,document);
		doctDAO.insertAdmin(usert);

		
		response.sendRedirect("DemandeProfesseur");
	}
	private void deleteDocdeprofesseur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		int id = Integer.parseInt(request.getParameter("id"));
		
		doctDAO.deleteAdmin(id);
		response.sendRedirect("DemandeProfesseur");
	}
	
	private void listDocDemandertest(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		
		  List<Document_demander> listDocDemander = docdeamnderDAO.selectAllAdmins();
	       // request.setAttribute("listDocDemander", listDocDemander);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("professeur/document-list.jsp");
	        dispatcher.forward(request, response);
	}
	private void listDocdetudiant(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		
		  List<Demande> listDocdetudiant = doctDAO.selectAllAdmins();
	        request.setAttribute("listDocdetudiant", listDocdetudiant);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("etudiant/demande-list.jsp");
	        dispatcher.include(request, response);
	      //  response.sendRedirect("etudiant/demande-list.jsp");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
