package com.unitedremote.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shops")
public class Shops {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private boolean liked;
	private String username;
	
	
	public Shops() {
		super();
	}
	public Shops(String nom, boolean liked, String username) {
		super();
		this.nom = nom;
		this.liked = liked;
		this.username = username;
	}
	public Shops(Long id, String nom, boolean liked) {
		super();
		this.id = id;
		this.nom = nom;
		this.liked = liked;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public boolean isLiked() {
		return liked;
	}
	public void setLiked(boolean liked) {
		this.liked = liked;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
