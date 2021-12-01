package com.stdetails.main;

import java.util.ArrayList;
import java.util.Collections;

import com.stdetails.dao.StudentDetailsDAO;
import com.stdetails.util.StudentDetailsUtil;
import com.stdetails.vo.StudentDetails;

public class StudentDetailsComparableTest {

	public static void main(String[] args) {
		StudentDetailsDAO dao=new StudentDetailsDAO();
		try {
			ArrayList<StudentDetails> al=dao.getUsers();
			Collections.sort(al);
			StudentDetailsUtil.showStudentsList(al);
			
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
