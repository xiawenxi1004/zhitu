package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.ZhiTuResult;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/collect")
public class CollectController {
	@Autowired
	private UserService userService;
	//添加收藏
	@GetMapping("/add")
	@ResponseBody
	public ZhiTuResult addCollTeacher(@RequestParam("userId")Integer userId,@RequestParam("tid")Integer tid) {
		return userService.addColl(userId, tid);
	}

	//取消收藏
	@GetMapping("/del")
	@ResponseBody
	public ZhiTuResult removeCollTeacher(@RequestParam("userId")Integer userId,@RequestParam("tid")Integer tid) {
		
		return userService.removeColl(userId, tid);
	}


}
