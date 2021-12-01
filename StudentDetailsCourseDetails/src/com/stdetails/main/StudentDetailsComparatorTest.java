package com.stdetails.main;

import java.util.ArrayList;
import java.util.Collections;

import com.stdetails.dao.StudentDetailsDAO;
import com.stdetails.util.StudentDetailsUtil;
import com.stdetails.util.StudentNameComparator;
import com.stdetails.vo.StudentDetails;

public class StudentDetailsComparatorTest {

	public static void main(String[] args) {
		StudentDetailsDAO dao=new StudentDetailsDAO();
		try {
			ArrayList<StudentDetails> al=dao.getUsers();
			
			Collections.sort(al,new StudentNameComparator());
			StudentDetailsUtil.printStudentDetailsTableHeader();
			StudentDetailsUtil.showStudentsList(al);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
