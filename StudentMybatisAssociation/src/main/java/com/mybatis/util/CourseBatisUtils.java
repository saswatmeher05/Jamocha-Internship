package com.mybatis.util;

import com.mybatis.model.CourseMybatis;
import com.mybatis.model.StudentMybatis;

public class CourseBatisUtils {
	public static void printTableHeaderCourseOnly() {
		System.out.printf("%-5s","CID");
		System.out.printf("%-10s","Course");
		System.out.printf("%-8s","Fees");
		System.out.println();
	}
	public static void printTableHeaderStudentOnly() {
		System.out.printf("%-4s","SID");
		System.out.printf("%-20s","Sname");
		System.out.printf("%-3s","Student Age");
		System.out.println();
	}
	
	public static void printTableData(CourseMybatis batis) {
		System.out.printf("%-5s",batis.getCid());
		System.out.printf("%-10s",batis.getCname());
		System.out.printf("%-8s",batis.getCfees());
		System.out.println();
		CourseBatisUtils.printTableHeaderStudentOnly();
		for(StudentMybatis sbt:batis.getSbt()) {
			System.out.printf("%-4s",sbt.getSid());
			System.out.printf("%-20s",sbt.getSname());
			System.out.printf("%-3s",sbt.getSage());			
			System.out.println();
		}
	}
	
	public static void printTableHeaderAllData() {
		System.out.printf("%-5s","CID");
		System.out.printf("%-10s","Course");
		System.out.printf("%-8s","Fees");
		System.out.printf("%-4s","SID");
		System.out.printf("%-20s","Sname");
		System.out.printf("%-3s","Student Age");
		System.out.println();
	}
	
	public static void printTableAllData(CourseMybatis batis) {
		System.out.printf("%-5s",batis.getCid());
		System.out.printf("%-10s",batis.getCname());
		System.out.printf("%-8s",batis.getCfees());
		CourseBatisUtils.printTableHeaderStudentOnly();
		for(StudentMybatis sbt:batis.getSbt()) {
			System.out.printf("%-4s",sbt.getSid());
			System.out.printf("%-20s",sbt.getSname());
			System.out.printf("%-3s",sbt.getSage());			
			System.out.println();
		}
	}
}
