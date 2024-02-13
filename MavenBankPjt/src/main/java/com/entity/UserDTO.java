package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserDTO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    
    private String name;
    private String phoneNo;
    private String address;
    private String email;
    private String password;
    private String confirmPass;
    
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    // Constructors, Getters, and Setters
    
	public UserDTO( String name, String phoneNo, String address, String email, String password,
			String confirmPass) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.address = address;
		this.email = email;
		this.password = password;
		this.confirmPass = confirmPass;
	}

	public int getId() {
		return user_id;
	}

	public void setId(int id) {
		this.user_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}

	
	
}
