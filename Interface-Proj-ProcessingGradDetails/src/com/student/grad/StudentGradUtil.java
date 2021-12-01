package com.student.grad;

public class StudentGradUtil {
	
	public static void printHeading() {
		System.out.printf("%-8s", "Subject");
		System.out.printf("%-15s", "StudentCount");
		System.out.printf("%-12s", "TotalFees");
		System.out.printf("%-20s", "Students");
		System.out.println();
	}
	
	public static void printStudentDetailsList(StudentDetails sdt) {
		System.out.printf("%-3s", sdt.getId());
		System.out.printf("%-14s", sdt.getName());
		System.out.printf("%-10s", sdt.getCourse());
		System.out.printf("%-8s", sdt.getFee());
		System.out.println();
	}
	
	public static void printGraduationDetails(GraduationDetails gd) {
		System.out.printf("%-8s", gd.getStdCourse());
		System.out.printf("%-15s", gd.getStdCount());
		System.out.printf("%-12s", gd.getTotalFees());
		String s = "";
		for (StudentDetails k : gd.al) 
		{
			s = s + k.getName() + ",";
		}
		s = s.substring(0, s.length() - 1);
//		gd.al.forEach(list->{System.out.print("|");System.out.print(list.getName());System.out.print("|");});
		System.out.printf("%-20s", s);
		System.out.println();
	}

}
