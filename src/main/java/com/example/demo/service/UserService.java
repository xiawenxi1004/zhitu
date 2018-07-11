package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.ZhiTuResult;


public interface UserService {
	ZhiTuResult checkData(String phone);
	ZhiTuResult createUser(User user);
	ZhiTuResult doLogin(User user);
	ZhiTuResult selectColl(Integer uid);
	ZhiTuResult addColl(Integer uid,Integer tid);
	ZhiTuResult removeColl(Integer uid,Integer tid);
}
