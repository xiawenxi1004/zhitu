package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Subject;
@Mapper
public interface SubjectMapper {
	List<Subject>  selectAll();
}