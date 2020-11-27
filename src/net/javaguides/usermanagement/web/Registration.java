package net.javaguides.usermanagement.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.usermanagement.dao.AccountDAO;
import net.javaguides.usermanagement.dao.AdminDAO;
import net.javaguides.usermanagement.dao.DocumentDAO;
import net.javaguides.usermanagement.dao.EtudiantDAO;
import net.javaguides.usermanagement.dao.ProfesseurDAO;
import net.javaguides.usermanagement.dao.UserDAO;
import net.javaguides.usermanagement.model.Account;
import net.javaguides.usermanagement.model.Admin;
import net.javaguides.usermanagement.model.Etudiant;
import net.javaguides.usermanagement.model.Professeur;
import net.javaguides.usermanagement.model.User;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private UserDAO userDAO;
     private AdminDAO adminDAO;
     private ProfesseurDAO profDAO;
     private EtudiantDAO etdDAO;
     private AccountDAO accountDAO;
     private DocumentDAO docDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
    	 this.userDAO =  new UserDAO();
         this.adminDAO = new AdminDAO();
         this.profDAO = new ProfesseurDAO();
         this.etdDAO = new EtudiantDAO();
         this.accountDAO = new AccountDAO();
         this.docDAO =  new DocumentDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String name = request.getParameter("user");
			String password = request.getParameter("pass");

			String sql = "insert into registration(name,password) values(?,?)";
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/document","root","");
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.executeUpdate();
			System.out.println("good");
			response.sendRedirect("list");

		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		String first_name = request.getParameter("first");
		String last_name = request.getParameter("last");
		String gender = request.getParameter("gender");
		String cin = request.getParameter("cin");
		String address = request.getParameter("adresse");
		String date_birth =  request.getParameter("date");
	
		String place_birth = request.getParameter("place");
		String email = request.getParameter("mail");
		String phone = request.getParameter("phone");
		String photo = request.getParameter("image");
		String role = "etudiant";
		String pass = request.getParameter("pass");
		
		Etudiant etd =null;
//User user = new User(id,name,email,country);
		User	user = new User(first_name,last_name,gender,cin,date_birth,place_birth,address,email,phone,photo);
		try {
			userDAO.insertUser(user);
		} catch (UnsupportedEncodingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(role.equals("etudiant")) {
			etd = new Etudiant(email);
			try {
				etdDAO.insertEtudiant(etd);
			} catch (UnsupportedEncodingException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		Account ac = new Account(email,pass,role);
		try {
			accountDAO.insertAccount(ac);
		} catch (UnsupportedEncodingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.sendRedirect("login.jsp");
	}

}
