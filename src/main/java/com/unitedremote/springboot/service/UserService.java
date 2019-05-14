package com.unitedremote.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unitedremote.springboot.entities.Authorities;
import com.unitedremote.springboot.entities.User;
import com.unitedremote.springboot.repository.AuthorityRepository;
import com.unitedremote.springboot.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository uRepo;
	
	@Autowired
	AuthorityRepository autRepo;
	
	public void insertauth(User u) {
		Authorities authority = new Authorities(u,"ROLE_USER");
		autRepo.save(authority);
	}
	
	public void insert(User u) {
		uRepo.save(u);
	}
	

}
