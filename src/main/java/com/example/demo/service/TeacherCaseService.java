package com.example.demo.service;

import java.util.List;

import com.example.demo.model.TeacherCase;

public interface TeacherCaseService {
	List<TeacherCase> getAllCase(Integer teacherId);
}
