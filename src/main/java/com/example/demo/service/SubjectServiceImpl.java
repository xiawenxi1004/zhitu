package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SubjectMapper;
import com.example.demo.model.Subject;
import com.example.demo.model.Subject2;
import com.example.demo.model.Subject3;
import com.example.demo.model.SubjectExample;
import com.example.demo.model.ZhiTuResult;
@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	private SubjectMapper subjectMapper;

	//数据连接对象DAO
	@Override
	public ZhiTuResult getAllSubject() {
		//查出所有学科
		SubjectExample example=new SubjectExample();
		List<Subject> subjects = subjectMapper.selectAll();
		//List<Subject> resultList=new ArrayList<>();
	List<Subject3> resultList=new ArrayList<>();
	
		//创建subject3，为了使json数据 name
		List<Subject3> subjects3=new ArrayList<>();
	for (Subject subject : subjects) {
			Subject3 subject3=new Subject3();
			subject3.setId(subject.getId());
			subject3.setName(subject.getLabel());
			subject3.setIcon(subject.getIcon());
			subjects3.add(subject3);
		}
/*		//截取出1-7的学科
		for(int i=1;i<7;i++) {
			resultList.add(subjects.get(i));
		}*/
	for(int i=1;i<6;i++) {
		resultList.add(subjects3.get(i));
	}
		//保存成对象
		Subject2 subject2=new Subject2();
		subject2.setSubject(resultList);
		return ZhiTuResult.ok(subject2);
		//return ZhiTuResult.ok(resultList);
	}

}
