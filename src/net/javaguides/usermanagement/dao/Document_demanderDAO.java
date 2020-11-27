package net.javaguides.usermanagement.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.usermanagement.model.Document;
import net.javaguides.usermanagement.model.Document_demander;

public class Document_demanderDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/document?useSSL=false&useUnicode=true&characterEncoding=utf8";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_doc_SQL = "INSERT INTO `document_demander`(`id`, `document_id`, `user_id`, `fileName`, `path`) VALUES (NULL,?,?,?)";
	private static final String SELECT_doc_BY_ID = "SELECT `id`, `document_id`, `user_id`,`fileName`, `path` FROM `document_demander` WHERE  id = ?";
	private static final String SELECT_ALL_docS = "SELECT `id`, `document_id`, `user_id`,`fileName`, `path` FROM `document_demander` ";
	private static final String DELETE_doc_SQL = "DELETE document_demander  FROM document_demander where id = ?";

	private static final String UPDATE_doc_SQL = "UPDATE document_demander set document_id = ?,user_id=?,fileName=?, path=?  where id = ?";
	
	
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
	
	public void insertdoc(Document_demander doc) throws SQLException, UnsupportedEncodingException {
		
	
			try(Connection cn = getConnection();
					PreparedStatement ps = cn.prepareStatement(INSERT_doc_SQL)
					){
				ps.setInt(1, doc.getDocument_id());
				ps.setInt(2, doc.getUser_id());
				ps.setString(3, doc.getPath());


				ps.executeUpdate();
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
	}
	
	// update user
	
	
	
	public boolean updateUser(Document_demander doc) throws SQLException, UnsupportedEncodingException {
		boolean rowUpdated;
	
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(UPDATE_doc_SQL)
				){
			ps.setInt(1, doc.getDocument_id());
			ps.setInt(2, doc.getUser_id());
			ps.setString(3, doc.getPath());	
			ps.setString(4, doc.getFilename());	
			ps.setInt(5, doc.getId());
		

			 
			rowUpdated=ps.executeUpdate()>0;
		}
		
		return rowUpdated;
}
	
	// select user by id
	
	public Document_demander selectAdmin(int id) {
		Document_demander admin = null;
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(SELECT_doc_BY_ID);
				){
			ps.setInt(1, id);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			
				int doc =  rs.getInt("document_id");
				int user =  rs.getInt("user_id");
				String name = rs.getString("fileName");
				String path =  rs.getString("path");
				admin = new Document_demander(id,doc,user,name,path);
				
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}
	
	
	//select users
	
	public List<Document_demander> selectAllAdmins() {
		List<Document_demander> admins =  new ArrayList<>();
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(SELECT_ALL_docS);
				){
			
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
			
				int doc =  rs.getInt("document_id");
				int user =  rs.getInt("user_id");
				String name = rs.getString("fileName");

				String path =  rs.getString("path");
			//	admins = new Document_demander(id,doc,user,path);
				admins.add(new Document_demander(id,doc,user,name,path));

				
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
