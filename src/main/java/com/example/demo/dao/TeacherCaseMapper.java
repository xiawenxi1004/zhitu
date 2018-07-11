package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.TeacherCase;
@Mapper
public interface TeacherCaseMapper {
	List<TeacherCase> getAllCase(Integer tid);
}
