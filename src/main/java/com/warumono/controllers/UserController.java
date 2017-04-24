package com.warumono.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.warumono.domains.AuthenticatedUser;
import com.warumono.services.AuthenticatedUserDetailsService;

@RestController
@RequestMapping(value = "/")
public class UserController
{
	@Autowired
	private AuthenticatedUserDetailsService userService;
	
	@PostMapping(value = "registration")
	public ResponseEntity<AuthenticatedUser> regist
	(
		@RequestParam(value = "name", required = true) String name, 
		@RequestParam(value = "username", required = true) String username, 
		@RequestParam(value = "password", required = true) String password
	)
	{
		return ResponseEntity.ok(userService.persistUser(name, username, password));
	}
}
