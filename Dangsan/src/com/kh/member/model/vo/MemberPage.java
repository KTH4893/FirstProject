package com.kh.member.model.vo;

import java.util.ArrayList;

public class MemberPage {
	private Profile profile;
	private int age;
	private String photo;
	private int heart;
	
	public MemberPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberPage(Profile profile, int age, String photo, int heart) {
		super();
		this.profile = profile;
		this.age = age;
		this.photo = photo;
		this.heart = heart;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getHeart() {
		return heart;
	}
	public void setHeart(int heart) {
		this.heart = heart;
	}
	
	
	
	
}
