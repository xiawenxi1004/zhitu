package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.AllTeacher;
@Mapper
public interface AllTeacherMapper {
	List<AllTeacher> getAllInfo();
	List<AllTeacher> getByGrade();
}
