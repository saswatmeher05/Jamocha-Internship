package com.stdetails.util;

import java.util.Comparator;

import com.stdetails.vo.StudentDetails;

public class StudentCourseComparator implements Comparator<StudentDetails> {
	public int compare(StudentDetails o1, StudentDetails o2) {
//		if(o1.course.toLowerCase().compareTo(o2.course.toLowerCase())==0) {
//			return 0;
//		}else if(o1.course.toLowerCase().compareTo(o2.course.toLowerCase())>1) {
//			return 1;
//		}else {
//			return -1;
//		}
		
		return o1.course.toLowerCase().compareTo(o2.course.toLowerCase());
	}
}
