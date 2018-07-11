package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CollectTeacherMapper {
	void insertCollTeacher(@Param("uid")Integer uid,@Param("tid")Integer tid);
	void deleteCollTeacher(@Param("uid")Integer uid,@Param("tid")Integer tid);
	
}
