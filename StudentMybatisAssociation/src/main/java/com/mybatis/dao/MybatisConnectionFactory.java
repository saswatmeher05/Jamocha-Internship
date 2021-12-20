package com.mybatis.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnectionFactory {
	private static SqlSessionFactory factory;

	private MybatisConnectionFactory() {
	}

	static {
		try {
			String resource = "mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			factory = new SqlSessionFactoryBuilder().build(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionfactory() {
		return factory;
	}
}
