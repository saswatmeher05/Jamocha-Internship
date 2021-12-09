package com.mybatis.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {
	private static SqlSessionFactory factory;

	private MyBatisConnectionFactory() {
	}

	static {
		try {
			Reader reader = Resources.getResourceAsReader("./SqlMapConfig.xml");
			if(factory==null) {
				factory=new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSessionFactory() {
		return factory;
	}
}
