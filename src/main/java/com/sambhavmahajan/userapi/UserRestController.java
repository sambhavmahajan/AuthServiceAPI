package com.sambhavmahajan.userapi;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserRestController {
	private final UserService service;
	public UserRestController(UserService uService) {
		service = uService;
	}
	@GetMapping("/auth")
	public boolean auth(@RequestBody AuthUser user) {
		return service.validate(user);
	}
	@PostMapping("/register")
	public String add(@RequestBody User user) {
		if(service.isUserName(user.getUsername())) {
			return "Username " + user.getUsername() + " already exits.";
		}
		service.addUser(user);
		return user + "\nsucessfully created.";
	}
	@GetMapping("/fetch")
	public String fetchDetails(@RequestBody AuthUser user) {
		if(service.isUserName(user.username) && auth(user)) {
			return service.fetchDetails(user);
		}
		return "Failed to fetch details. Bad Credentials.";
	}
	@DeleteMapping("/del")
	public String del(@RequestBody AuthUser user) {
		if(service.validate(user)) {
			service.removeUser(user.username);
			return "User: " + user.username + " deleted.";
		}
		return "Bad Credentials.";
	}
}
