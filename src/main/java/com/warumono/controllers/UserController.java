package com.warumono.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.warumono.services.AuthenticatedUserDetailsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/")
public class UserController
{
	@Autowired
	private AuthenticatedUserDetailsService userService;
	
	@PostMapping(value = "registration")
	public String regist
	(
		@RequestParam(value = "name", required = true) String name, 
		@RequestParam(value = "username", required = true) String username, 
		@RequestParam(value = "password", required = true) String password
	)
	{
		log.debug("name: {}, username: {}, password: {}", name, username, password);
		
		String viewName = "/login";
		
		if(ObjectUtils.isEmpty(userService.persistUser(name, username, password)))
		{
			viewName = "/failure";
		}
		
		return viewName;
	}
}
