package com.crud.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCrudUtil {
	
	public static void printTableHeader() {
		System.out.printf("%-5s","ID");
		System.out.printf("%-15s","FirstName");
		System.out.printf("%-15s","LastName");
		System.out.printf("%-5s","Age");
		System.out.printf("%-10s","Gender");
		System.out.printf("%-20s","Subject");
		System.out.printf("%-12s","DOB");
		System.out.printf("%-40s","Address");
		System.out.println();
	}
	
	public static void printTableRows(ResultSet rs) throws SQLException {
		System.out.printf("%-5s",rs.getInt(8));
		System.out.printf("%-15s",rs.getString(1));
		System.out.printf("%-15s",rs.getString(2));
		System.out.printf("%-5s",rs.getInt(3));
		System.out.printf("%-10s",rs.getString(4));
		System.out.printf("%-20s",rs.getString(5));
		System.out.printf("%-12s",rs.getDate(6));
		System.out.printf("%-40s",rs.getString(7));
		System.out.println();
	}
}
