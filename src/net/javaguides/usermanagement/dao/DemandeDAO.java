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
import net.javaguides.usermanagement.model.Demande;
import net.javaguides.usermanagement.model.Document;

import java.sql.Date;

public class DemandeDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/document?useSSL=false&useUnicode=true&characterEncoding=utf8";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_doc_SQL = "INSERT INTO `demande`(`id`, `date_demande`, `etat`, `user`, `document`) VALUES (NULL,?,?,?,?)";
	private static final String SELECT_doc_BY_ID = "SELECT * FROM `demande` WHERE id = ?";
	private static final String SELECT_ALL_docS = "SELECT * FROM `demande`  ";
	private static final String DELETE_doc_SQL = "DELETE demande  FROM demande where id = ?";

	private static final String UPDATE_doc_SQL = "UPDATE `demande` SET `date_demande`=?,`etat`=?,`user`=?,`document`=?    where id = ?";
	
	
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
	
	public void insertAdmin(Demande user) throws SQLException, UnsupportedEncodingException {
		
	
			try(Connection cn = getConnection();
					PreparedStatement ps = cn.prepareStatement(INSERT_doc_SQL)
					){
				ps.setString(1, user.getDate_demande());
				ps.setString(2, user.getEtat());
				ps.setInt(3, user.getUser());
				ps.setInt(4, user.getDocument());


				ps.executeUpdate();
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
	}
	
	// update user
	
	
	
	public boolean updateUser(Demande admin) throws SQLException, UnsupportedEncodingException {
		boolean rowUpdated;
	
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(UPDATE_doc_SQL)
				){
			ps.setNString(1, admin.getDate_demande());
			ps.setNString(2, admin.getEtat());
			ps.setInt(3, admin.getUser());
			ps.setInt(4, admin.getDocument());
			ps.setInt(5, admin.getId());

	

			 
			rowUpdated=ps.executeUpdate()>0;
		}
		
		return rowUpdated;
}
	
	// select user by id
	
	public Demande selectAdmin(int id) {
		Demande admin = null;
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(SELECT_doc_BY_ID);
				){
			ps.setInt(1, id);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			
				String date =  rs.getString("date_demande");
				String etat =  rs.getString("etat");
				int user =  Integer.parseInt(rs.getString("user"));
				int document = Integer.parseInt( rs.getString("document"));
				admin = new Demande(id,date,etat,user,document);
				
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}
	
	
	//select users
	
	public List<Demande> selectAllAdmins() {
		List<Demande> admins =  new ArrayList<>();
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(SELECT_ALL_docS);
				){
			
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
			
				String date =  rs.getString("date_demande");
				String etat =  rs.getString("etat");
				int user =  Integer.parseInt(rs.getString("user"));
				int document = Integer.parseInt( rs.getString("document"));

				admins.add(new Demande(id,date,etat,user,document));
				
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
