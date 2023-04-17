package com.deloitte.mockProj.backend.entity;

import java.math.BigInteger;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.springframework.stereotype.Component;

@Component
@Table(name="user",schema="de_kart")
@Entity
public class User{

	
	public User() {
		super();
	}
	
	
	
	public User(int user_id, String name, String username, BigInteger phonenumber, String address, String password,
			String role) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.username = username;
		this.phonenumber = phonenumber;
		this.address = address;
		this.password = password;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	
	@Column
	private String name;
	
	@Column
	private String username;
	
	@Column
	private BigInteger phonenumber;
	
	@Column
	private String address;
	
	@Column
	private String password;
	
	@Column
	private String role;

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



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public BigInteger getPhonenumber() {
		return phonenumber;
	}



	public void setPhonenumber(BigInteger phonenumber) {
		this.phonenumber = phonenumber;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", username=" + username + ", phonenumber=" + phonenumber
				+ ", address=" + address + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
}
