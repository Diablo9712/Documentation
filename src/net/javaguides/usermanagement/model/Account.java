package net.javaguides.usermanagement.model;

public class Account {
	private int id;
	private String login;
	private String pass;
	private String permission;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public Account(int id, String login, String pass, String permission) {
		super();
		this.id = id;
		this.login = login;
		this.pass = pass;
		this.permission = permission;
	}
	public Account(String login, String pass, String permission) {
		super();
		this.login = login;
		this.pass = pass;
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", login=" + login + ", pass=" + pass + ", permission=" + permission + "]";
	}

	
	
}
