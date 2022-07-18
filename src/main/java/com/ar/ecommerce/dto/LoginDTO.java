package com.ar.ecommerce.dto;

public class LoginDTO {
	
	private String username;
	
	private String token;
	
	private String refreshToken;

	private String name;
	
	private String surname;
	
	private String role;
	
	private String address;
	
	private String email;
	
	private String phone;
	
	
	public LoginDTO(String username, String token, String refreshToken, String name, String surname, String role, String address, String email, String phone) {
		super();
		this.username = username;
		this.token = token;
		this.refreshToken = refreshToken;
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.address = address;
		this.email = email;
		this.phone = phone;

		
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getRefreshToken() {
		return refreshToken;
	}
	
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
