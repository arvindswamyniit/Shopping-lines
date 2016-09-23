package com.cart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserRole {
	@Id
	private int uid;
	private String authority;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
