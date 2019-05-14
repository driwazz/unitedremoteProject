package com.unitedremote.springboot.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select username, password, enabled from users where username=?");
        
		}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//close access & display my custom login page 
		http.authorizeRequests()
		      .anyRequest().authenticated().antMatchers("/home","/likedShops").hasRole("USER")
		      .anyRequest().authenticated()
		      .and().formLogin().loginPage("/login").permitAll()
		      .and().logout()
		      .permitAll();
		      
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		//enable these pages to be accessible even using spring security
	    web.ignoring().antMatchers("/signed");
	    web.ignoring().antMatchers("/signup");
	}
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	}
	

}
