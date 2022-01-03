package com.employee.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnectionFactory {
	
	private static SqlSessionFactory factory;
	
	private MybatisConnectionFactory(){};
	
	static {
		try {
			Reader reader=Resources.getResourceAsReader("resources/mybatis-config.xml");
			factory=new SqlSessionFactoryBuilder().build(reader);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSessionFactory() {
		return factory;
	}
}
