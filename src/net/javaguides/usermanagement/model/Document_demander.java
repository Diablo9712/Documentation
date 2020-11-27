package net.javaguides.usermanagement.model;

public class Document_demander {
	private int id;
	private int document_id;
	private int user_id;
	private String filename;
	private String path;
	
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDocument_id() {
		return document_id;
	}
	public void setDocument_id(int document_id) {
		this.document_id = document_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Document_demander(int id, int document_id, int user_id, String filename, String path) {
		super();
		this.id = id;
		this.document_id = document_id;
		this.user_id = user_id;
		this.filename = filename;
		this.path = path;
	}
	public Document_demander(int document_id, int user_id, String filename, String path) {
		super();
		this.document_id = document_id;
		this.user_id = user_id;
		this.filename = filename;
		this.path = path;
	}
	@Override
	public String toString() {
		return "Document_demander [id=" + id + ", document_id=" + document_id + ", user_id=" + user_id + ", filename="
				+ filename + ", path=" + path + "]";
	}

	
	
	

}
