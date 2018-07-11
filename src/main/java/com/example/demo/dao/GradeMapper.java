package com.example.demo.dao;

import com.example.demo.model.Grade;
import com.example.demo.model.GradeExample;
import com.example.demo.model.Subject;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradeMapper {
	List<Grade>  selectAll();

   
}