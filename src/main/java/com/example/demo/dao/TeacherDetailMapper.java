package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.AllTeacher;
@Mapper
	public interface TeacherDetailMapper {
	List<AllTeacher> getAllInfoDetail(@Param("id") Integer id);
	void UpdateIsCollect(@Param("id") Integer id);
	void UpdateAllIsCollect();
}
