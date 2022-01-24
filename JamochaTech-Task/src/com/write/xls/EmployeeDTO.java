package com.write.xls;

public class EmployeeDTO {
	private String fname,lname,gender,desg,skills,doj,city,state;
	private int age;
	
	public EmployeeDTO(String fname, String lname,int age, String gender, String desg, String skills, String doj, String city,
			String state) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.desg = desg;
		this.skills = skills;
		this.doj = doj;
		this.city = city;
		this.state = state;
		this.age = age;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
