package com.unitedremote.springboot.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.unitedremote.springboot.entities.User;

@Entity
@Table(name = "authorities")
public class Authorities implements Serializable{

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "user_role_id", unique = true, nullable = false)
	private Long userRoleId;
	
	@Column(name = "authority", nullable = false, length = 50)
	private String authority;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username", nullable = false, unique = true)
	private User user;
	
	

	public Authorities() {
	}

	public Authorities(User user, String authority) {
		this.user = user;
		this.authority = authority;
	}

	
	/*public Integer getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}*/

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getauthority() {
		return this.authority;
	}

	public void setauthority(String authority) {
		this.authority = authority;
	}

}
