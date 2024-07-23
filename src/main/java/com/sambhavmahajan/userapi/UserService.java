package com.sambhavmahajan.userapi;

import java.util.Optional;

import org.springframework.stereotype.Service;
@Service
public class UserService {
	private final UserRepo repository;
	public UserService(UserRepo repo) {
		this.repository = repo;
	}
	public boolean validate(AuthUser user) {
		Optional<User> u = repository.findByUserName(user.username);
		if(u.isPresent()) {
			return user.password.equals(u.get().getPassword());
		}
		return false;
	}
	public boolean isUserName(String username) {
		return repository.findByUserName(username).isPresent();
	}
	public void addUser(User user) {
		repository.add(user);
	}
	public String fetchDetails(AuthUser user) {
		if(validate(user)) {
			User u = repository.findByUserName(user.username).get();
			return u.toString();
		}
		return "Bad credentials.";
	}
	public void removeUser(String username) {
		repository.del(username);
	}
}
