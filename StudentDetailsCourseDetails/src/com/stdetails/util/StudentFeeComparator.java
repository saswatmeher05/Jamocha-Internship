package com.stdetails.util;

import java.util.Comparator;

import com.stdetails.vo.StudentDetails;

public class StudentFeeComparator implements Comparator<StudentDetails> {
	public int compare(StudentDetails o1, StudentDetails o2) {
		if(o1.fee==o2.fee) {
			return 0;
		}else if(o1.fee>o2.fee) {
			return 1;
		}else {
			return -1;
		}
	}
}
