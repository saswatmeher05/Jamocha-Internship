package com.stdetails.vo;

public class CourseDetails {
	public String courseName;
	public int stdCount;
	public float totalFees;
	public CourseDetails() {}
	public CourseDetails(String courseName, int stdCount, float totalFees) {
		this.courseName = courseName;
		this.stdCount = stdCount;
		this.totalFees = totalFees;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getStdCount() {
		return stdCount;
	}
	public void setStdCount(int stdCount) {
		this.stdCount = stdCount;
	}
	public float getTotalFees() {
		return totalFees;
	}
	public void setTotalFees(float totalFees) {
		this.totalFees = totalFees;
	}
	
	
}
