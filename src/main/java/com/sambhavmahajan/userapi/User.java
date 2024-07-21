package com.sambhavmahajan.userapi;

import jakarta.persistence.Entity;

@Entity
public class User {
	private String email,name,password;
	public User(String email, String name, String password) {
		this.email = email;
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
