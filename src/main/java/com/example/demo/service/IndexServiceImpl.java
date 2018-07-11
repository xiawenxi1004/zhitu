package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AllTeacherMapper;
import com.example.demo.dao.SubjectMapper;
import com.example.demo.dao.TeacherMapper;
import com.example.demo.model.AllTeacher;
import com.example.demo.model.AllTeacher2;
import com.example.demo.model.Grade;
import com.example.demo.model.Node;
import com.example.demo.model.Subject;
import com.example.demo.model.Teacher;
import com.example.demo.model.TeacherExample;
import com.example.demo.model.TeacherType;
import com.example.demo.model.ZhiTuResult;
import com.example.demo.util.NodeResult;

@Service
public class IndexServiceImpl implements IndexService{

	@Autowired
	private AllTeacherMapper allTeacherMapper;
	@Autowired
	private SubjectMapper subjectMapper;

//得到所有老师信息
	@Override
	public ZhiTuResult getAll22() {
		//从DAO层获取数据
		List<AllTeacher> allInfo = allTeacherMapper.getAllInfo();
		//尝试将其转化为前台页面所需要的json格式
		List<AllTeacher2> resultList=new ArrayList();
		for (AllTeacher allTeacher : allInfo) {
			AllTeacher2 result=new AllTeacher2();
			result.setId(allTeacher.getId());
			result.setRealname(allTeacher.getRealname());
			result.setName(allTeacher.getName());
			result.setImage(allTeacher.getImage());
			result.setTechtime(allTeacher.getTechtime());
			result.setTechyear(allTeacher.getTechyear());


			Subject subject=new Subject();
			Grade grade=new Grade();
			TeacherType teacherType=new TeacherType();

			subject.setId(Integer.parseInt(allTeacher.getSid()));
			subject.setLabel(allTeacher.getSlabel());
			result.setSubject(subject);

			grade.setId(Integer.parseInt(allTeacher.getGid()));
			grade.setLabel(allTeacher.getGlabel());
			result.setGrade(grade);

			teacherType.setId(Integer.parseInt(allTeacher.getTtid()));
			teacherType.setType(allTeacher.getType());
			result.setTeacherType(teacherType);
			//放入resultList中
			resultList.add(result);
		}
		return ZhiTuResult.ok(resultList);
	}






}
