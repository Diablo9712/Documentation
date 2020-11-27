package net.javaguides.usermanagement.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import net.javaguides.usermanagement.model.User;
import net.javaguides.usermanagement.model.Admin;
import java.sql.Date;
public class AdminDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/document?useSSL=false&useUnicode=true&characterEncoding=utf8";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO `admin`(`id`, `user`) VALUES (NULL,?)";
	private static final String SELECT_USER_BY_ID = "SELECT * FROM admin,users where users.email=admin.user and admin.id = ?";
	private static final String SELECT_ALL_USERS = "SELECT * FROM admin,users where users.email=admin.user ";
	private static final String DELETE_USERS_SQL = "DELETE admin  FROM admin where id = ?";

	private static final String UPDATE_USERS_SQL = "UPDATE admin set user = ?   where id = ?";
	
	
	protected Connection getConnection() {
		
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
		
	}
	
	
	//Create or insert user
	
	public void insertAdmin(Admin user) throws SQLException, UnsupportedEncodingException {
		
	
			try(Connection cn = getConnection();
					PreparedStatement ps = cn.prepareStatement(INSERT_USERS_SQL)
					){
				ps.setNString(1, user.getUser());


				ps.executeUpdate();
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
	}
	
	// update user
	
	
	
	public boolean updateUser(Admin admin) throws SQLException, UnsupportedEncodingException {
		boolean rowUpdated;
	
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(UPDATE_USERS_SQL)
				){
			ps.setNString(1, admin.getUser());
			ps.setInt(2, admin.getId());
		

			 
			rowUpdated=ps.executeUpdate()>0;
		}
		
		return rowUpdated;
}
	
	// select user by id
	
	public Admin selectAdmin(int id) {
		Admin admin = null;
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(SELECT_USER_BY_ID);
				){
			ps.setInt(1, id);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			
				String userr =  rs.getString("user");
				admin = new Admin(id,userr);
				
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}
	
	
	//select users
	
	public List<Admin> selectAllAdmins() {
		List<Admin> admins =  new ArrayList<>();
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(SELECT_ALL_USERS);
				){
			
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
			
				String admin =  rs.getString("user");

				admins.add(new Admin(id,admin));
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return admins;
	}
	
	
	
	//Delete user
	
	
	public boolean deleteAdmin(int id) throws SQLException {
		boolean rowDeleted;
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(DELETE_USERS_SQL)
				){
		
			ps.setInt(1, id);
			
			rowDeleted=ps.executeUpdate()>0;
		}
		
		return rowDeleted;
}
	
	

}
