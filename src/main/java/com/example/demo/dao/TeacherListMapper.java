package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.AllTeacher;
import com.example.demo.model.AllTeacher3;
@Mapper
public interface TeacherListMapper {
	List<AllTeacher> getTeacherList(@Param("gid")Integer gid,@Param("type")Integer type,
			@Param("sid") Integer sid);
	//为了解决动态sql 将这三个参数转化成Integer 利用mybatis int类型的0 是空字符串
	List<AllTeacher3> getTeacherList2(@Param("gid")Integer gid,@Param("type")Integer type,
			@Param("sid") Integer sid);
}
