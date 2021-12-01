package com.student.grad;

import java.util.ArrayList;

public class GraduationDetails {
	public String stdCourse;
	public int stdCount;
	public float totalFees;
	public ArrayList<StudentDetails> al;
	

	public GraduationDetails() {
	}

	public int getStdCount() {
		return stdCount;
	}

	public void setStdCount(int stdCount) {
		this.stdCount = stdCount;
	}

	public String getStdCourse() {
		return stdCourse;
	}

	public void setStdCourse(String stdCourse) {
		this.stdCourse = stdCourse;
	}

	public float getTotalFees() {
		return totalFees;
	}

	public void setTotalFees(float totalFees) {
		this.totalFees = totalFees;
	}

}
