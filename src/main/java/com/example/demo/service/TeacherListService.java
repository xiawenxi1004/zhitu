package com.example.demo.service;

import com.example.demo.model.ZhiTuResult;

public interface TeacherListService {
	ZhiTuResult getTeacherList(Integer grade,Integer type,Integer subject);
}
