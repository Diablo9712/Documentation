package net.javaguides.usermanagement.model;

public class Admin {

	private int id;
	private String user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	
	
	public Admin(int id, String user) {
		super();
		this.id = id;
		this.user = user;
	}
	public Admin(String user) {
		super();
		this.user = user;
	}
	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", user=" + user + ", toString()=" + super.toString() + "]";
	}
	
	
}
