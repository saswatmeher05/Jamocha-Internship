package com.student.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.student.vo.StudentVO;

public interface Student_Mapper {
	public final String insert="INSERT INTO STUDENT (name,age,gender,subject,dob,email) VALUES(#{name},#{age},#{gender},#{subject},#{dob},#{email})";
	public final String getAll="SELECT * FROM STUDENT";
	public final String getById="SELECT * FROM STUDENT WHERE id=#{id}";
	public final String deleteById="DELETE FROM STUDENT WHERE id=#{id}";
	public final String updateById="UPDATE STUDENT SET name=#{name},age=#{age},gender=#{gender},subject=#{subject},dob=#{dob},email=#{email} WHERE id=#{id}";
	
	@Select(getAll)
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="name", column="name"),
			@Result(property="age", column="age"),
			@Result(property="gender", column="gender"),
			@Result(property="subject", column="subject"),
			@Result(property="dob", column="dob"),
			@Result(property="email", column="email")
	})
	public List<StudentVO> getAll();
	
	@Select(getById)
	@Results(value= {
			@Result(property="id", column="id"),
			@Result(property="name", column="name"),
			@Result(property="age", column="age"),
			@Result(property="gender", column="gender"),
			@Result(property="subject", column="subject"),
			@Result(property="dob", column="dob"),
			@Result(property="email", column="email")
	})
	public StudentVO getById(int id);
	
	@Update(updateById)
	public void updateById(StudentVO vo);
	
	@Delete(deleteById)
	public void deleteById(int id);
	
	@Insert(insert)
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(StudentVO vo);
}
