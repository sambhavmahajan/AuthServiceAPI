package com.sambhavmahajan.userapi;

import org.springframework.web.bind.annotation.*;

class AuthUser{
	public String username, password;
	public AuthUser(String username, String password) {
		this.username = username;
		this.password = password;
	}
}

@RestController
@RequestMapping("/api")
public class UserRestController {
	private static UserService service = new UserService();
	@GetMapping
	public boolean auth(@RequestBody AuthUser authUser) {
		return service.validate(authUser.username, authUser.password);
	}
}
