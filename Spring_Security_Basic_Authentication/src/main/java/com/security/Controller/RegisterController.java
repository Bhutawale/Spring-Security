package com.security.Controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.Dao.UserRepository;
import com.security.Model.User;

@RestController
@RequestMapping("/auth")
public class RegisterController 
{
	
	private final UserRepository userRepository;
	
	
	private final PasswordEncoder passwordEncoder;
	
	public RegisterController(UserRepository userRepository,PasswordEncoder passwordEncoder) 
	{
		this.userRepository=userRepository;
		this.passwordEncoder=passwordEncoder;
	}
	
	@PostMapping("/register")
	public String registerUser(@RequestBody User user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		
		
		userRepository.save(user);
		return "User Registered Successfully";
	}
	
}
