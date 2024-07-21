package com.sambhavmahajan.userapi;

import jakarta.persistence.Entity;

@Entity
public class User {
	private String email,username,name,password;
	public User(String email,String username, String name, String password) {
		this.email = email;
		this.username = username;
		this.name = name;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public boolean auth(String password) {
		return this.password.equals(password);
	}
}
