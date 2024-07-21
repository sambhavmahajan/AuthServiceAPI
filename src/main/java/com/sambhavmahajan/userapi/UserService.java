package com.sambhavmahajan.userapi;

public class UserService {
	private UserRepo repository = new UserRepo();
	public boolean validate(AuthUser user) {
		User u = repository.findByUserName(user.username);
		if(u == null) return false;
		return u.getPassword().equals(user.password);
	}
	public boolean isUserName(String username) {
		return repository.findByUserName(username) != null;
	}
	public void addUser(User user) {
		repository.add(user);
	}
	public String fetchDetails(AuthUser user) {
		if(validate(user)) {
			User u = repository.findByUserName(user.username);
			return u.toString();
		}
		return "Bad credentials.";
	}
	public void removeUser(String username) {
		repository.del(username);
	}
}
