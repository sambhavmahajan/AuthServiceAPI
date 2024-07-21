package com.sambhavmahajan.userapi;

public class UserService {
	private UserRepo repository = new UserRepo();
	public boolean validate(String username, String password) {
		User u = repository.findByUserName(username);
		if(u == null) return false;
		return u.getPassword().equals(password);
	}
}
