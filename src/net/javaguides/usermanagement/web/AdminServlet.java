package net.javaguides.usermanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.usermanagement.dao.UserDAO;
import net.javaguides.usermanagement.model.Admin;
import net.javaguides.usermanagement.model.User;
import net.javaguides.usermanagement.dao.AdminDAO;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private UserDAO userDAO;
	 private AdminDAO adminDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        this.userDAO =  new UserDAO();
        this.adminDAO = new AdminDAO();

    }

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
		String userr =  request.getParameter("user");
		//User user = new User(id,name,email,country);
		User	user = new User(id,first_name,last_name,gender,cin,date_birth,place_birth,address,email,phone,photo);
	//	Admin   test = new Admin(id,first_name,last_name,gender,cin,date_birth,place_birth,address,email,phone,photo, id, userr);
		
		userDAO.updateUser(user);
	//	adminDAO.updateUser(test);
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

		int id = Integer.parseInt(request.getParameter("id"));

		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String gender = request.getParameter("gender");
		String cin = request.getParameter("cin");
		String address = request.getParameter("address");
		String date_birth =  request.getParameter("date_birth");
		//DateFormat dtFmt = null;
		SimpleDateFormat dtFmt = new SimpleDateFormat("yyyy-MM-dd");
		Date dtToday = (Date) dtFmt.parse(date_birth);
		String place_birth = request.getParameter("place_birth");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String photo = request.getParameter("photo");
		String userr =  request.getParameter("user");
		User	user = new User(first_name,last_name,gender,cin,date_birth,place_birth,address,email,phone,photo);
	//	Admin   test = new Admin(id,first_name,last_name,gender,cin,date_birth,place_birth,address,email,phone,photo, userr);
		
		userDAO.updateUser(user);
	//	adminDAO.updateUser(test);
		response.sendRedirect("list");
	}
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		int id = Integer.parseInt(request.getParameter("id"));
		
	//	adminDAO.deleteUser(id);
		response.sendRedirect("list");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
