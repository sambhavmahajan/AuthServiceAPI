package com.sambhavmahajan.userapi;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserRestController {
	private static UserService service = new UserService();
	@GetMapping("/auth")
	public boolean auth(@RequestBody AuthUser user) {
		return service.validate(user);
	}
	@PostMapping("/add")
	public String add(@RequestBody User user) {
		if(service.isUserName(user.getUsername())) {
			return "Username: " + user + " already exits.";
		}
		service.addUser(user);
		return "User: " + user + " sucessfully created.";
	}
	@GetMapping("/get")
	public String fetchDetails(@RequestBody AuthUser user) {
		if(service.isUserName(user.username)) {
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
