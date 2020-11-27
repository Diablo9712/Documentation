package net.javaguides.usermanagement.model;

public class Demande {

	private int id;
	private String date_demande;
	private String etat;
	private int user;
	private int document;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate_demande() {
		return date_demande;
	}
	public void setDate_demande(String date_demande) {
		this.date_demande = date_demande;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public int getDocument() {
		return document;
	}
	public void setDocument(int document) {
		this.document = document;
	}
	public Demande(int id, String date_demande, String etat, int user, int document) {
		super();
		this.id = id;
		this.date_demande = date_demande;
		this.etat = etat;
		this.user = user;
		this.document = document;
	}
	public Demande(String date_demande, String etat, int user, int document) {
		super();
		this.date_demande = date_demande;
		this.etat = etat;
		this.user = user;
		this.document = document;
	}
	@Override
	public String toString() {
		return "Demande [id=" + id + ", date_demande=" + date_demande + ", etat=" + etat + ", user=" + user
				+ ", document=" + document + "]";
	}
	
	
}
