package com.student.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*to instantiate SqlSessionFactory*/
public class MyBatisUtils {
	private static SqlSessionFactory sqlSessionFactory;
	private MyBatisUtils() {}
	static {
		Reader reader=null;
		try {
			reader=Resources.getResourceAsReader("./mybatis-config.xml");
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception e) {e.printStackTrace();}
	}
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
