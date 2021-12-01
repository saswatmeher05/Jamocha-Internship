package com.student.grad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PostGraduate implements CollegeStudent {

	@Override
	public ArrayList<StudentDetails> processingGradDetails() throws SQLException {
		Connection con = DBConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from studentdetails");
		ArrayList<StudentDetails> list = new ArrayList<StudentDetails>();
		while (rs.next()) {
			StudentDetails details = new StudentDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4));
			if(details.getCourse().equalsIgnoreCase("java")) {
				list.add(details);				
			}
		}
		return list;
	}
}
