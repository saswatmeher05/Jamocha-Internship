package com.student.util;

import com.student.vo.StudentVO;

public class StudentUtil {
	public static void printTableHeader() {
		System.out.printf("%-3s","ID");
		System.out.printf("%-20s","Name");
		System.out.printf("%-5s","Age");
		System.out.printf("%-8s","Gender");
		System.out.printf("%-12s","Subject");
		System.out.printf("%-12s","DOB");
		System.out.printf("%-25s","Email");
		System.out.println();
	}
	public static void printTableData(StudentVO vo) {
		System.out.printf("%-3s",vo.getId());
		System.out.printf("%-20s",vo.getName());
		System.out.printf("%-5s",vo.getAge());
		System.out.printf("%-8s",vo.getGender());
		System.out.printf("%-12s",vo.getSubject());
		System.out.printf("%-12s",vo.getDob());
		System.out.printf("%-25s",vo.getEmail());
		System.out.println();
	}

}
