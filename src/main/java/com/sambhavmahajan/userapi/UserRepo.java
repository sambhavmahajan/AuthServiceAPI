package com.sambhavmahajan.userapi;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo{
	private final JdbcClient jdbcClient;
	
	public UserRepo(JdbcClient client) {
		this.jdbcClient = client;
	}
	public Optional<User> findByUserName(String username) {
		return jdbcClient.sql("SELECT * FROM usertable WHERE username = ?").param(username).query(User.class).optional();
	}
	public boolean add(User u) {
		return jdbcClient.sql("INSERT INTO usertable(EMAIL, USERNAME, NAME, PASSWORD) values(?,?,?,?)").params(List.of(u.getEmail(), u.getUsername(), u.getName(), u.getPassword())).update() == 1;
	}
	public boolean del(String username) {
		return jdbcClient.sql("DELETE FROM usertable WHERE username = ?").param(username).update() == 1;
	}
}