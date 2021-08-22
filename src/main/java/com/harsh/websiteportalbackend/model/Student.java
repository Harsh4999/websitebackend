package com.harsh.websiteportalbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name="rollNo")
	private	long rollNo;
	@Column(name="name")
	private String name;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="maths")
	private int maths;
	@Column(name="science")
	private int science;
	@Column(name="english")
	private int english;
	@Column(name="total")
	private int total;
	public Student() {};
	public Student(long rollNo, String name, String username, String password, int maths, int science, int english,
			int total) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.username = username;
		this.password = password;
		this.maths = maths;
		this.science = science;
		this.english = english;
		this.total = total;
	}
	public long getRollNo() {
		return rollNo;
	}
	public void setRollNo(long rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMaths() {
		return maths;
	}
	public void setMaths(int maths) {
		this.maths = maths;
	}
	public int getScience() {
		return science;
	}
	public void setScience(int science) {
		this.science = science;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
