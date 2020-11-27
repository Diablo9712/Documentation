package net.javaguides.usermanagement.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.usermanagement.model.Professeur;

public class ProfesseurDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/document?useSSL=false&useUnicode=true&characterEncoding=utf8";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO `professeur`(`id`, `user`) VALUES (NULL,?)";
	private static final String SELECT_USER_BY_ID = "SELECT * FROM professeur,users where users.email=professeur.user and etudiant.id = ?";
	private static final String SELECT_ALL_USERS = "SELECT * FROM professeur,users where users.email=professeur.user ";
	private static final String DELETE_USERS_SQL = "DELETE professeur  FROM professeur where id = ?";

	private static final String UPDATE_USERS_SQL = "UPDATE professeur set user = ?   where id = ?";
	
	
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
	
	public void insertProfesseur(Professeur prof) throws SQLException, UnsupportedEncodingException {
		
	
			try(Connection cn = getConnection();
					PreparedStatement ps = cn.prepareStatement(INSERT_USERS_SQL)
					){
				ps.setNString(1, prof.getUser());


				ps.executeUpdate();
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
	}
	
	// update user
	
	
	
	public boolean updateProfesseur(Professeur prof) throws SQLException, UnsupportedEncodingException {
		boolean rowUpdated;
	
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(UPDATE_USERS_SQL)
				){
			ps.setNString(1, prof.getUser());
			ps.setInt(2, prof.getId());
		

			 
			rowUpdated=ps.executeUpdate()>0;
		}
		
		return rowUpdated;
}
	
	// select user by id
	
	public Professeur selectProfesseur(int id) {
		Professeur prof = null;
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(SELECT_USER_BY_ID);
				){
			ps.setInt(1, id);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			
				String userr =  rs.getString("user");
				prof = new Professeur(id,userr);
				
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return prof;
	}
	
	
	//select users
	
	public List<Professeur> selectAllProfesseurs() {
		List<Professeur> profs =  new ArrayList<>();
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(SELECT_ALL_USERS);
				){
			
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
			
				String admin =  rs.getString("user");

				profs.add(new Professeur(id,admin));
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return profs;
	}
	
	
	
	//Delete user
	
	
	public boolean deleteProfesseur(int id) throws SQLException {
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
