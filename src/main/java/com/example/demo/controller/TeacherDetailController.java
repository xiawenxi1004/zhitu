package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.ZhiTuResult;
import com.example.demo.service.TeacherCaseService;
import com.example.demo.service.TeacherDetailService;

@Controller
public class TeacherDetailController {
	@Autowired
	private TeacherDetailService teacherDetailService;
	@Autowired
	private TeacherCaseService  teacherCaseService; 
	@GetMapping("/teacherDetail")
	@ResponseBody
	public ZhiTuResult getTeacherDetail(@RequestParam(value="userId",defaultValue="0")Integer uid,
			@RequestParam("id")Integer tid){
		ZhiTuResult result = teacherDetailService.getAllInfoDetail(uid, tid);
		return  result;
		
	}
	
	
	
}
