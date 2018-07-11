package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Node;
import com.example.demo.model.ZhiTuResult;
import com.example.demo.service.IndexService;
import com.example.demo.service.TeacherListService;

@Controller
public class TeacherListController {
	@Autowired
	private TeacherListService teacherListService;
	@Autowired
	private IndexService indexService;
	@GetMapping("/teacherList")
	@ResponseBody
	public ZhiTuResult getTeacherList(@RequestParam(defaultValue="0")Integer grade,
			@RequestParam(defaultValue="0") Integer type,
			@RequestParam(defaultValue="0")Integer subject) {
		//默认显示
		if(grade==0&&type==0&&subject==0) {
			Node node=new Node();
			//获得所有老师信息
			ZhiTuResult all = indexService.getAll22();
			List list = (List)all.getData();
			//存入node
			node.setTeacher(list);
			return ZhiTuResult.ok(node);
		}

		ZhiTuResult teacherList = teacherListService.getTeacherList(grade, type, subject);
		List data = (List) teacherList.getData();
		Node node=new Node();
		node.setTeacher(data);
		return ZhiTuResult.ok(node);
	}
}
