package com.stdetails.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.stdetails.vo.StudentDetails;

public class StudentDetailsDAO {
	Connection con;

	public ArrayList<StudentDetails> getUsers() throws SQLException {
		con=DBConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from studentdetails");
		ArrayList<StudentDetails> al=new ArrayList<StudentDetails>();
		while(rs.next()) {
			StudentDetails details=new StudentDetails();
			details.setId(rs.getInt(1));
			details.setName(rs.getString(2));
			details.setCourse(rs.getString(3));
			details.setFee(rs.getFloat(4));
			al.add(details);
		}
		return al;
	}
}
