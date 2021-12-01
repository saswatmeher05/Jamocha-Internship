package com.student.grad;


public class StudentDetails{
	public int id;
	public String name;
	public String course;
	public float fee;
	
	public StudentDetails() {}
	
	public StudentDetails(int id, String name, String course, float fee) {
		this.id = id;
		this.name = name;
		this.course = course;
		this.fee = fee;
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
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
	
}