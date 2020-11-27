package net.javaguides.usermanagement.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.usermanagement.model.Etudiant;
import java.sql.Date;
public class EtudiantDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/document?useSSL=false&useUnicode=true&characterEncoding=utf8";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO `etudiant`(`id`, `user`) VALUES (NULL,?)";
	private static final String SELECT_USER_BY_ID = "SELECT * FROM etudiant,users where users.email=etudiant.user and etudiant.id = ?";
	private static final String SELECT_ALL_USERS = "SELECT * FROM etudiant,users where users.email=etudiant.user ";
	private static final String DELETE_USERS_SQL = "DELETE etudiant  FROM etudiant where id = ?";

	private static final String UPDATE_USERS_SQL = "UPDATE etudiant set user = ?   where id = ?";
	
	
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
	
	public void insertEtudiant(Etudiant etudiant) throws SQLException, UnsupportedEncodingException {
		
	
			try(Connection cn = getConnection();
					PreparedStatement ps = cn.prepareStatement(INSERT_USERS_SQL)
					){
				ps.setNString(1, etudiant.getUser());


				ps.executeUpdate();
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
	}
	
	// update user
	
	
	
	public boolean updateEtudiant(Etudiant etudiant) throws SQLException, UnsupportedEncodingException {
		boolean rowUpdated;
	
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(UPDATE_USERS_SQL)
				){
			ps.setNString(1, etudiant.getUser());
			ps.setInt(2, etudiant.getId());
		

			 
			rowUpdated=ps.executeUpdate()>0;
		}
		
		return rowUpdated;
}
	
	// select user by id
	
	public Etudiant selectEtudiant(int id) {
		Etudiant etudiant = null;
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(SELECT_USER_BY_ID);
				){
			ps.setInt(1, id);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			
				String userr =  rs.getString("user");
				etudiant = new Etudiant(id,userr);
				
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return etudiant;
	}
	
	
	//select users
	
	public List<Etudiant> selectAllAdmins() {
		List<Etudiant> etudiants =  new ArrayList<>();
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(SELECT_ALL_USERS);
				){
			
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
			
				String admin =  rs.getString("user");

				etudiants.add(new Etudiant(id,admin));
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return etudiants;
	}
	
	
	
	//Delete user
	
	
	public boolean deleteEtudiant(int id) throws SQLException {
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
