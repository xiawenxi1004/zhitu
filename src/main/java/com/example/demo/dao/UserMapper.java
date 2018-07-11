package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.AllTeacher3;
import com.example.demo.model.User;
import com.example.demo.model.Ut;
@Mapper
public interface UserMapper {
	
	void insertUser(User user);
	List<User> selectByPhone(String phone);
	List<User> selectUser(User user);
	List<AllTeacher3>  selectColl(Integer uid);
}
