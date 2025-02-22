package com.security.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController 
{
	 @GetMapping("/profile")
	    public String userEndpoint() {
	        return "Welcome, User!";
	    }
}
