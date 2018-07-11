package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.BannerMapper;
import com.example.demo.model.AllTeacher2;
import com.example.demo.model.Banner;
import com.example.demo.model.BannerExample;
import com.example.demo.model.Node;
import com.example.demo.model.Subject;
import com.example.demo.model.Subject2;
import com.example.demo.model.Subject3;
import com.example.demo.model.Teacher;
import com.example.demo.model.ZhiTuResult;
import com.example.demo.service.IndexService;
import com.example.demo.service.SubjectService;
import com.example.demo.util.NodeResult;

@Controller

public class IndexController {
	@Autowired
	private IndexService indexService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private BannerMapper bannerMapper;


	@GetMapping("/showIndex2")
	@ResponseBody
	public ZhiTuResult showIndex2() {
		ZhiTuResult all = indexService.getAll22();
		return all;
	}

	@GetMapping("/accept")
	@ResponseBody
	public ZhiTuResult accept() {
		Node node=new Node();
		//获得所有老师信息
		ZhiTuResult all = indexService.getAll22();
		List list = (List)all.getData();
		//存入node
		node.setTeacher(list);
		//获得五个学科的信息
		ZhiTuResult allSubject = subjectService.getAllSubject();
		Subject2 data = (Subject2) allSubject.getData();
	
		List<Subject3> subjectList= data.getSubject();
		//存入node

		node.setSubjects(subjectList);
		//获得轮播图信息	
		BannerExample example=new BannerExample();
		List<Banner> banners = bannerMapper.selectByExample(example);
		node.setBanner(banners);
		return ZhiTuResult.ok(node);

	}
	

}