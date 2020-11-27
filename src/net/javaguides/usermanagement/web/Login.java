package net.javaguides.usermanagement.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */

@WebServlet( name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session=null;
	HttpSession sessionid=null;
	HttpSession test=null;
	String dbName = null;
	String idd = null;
	String email = null;
	String role = null;
	String dbPassword = null;
	String name = null;
	String password = null;
	String img = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
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
		session = request.getSession();
		sessionid = request.getSession();
		test = request.getSession();
		try {
			 name = request.getParameter("user");
			 password = request.getParameter("pass");
			
			String sql = "select * from users,account where account.login = users.email and users.email = ? and account.pass=? ";
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/document","root","");
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				dbName = rs.getString(2)+" "+rs.getString(3);
				email = rs.getString(9);
				dbPassword = rs.getString(14);
				idd = rs.getString(1);
				role = rs.getString(15);
				img = rs.getString(11);
		        session.setAttribute("name",dbName);  
		        sessionid.setAttribute("id",idd);  
		       // sessionimg.setAttribute("img",img);
		        test.setAttribute("test", img);
		        System.out.println(img);
			}
			
			if(name.equals(email) && password.equals(dbPassword)) {
			
		        System.out.print("Hello, "+dbName+" Welcome to Profile");  
		    	if(role.equals("admin") ) {
				//	response.sendRedirect("menu_admin.jsp");
		    		 System.out.print(role);  
					RequestDispatcher rd = request.getRequestDispatcher("/list");
					rd.include(request, response);
			        

				}else {
					if(role.equals("professeur") ) {
						RequestDispatcher rd = request.getRequestDispatcher("/DemandeProfesseur");
						rd.include(request, response);				        
			    		 System.out.print(role);  

					}else {
						if(role.equals("etudiant") ) {
							RequestDispatcher rd = request.getRequestDispatcher("/DemandeEtudiant");
				    		 System.out.print(role);  

							rd.include(request, response);	
							//rd.include(request, response);
							//rd.include("/DemandeEtudiant");

						}
					}
				}

			}else {
				response.sendRedirect("login.jsp");

			}

		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}

}
