package com.student.vo;

public class StudentVO{
	private int id;
	private String name;
	private int age;
	private String gender;
	private String subject;
	private String dob;
	private String email;
	
	public StudentVO() {}
	
	public StudentVO(int id, String name, int age, String gender, String subject, String dob, String email) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.subject = subject;
		this.dob = dob;
		this.email = email;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
