package com.security.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController 
{
	@GetMapping("/hello")
    public String publicEndpoint() {
        return "Hello, this is a public endpoint!";
    }
}
