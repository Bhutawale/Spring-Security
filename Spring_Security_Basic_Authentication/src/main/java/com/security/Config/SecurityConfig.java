package com.security.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http
		.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(
				auth->auth
				.antMatchers("/public/**").permitAll()
				.antMatchers("/auth/register").permitAll()
				.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
				.antMatchers("/user/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
				.anyRequest().authenticated()
				)
		.httpBasic();
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
