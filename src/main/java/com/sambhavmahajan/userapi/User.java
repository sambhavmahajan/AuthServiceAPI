package com.sambhavmahajan.userapi;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	private String username;
	private String email,name,password;
	public User(String email,String username, String name, String password) {
		this.email = email;
		this.username = username;
		this.name = name;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public boolean auth(String password) {
		return this.password.equals(password);
	}
	@Override
	public String toString() {
		return "Username: " + username + "\n" 
				+ "Email: " + email + '\n'+
				"Name: " + name;
	}
}
