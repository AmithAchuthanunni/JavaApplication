package com.cts.beans;

import java.io.Serializable;

public class StudentBean implements Serializable{

	private int roll;
	private String name;
	private String address;
	private String email;
	private String phone;
	private String password;
	
	public StudentBean() {
		// TODO Auto-generated constructor stub
	}

	public StudentBean(int roll, String name, String address, String email, String phone, String password) {
		super();
		this.roll = roll;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
