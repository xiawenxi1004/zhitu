package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.ZhiTuResult;
import com.example.demo.service.SubjectService;

@Controller
public class SubjectController {
	@Autowired
	private SubjectService subjectService;
	@GetMapping("/getSubjects")
	@ResponseBody
	public ZhiTuResult getSubjects() {
	
			return  subjectService.getAllSubject();
	}
}
