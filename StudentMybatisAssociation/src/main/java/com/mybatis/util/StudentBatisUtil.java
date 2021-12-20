package com.mybatis.util;

import com.mybatis.model.StudentMybatis;

public class StudentBatisUtil {
//	public StringBuilder dynaQuery;
	public static void printTableHeaderStudentOnly() {
		System.out.printf("%-3s", "ID");
		System.out.printf("%-14s", "Name");
		System.out.printf("%-4s", "Age");
		System.out.printf("%-10s", "CourseID");
		System.out.println();
	}

	public static void printTableDataStudentOnly(StudentMybatis st) {
		System.out.printf("%-3s", st.getSid());
		System.out.printf("%-14s", st.getSname());
		System.out.printf("%-4s", st.getSage());
		System.out.printf("%-10s", st.getCid());
		System.out.println();
	}

	public static void printTableHeaderAllData() {
		System.out.printf("%-3s", "ID");
		System.out.printf("%-14s", "Name");
		System.out.printf("%-4s", "Age");
		System.out.printf("%-10s", "Course ID");
		System.out.printf("%-10s", "Course");
		System.out.printf("%-10s", "Course");
		System.out.println();
	}

	public static void printTableDataAll(StudentMybatis st) {
		System.out.printf("%-3s", st.getSid());
		System.out.printf("%-14s", st.getSname());
		System.out.printf("%-4s", st.getSage());
		System.out.printf("%-10s", st.getCid());
		System.out.printf("%-10s", st.getCb().getCname());
		System.out.printf("%-10s", st.getCb().getCfees());
		System.out.println();
	}

}
