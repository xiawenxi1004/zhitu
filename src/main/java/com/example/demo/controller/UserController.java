package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.User;
import com.example.demo.model.ZhiTuResult;
import com.example.demo.service.UserService;
import com.example.demo.util.ExceptionUtil;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping(value="/register")
	@ResponseBody
	//注册控制器
	public ZhiTuResult doRegister(HttpServletRequest request) {
		try {
			User user=new User();
			//登录名
			String phone =  request.getParameter("phone");
			if (phone==""||phone==null) {
				return ZhiTuResult.build(400,"请输入账号");
			}
			//登录密码
			String code = request.getParameter("code");
			if(code==""||code==null) {
				return ZhiTuResult.build(400, "请输入密码");
			}
			user.setPhone(phone);
			user.setPassword(code);
			ZhiTuResult result = userService.createUser(user);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return ZhiTuResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
	}
	
	@PostMapping("/login")
	@ResponseBody
	//登录控制器
	public ZhiTuResult doLogin(HttpServletRequest request) {
		//登录名
		String phone =  request.getParameter("phone");
		
		//登录密码
		String password = request.getParameter("password");
		//转成对象
		User user=new User();
		user.setPhone(phone);
		user.setPassword(password);
		ZhiTuResult result;
		try {
			result = userService.doLogin(user);
			return result;
		} catch (Exception e) {
			
			e.printStackTrace();
			return ZhiTuResult.build(500,"登录失败,请检查账户密码");
		}
		
	}
	
	//查询所有收藏的教师
	@GetMapping("/collect")
	@ResponseBody
	public ZhiTuResult selectColl(@RequestParam(value="userId") Integer userId ,HttpServletRequest request) {
		ZhiTuResult result = userService.selectColl(userId);
		return result;
	}
	
}
