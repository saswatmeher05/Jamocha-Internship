package com.student.grad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentGradTest {

	public static void main(String[] args) throws Exception {
		CollegeStudent ug = new UnderGraduate();
		CollegeStudent pg = new PostGraduate();
		ArrayList<StudentDetails> ugList = ug.processingGradDetails();
		ArrayList<StudentDetails> pgList = pg.processingGradDetails();

		Map<String, GraduationDetails> ugMap = new HashMap<String, GraduationDetails>();
		Map<String, GraduationDetails> pgMap = new HashMap<String, GraduationDetails>();

		System.out.println("|--UG List----------------------|");
		for (StudentDetails sdt : ugList) 
		{
			StudentGradUtil.printStudentDetailsList(sdt);
		}

		System.out.println();

		System.out.println("|--PG List----------------------|");
		for (StudentDetails sdt : pgList) 
		{
			StudentGradUtil.printStudentDetailsList(sdt);
		}

		System.out.println();

		for (StudentDetails details : ugList) 
		{
			if (ugMap.containsKey(details.getCourse())) 
			{
				GraduationDetails gd = ugMap.get(details.getCourse());
				gd.setStdCount(gd.getStdCount() + 1);
				gd.setTotalFees(gd.getTotalFees() + details.getFee());
				gd.al=new ArrayList<StudentDetails>();
				gd.al.add(details);
			}
			else 
			{
				GraduationDetails gd = new GraduationDetails();
				gd.setStdCourse(details.getCourse());
				gd.setStdCount(gd.getStdCount() + 1);
				gd.setTotalFees(gd.getTotalFees() + details.getFee());
				gd.al=new ArrayList<StudentDetails>();
				gd.al.add(details);
				ugMap.put(details.getCourse(), gd);
			}
		}

		for (StudentDetails details : pgList) 
		{
			if (pgMap.containsKey(details.getCourse())) 
			{
				GraduationDetails gd = pgMap.get(details.getCourse());
				gd.setStdCount(gd.getStdCount() + 1);
				gd.setTotalFees(gd.getTotalFees() + details.getFee());
				gd.al=new ArrayList<StudentDetails>();
				gd.al.add(details);
			} 
			else 
			{
				GraduationDetails gd = new GraduationDetails();
				gd.setStdCourse(details.getCourse());
				gd.setStdCount(gd.getStdCount() + 1);
				gd.setTotalFees(gd.getTotalFees() + details.getFee());
				gd.al=new ArrayList<StudentDetails>();
				gd.al.add(details);
				pgMap.put(details.getCourse(), gd);
			}
		}

		System.out.println("|--UG Details---------------------------------------------|");
		StudentGradUtil.printHeading();
		
		for (Map.Entry<String, GraduationDetails> entry : ugMap.entrySet()) 
		{
			GraduationDetails gd = entry.getValue();
			StudentGradUtil.printGraduationDetails(gd);
		}

		System.out.println();

		System.out.println("|--PG Details---------------------------------------------|");
		StudentGradUtil.printHeading();
		
		for (Map.Entry<String, GraduationDetails> entry : pgMap.entrySet()) 
		{
			GraduationDetails gd = entry.getValue();
			StudentGradUtil.printGraduationDetails(gd);
		}

	}

}
