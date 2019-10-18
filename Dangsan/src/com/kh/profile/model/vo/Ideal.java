package com.kh.profile.model.vo;

public class Ideal {
	private String religion;
	private String height;
	private String smoke;
	private String city;
	
	public Ideal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ideal(String religion, String height, String smoke, String city) {
		super();
		this.religion = religion;
		this.height = height;
		this.smoke = smoke;
		this.city = city;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getSmoke() {
		return smoke;
	}
	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
