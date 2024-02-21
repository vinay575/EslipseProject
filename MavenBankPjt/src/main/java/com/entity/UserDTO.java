package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "User_info")
public class UserDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;

	private String name;
	private String phoneNo;
	private String address;
	private String email;
	private String password;
	

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BankDTO> banks = new ArrayList<>();

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO( String name, String phoneNo, String address, String email, String password,
			 List<BankDTO> banks) {
		super();
		
		this.name = name;
		this.phoneNo = phoneNo;
		this.address = address;
		this.email = email;
		this.password = password;
		
		this.banks = banks;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	

	public List<BankDTO> getBanks() {
		return banks;
	}

	public void setBanks(List<BankDTO> banks) {
		this.banks = banks;
	}

	
	
}
