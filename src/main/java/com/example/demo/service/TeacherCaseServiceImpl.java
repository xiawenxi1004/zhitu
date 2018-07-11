package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TeacherCaseMapper;
import com.example.demo.model.TeacherCase;
@Service
public class TeacherCaseServiceImpl implements TeacherCaseService {

	@Autowired
	private TeacherCaseMapper teacherCaseMapper;
	@Override
	public List<TeacherCase> getAllCase(Integer teacherId) {
		List<TeacherCase> allCase = teacherCaseMapper.getAllCase(teacherId);
		return allCase;
	}

}
