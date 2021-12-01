package com.stdetails.util;

import java.util.Comparator;

import com.stdetails.vo.StudentDetails;

public class StudentNameComparator implements Comparator<StudentDetails> {
	public int compare(StudentDetails o1, StudentDetails o2) {
		int result = 0;
		result = o1.name.toLowerCase().compareTo(o2.name.toLowerCase());
		if(result == 0)
		{
			result = o1.course.toLowerCase().compareTo(o2.course.toLowerCase());
		}
		
		if(result == 0)
		{
			if(o1.fee==o2.fee) {
				result=0;
			} else if(o1.fee>o2.fee){
				result=1;
			}else {
				result=-1;
			}
		}
		return result;
	}
}
