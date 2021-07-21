package com.training.authdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		auth.inMemoryAuthentication().withUser("alex").password(passwordEncoder.encode("alex123")).roles("ADMIN")
		.and()
	    .withUser("abc").password(passwordEncoder.encode("abc123")).roles("USER")
	    .and()
	    .passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//protect endpoints
		
//		http.authorizeRequests()
//		.anyRequest().authenticated()
//		.and()
//		.formLogin()
//		.and()
//		.logout();
		
		http.authorizeRequests()
		.antMatchers("/admin/*")
		.hasRole("ADMIN")
		.antMatchers("/user/*")
		.hasRole("USER")
		.and()
		.formLogin();
	}
	
	
}
