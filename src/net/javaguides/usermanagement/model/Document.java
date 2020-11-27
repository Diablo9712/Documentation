package net.javaguides.usermanagement.model;

public class Document {

	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Document(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Document(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return "Document [id=" + id + ", name=" + name + "]";
	}
	
	
}
