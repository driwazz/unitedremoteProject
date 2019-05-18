package com.unitedremote.springboot.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.unitedremote.springboot.entities.Authorities;


@Entity
@Table(name = "users")
public class User {

		@Id
		@Column(name = "username", nullable = false, length = 50)
		private String username;
		
		@Column(name = "password", nullable = false, length = 50)
		private String password;
		
		@Column(name = "enabled", nullable = false)
		//@ColumnDefault("1")
		private byte enabled = 1;
		
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade=CascadeType.ALL)
		private Set<Authorities> userRole = new HashSet<Authorities>(0);
		
		/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade=CascadeType.ALL)
		private Set<Shops> userShops = new HashSet<Shops>(0);*/

		public User() {
		}

		public User(String username, String password, byte enabled) {
			this.username = username;
			this.password = password;
			this.enabled = enabled;
		}

		public User(String username, String password, 
			byte enabled, Set<Authorities> userRole) {
			this.username = username;
			this.password = password;
			this.enabled = enabled;
			this.userRole = userRole;
		}

		
		public String getUsername() {
			return this.username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		
		public String getPassword() {
			return this.password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Column(name = "enabled", nullable = false)
		public byte isEnabled() {
			return this.enabled;
		}

		public void setEnabled(byte enabled) {
			this.enabled = enabled;
		}

		
		public Set<Authorities> getUserRole() {
			return this.userRole;
		}

		public void setUserRole(Set<Authorities> userRole) {
			this.userRole = userRole;
		}

		/*public Set<Shops> getUserShops() {
			return userShops;
		}

		public void setUserShops(Set<Shops> userShops) {
			this.userShops = userShops;
		}*/

}
