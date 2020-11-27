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
import java.sql.Date;
public class UserDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/document?useSSL=false&useUnicode=true&characterEncoding=utf8";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO `users`(`id`, `first_name`, `last_name`, `gender`, `cin`, `date_birth`, `place_birth`, `address`, `email`, `phone`, `photo`) VALUES (NULL,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_USER_BY_ID = "SELECT * FROM users where id = ?";
	private static final String SELECT_ALL_USERS = "SELECT * FROM users ";
	private static final String DELETE_USERS_SQL = "DELETE users  FROM users where id = ?";

	private static final String UPDATE_USERS_SQL = "UPDATE users set first_name = ?, last_name=?, gender=?,cin=?,date_birth = ?,place_birth=?, address=?, email=?, phone=?,  photo = ?   where id = ?";
	
	
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
	
	public void insertUser(User user) throws SQLException, UnsupportedEncodingException {
		
	
			try(Connection cn = getConnection();
					PreparedStatement ps = cn.prepareStatement(INSERT_USERS_SQL)
					){
				ps.setNString(1, user.getFirst_name());
				ps.setNString(2, user.getLast_name());
				ps.setNString(3, user.getGender());
				ps.setNString(4, user.getCin());
				ps.setString(5,   user.getDate_birth());
				ps.setNString(6, user.getPlace_birth());
				ps.setNString(7, user.getAddress());
				ps.setString(8, user.getEmail());
				ps.setNString(9, user.getPhone());
				ps.setNString(10, user.getPhoto());	
				 
				ps.executeUpdate();
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
	}
	
	// update user
	
	
	
	public boolean updateUser(User user) throws SQLException, UnsupportedEncodingException {
		boolean rowUpdated;
	
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(UPDATE_USERS_SQL)
				){
			ps.setNString(1, user.getFirst_name());
			ps.setNString(2, user.getLast_name());
			ps.setNString(3, user.getGender());
			ps.setNString(4, user.getCin());
			
			ps.setString(5,   user.getDate_birth());
			ps.setNString(6, user.getPlace_birth());
			ps.setNString(7, user.getAddress());
			ps.setString(8, user.getEmail());
			ps.setNString(9, user.getPhone());
			ps.setNString(10, user.getPhoto());	
			ps.setInt(11, user.getId());
		

			 
			rowUpdated=ps.executeUpdate()>0;
		}
		
		return rowUpdated;
}
	
	// select user by id
	
	public User selectUser(int id) {
		User user = null;
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(SELECT_USER_BY_ID);
				){
			ps.setInt(1, id);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String gender = rs.getString("gender");
				String cin = rs.getString("cin");
				String date_birth =  rs.getString("date_birth");
				String place_birth = rs.getString("place_birth");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String photo = rs.getString("photo");
				user = new User(id,first_name,last_name,gender,cin,date_birth,place_birth,address,email,phone,photo);
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	//select users
	
	public List<User> selectAllUsers() {
		List<User> users =  new ArrayList<>();
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(SELECT_ALL_USERS);
				){
			
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String gender = rs.getString("gender");
				String cin = rs.getString("cin");
				String date_birth =  rs.getString("date_birth");
				String place_birth = rs.getString("place_birth");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String photo = rs.getString("photo");
				users.add(new User(id,first_name,last_name,gender,cin,date_birth,place_birth,address,email,phone,photo));
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	
	
	//Delete user
	
	
	public boolean deleteUser(int id) throws SQLException {
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
