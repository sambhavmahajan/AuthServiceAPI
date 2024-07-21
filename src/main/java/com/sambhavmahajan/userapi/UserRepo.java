package com.sambhavmahajan.userapi;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepo{
	private HashMap<String, User> UserList = new HashMap<>();
	public User findByUserName(String username) {
		return UserList.get(username);
	}
	public void add(User user) {
		UserList.put(user.getUsername(), user);
	}
	public void del(String username) {
		UserList.remove(username);
	}
}