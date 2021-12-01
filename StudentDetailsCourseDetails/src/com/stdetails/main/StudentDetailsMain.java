package com.stdetails.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.stdetails.dao.StudentDetailsDAO;
import com.stdetails.vo.CourseDetails;
import com.stdetails.vo.StudentDetails;

public class StudentDetailsMain {

	public static void main(String[] args) throws Exception {
		StudentDetailsDAO dao = new StudentDetailsDAO();

		ArrayList<StudentDetails> list = dao.getUsers();
		Map<String, CourseDetails> map = new HashMap<String, CourseDetails>();
		for (StudentDetails st : list) {
			String course=st.getCourse();
			if(map.containsKey(course)) {
				CourseDetails details=map.get(st.getCourse());
//				details.setCourseName(st.getCourse());
				details.setStdCount(details.getStdCount()+1);
				details.setTotalFees(details.getTotalFees()+st.getFee());
				
			}else {
				CourseDetails details=new CourseDetails();
				details.setCourseName(course);
				details.setStdCount(details.getStdCount()+1);
				details.setTotalFees(details.getTotalFees()+st.getFee());
				map.put(course, details);
			}
		}
		
		System.out.printf("%-8s","Course");
		System.out.printf("%-13s","StudentList");
		System.out.printf("%-8s","TotalFees");
		System.out.println();
			System.out.println("-------------------------------");
		
		for(Map.Entry<String, CourseDetails> entry:map.entrySet()) {
			CourseDetails dt=entry.getValue();
			
			System.out.printf("%-8s",dt.getCourseName());
			System.out.printf("%-13s",dt.getStdCount());
			System.out.printf("%-8s",dt.getTotalFees());
			System.out.println();
		}
	}
}
