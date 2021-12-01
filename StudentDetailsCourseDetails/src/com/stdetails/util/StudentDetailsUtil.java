package com.stdetails.util;

import java.util.ArrayList;

import com.stdetails.vo.StudentDetails;

public class StudentDetailsUtil {
	public static void showStudentsList(ArrayList<StudentDetails> al) {
		for(StudentDetails st:al) {
			System.out.printf("%-3s",st.getId());
			System.out.printf("%-14s",st.getName());
			System.out.printf("%-11s",st.getCourse());
			System.out.printf("%-8s",+st.getFee());
			System.out.println();
		}
	}

	public static void printStudentDetailsTableHeader() {
		System.out.printf("%-3s","ID");
		System.out.printf("%-14s","Name");
		System.out.printf("%-11s","Course");
		System.out.printf("%-8s","Fees");
		System.out.println();
	}
}
