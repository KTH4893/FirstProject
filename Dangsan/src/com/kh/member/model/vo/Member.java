package com.kh.member.model.vo;

import java.sql.Date;

public class Member {
	private String id;
	private String pw;
	private String name;
	private Date birth;
	private String gender;
	private String phone;
	private String email;
	private String grade;
	private Date enrollDate;
<<<<<<< HEAD
	private int age; 
	private int blockCount;
	private String photopath;
	private String photoname;
=======
	private int age;
	private int blockCount;
	private String photopath;
	private String photoname;
<<<<<<< HEAD
=======
	
>>>>>>> d2ea2537b9be55e62062b94e1074354f41cb6858
>>>>>>> ee340be8a12028d82746491911757d9be61f64d7
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String id, String pw, String name, Date birth, String gender, String phone, String email,
			String grade, Date enrollDate, int age, int blockCount, String photopath, String photoname) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.grade = grade;
		this.enrollDate = enrollDate;
		this.age = age;
		this.blockCount = blockCount;
		this.photopath = photopath;
		this.photoname = photoname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getBlockCount() {
		return blockCount;
	}
	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}
	public String getPhotopath() {
		return photopath;
	}
	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}
	public String getPhotoname() {
		return photoname;
	}
	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}
	
	
<<<<<<< HEAD
	
	
=======
<<<<<<< HEAD
	
=======
>>>>>>> d2ea2537b9be55e62062b94e1074354f41cb6858
>>>>>>> ee340be8a12028d82746491911757d9be61f64d7
}
