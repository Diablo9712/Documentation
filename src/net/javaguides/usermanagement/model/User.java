package net.javaguides.usermanagement.model;

import java.util.Date;

public class User {

	private int id;
	private String first_name;
	private String last_name;
	private String gender;
	private String cin;
	private String date_birth;
	private String place_birth;
	private String address;
	private String email;
	private String phone;
	private String photo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getDate_birth() {
		return date_birth;
	}
	public void setDate_birth(String date_birth) {
		this.date_birth = date_birth;
	}
	public String getPlace_birth() {
		return place_birth;
	}
	public void setPlace_birth(String place_birth) {
		this.place_birth = place_birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public User(int id, String first_name, String last_name, String gender, String cin, String date_birth,
			String place_birth, String address, String email, String phone, String photo) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.cin = cin;
		this.date_birth = date_birth;
		this.place_birth = place_birth;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.photo = photo;
	}
	public User(String first_name, String last_name, String gender, String cin, String date_birth, String place_birth,
			String address, String email, String phone, String photo) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.cin = cin;
		this.date_birth = date_birth;
		this.place_birth = place_birth;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", gender=" + gender
				+ ", cin=" + cin + ", date_birth=" + date_birth + ", place_birth=" + place_birth + ", address="
				+ address + ", email=" + email + ", phone=" + phone + ", photo=" + photo + "]";
	}
	
	
	
	
	

}
