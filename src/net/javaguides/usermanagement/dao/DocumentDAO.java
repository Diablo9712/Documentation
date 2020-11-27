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
import net.javaguides.usermanagement.model.Document;
import java.sql.Date;
public class DocumentDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/document?useSSL=false&useUnicode=true&characterEncoding=utf8";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_doc_SQL = "INSERT INTO `document`(`id`, `name`) VALUES (NULL,?)";
	private static final String SELECT_doc_BY_ID = "SELECT `id`, `name` FROM `document` WHERE id = ?";
	private static final String SELECT_ALL_docS = "SELECT * FROM `document`  ";
	private static final String DELETE_doc_SQL = "DELETE document  FROM document where id = ?";

	private static final String UPDATE_doc_SQL = "UPDATE document set name = ?   where id = ?";
	
	
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
	
	public void insertAdmin(Document user) throws SQLException, UnsupportedEncodingException {
		
	
			try(Connection cn = getConnection();
					PreparedStatement ps = cn.prepareStatement(INSERT_doc_SQL)
					){
				ps.setNString(1, user.getName());


				ps.executeUpdate();
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
	}
	
	// update user
	
	
	
	public boolean updateUser(Document admin) throws SQLException, UnsupportedEncodingException {
		boolean rowUpdated;
	
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(UPDATE_doc_SQL)
				){
			ps.setNString(1, admin.getName());
			ps.setInt(2, admin.getId());
		

			 
			rowUpdated=ps.executeUpdate()>0;
		}
		
		return rowUpdated;
}
	
	// select user by id
	
	public Document selectAdmin(int id) {
		Document admin = null;
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(SELECT_doc_BY_ID);
				){
			ps.setInt(1, id);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			
				String userr =  rs.getString("name");
				admin = new Document(id,userr);
				
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}
	
	
	//select users
	
	public List<Document> selectAllAdmins() {
		List<Document> admins =  new ArrayList<>();
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(SELECT_ALL_docS);
				){
			
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
			
				String admin =  rs.getString("name");

				admins.add(new Document(id,admin));
				
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
				PreparedStatement ps = cn.prepareStatement(DELETE_doc_SQL)
				){
		
			ps.setInt(1, id);
			
			rowDeleted=ps.executeUpdate()>0;
		}
		
		return rowDeleted;
}
	
	

}
