package net.javaguides.usermanagement.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.usermanagement.model.Account;
import net.javaguides.usermanagement.model.Professeur;

public class AccountDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/document?useSSL=false&useUnicode=true&characterEncoding=utf8";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO `account`(`id`, `login`, `pass`, `permission`) VALUES (NULL,?,?,?)";
	private static final String SELECT_USER_BY_ID = "SELECT * FROM account,users where users.email=account.login and etudiant.id = ?";
	private static final String SELECT_ALL_USERS = "SELECT * FROM account,users where users.email=account.login ";
	private static final String DELETE_USERS_SQL = "DELETE account  FROM account where id = ?";

	private static final String UPDATE_USERS_SQL = "UPDATE account set user = ?   where id = ?";
	
	
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
	
	public void insertAccount(Account compte) throws SQLException, UnsupportedEncodingException {
		
	
			try(Connection cn = getConnection();
					PreparedStatement ps = cn.prepareStatement(INSERT_USERS_SQL)
					){
				ps.setNString(1, compte.getLogin());
				ps.setNString(2, compte.getPass());
				ps.setNString(3, compte.getPermission());

				ps.executeUpdate();
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
	}
	
	// update user
	
	
	
	public boolean updateAccount(Account compte) throws SQLException, UnsupportedEncodingException {
		boolean rowUpdated;
	
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(UPDATE_USERS_SQL)
				){
			ps.setNString(1, compte.getLogin());
			ps.setNString(2, compte.getPass());
			ps.setNString(3, compte.getPermission());
			ps.setInt(4, compte.getId());
		

			 
			rowUpdated=ps.executeUpdate()>0;
		}
		
		return rowUpdated;
}
	
	// select user by id
	
	public Account selectAccount(int id) {
		Account compte = null;
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(SELECT_USER_BY_ID);
				){
			ps.setInt(1, id);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {

				String login =  rs.getString("login");
				String pass =  rs.getString("pass");
				String permission =  rs.getString("permission");
				compte = new Account(id,login,pass,permission);
				
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return compte;
	}
	
	
	//select users
	
	public List<Account> selectAllAccounts() {
		List<Account> accounts =  new ArrayList<>();
		try(Connection cn = getConnection();
				PreparedStatement ps = cn.prepareStatement(SELECT_ALL_USERS);
				){
			
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");

				String login = rs.getString("login");
				String pass = rs.getString("pass");
				String permission = rs.getString("permission");

				accounts.add(new Account(id,login,pass,permission));
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	
	
	//Delete user
	
	
	public boolean deleteAccount(int id) throws SQLException {
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
