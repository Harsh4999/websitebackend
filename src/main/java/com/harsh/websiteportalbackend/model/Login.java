package com.harsh.websiteportalbackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {
	@Id
	private long rollno;
	private String password;
	public Login(long rollno, String password) {
		super();
		this.rollno = rollno;
		this.password = password;
	}
	public long getRollno() {
		return rollno;
	}
	public void setRollno(long rollno) {
		this.rollno = rollno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
