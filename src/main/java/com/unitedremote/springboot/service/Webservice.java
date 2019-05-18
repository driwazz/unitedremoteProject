package com.unitedremote.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unitedremote.springboot.entities.Authorities;
import com.unitedremote.springboot.entities.Shops;
import com.unitedremote.springboot.entities.User;
import com.unitedremote.springboot.repository.AuthoritiesRepository;
import com.unitedremote.springboot.repository.ShopsRepository;
import com.unitedremote.springboot.repository.UserRepository;

@Service
public class Webservice {

	@Autowired
	UserRepository userRepository;
	@Autowired
	AuthoritiesRepository authorRepo;
	@Autowired
	ShopsRepository shopsRepo;
	
	
	public void register(User user) {
		user.setPassword("{noop}"+user.getPassword());
		userRepository.save(user);
		Authorities authorities = new Authorities();
		authorities.setauthority("ROLE_USER");
		authorities.setUser(user);
		authorRepo.save(authorities);
		Shops shop1 = new Shops("Kiaby",false,user.getUsername());
		Shops shop2 = new Shops("marjan",false,user.getUsername());
		Shops shop3 = new Shops("acima",false,user.getUsername());
		Shops shop4 = new Shops("bim",false,user.getUsername());
		Shops shop5 = new Shops("decathlon",false,user.getUsername());
		Shops shop6 = new Shops("carrefour",false,user.getUsername());
		Shops shop7 = new Shops("macro",false,user.getUsername());
		Shops shop8 = new Shops("abwab salam",false,user.getUsername());
		shopsRepo.save(shop1);shopsRepo.save(shop2);shopsRepo.save(shop3);
		shopsRepo.save(shop4);shopsRepo.save(shop5);shopsRepo.save(shop6);
		shopsRepo.save(shop7);shopsRepo.save(shop8);	
	}
	
	public List<Shops> selectShops(String username, boolean lik) {
		return shopsRepo.findAllShopsByUsers(username,lik);
	}
	
	public void likedShopsServ(Long id) {
		shopsRepo.likedShopRepo(id);
	}
	
	public void dislikedShopsServ(Long id) {
		shopsRepo.dislikedShopRepo(id);
	}
	
}
