package com.kh.member.model.vo;

public class Profile {
	private String Id;
	private String intro;
	private int height;
	private String blood;
	private String job;
	private String hobby;
	private int heart;
	private String religion;
	private String smoke;
	private String city;
	private int age;
	private String photoName;
	private String photoPath;
	
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profile(String id, String intro, int height, String blood, String job, String hobby, int heart,
			String religion, String smoke, String city, int age, String photoName, String photoPath) {
		super();
		Id = id;
		this.intro = intro;
		this.height = height;
		this.blood = blood;
		this.job = job;
		this.hobby = hobby;
		this.heart = heart;
		this.religion = religion;
		this.smoke = smoke;
		this.city = city;
		this.age = age;
		this.photoName = photoName;
		this.photoPath = photoPath;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public int getHeart() {
		return heart;
	}
	public void setHeart(int heart) {
		this.heart = heart;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	
	
	
}
