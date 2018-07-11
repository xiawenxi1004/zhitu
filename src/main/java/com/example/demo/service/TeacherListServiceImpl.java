package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TeacherListMapper;
import com.example.demo.model.AllTeacher;
import com.example.demo.model.AllTeacher2;
import com.example.demo.model.AllTeacher3;
import com.example.demo.model.Grade;
import com.example.demo.model.Subject;
import com.example.demo.model.TeacherType;
import com.example.demo.model.ZhiTuResult;
@Service
public class TeacherListServiceImpl implements TeacherListService{
	@Autowired
	private TeacherListMapper teacherMapper;
	@Override
	public ZhiTuResult getTeacherList(Integer grade,Integer type,Integer subject) {

		//改成方法2 allteacher3
		List<AllTeacher3> teacherList = teacherMapper.getTeacherList2(grade, type, subject);


		List<AllTeacher2> resultList = formatJson2(teacherList);
		return ZhiTuResult.ok(resultList);
		
	}
		//教师json格式转化为统一格式的方法  将Teacher 转成Teacher2
	public static List<AllTeacher2> formatJson(List<AllTeacher> list ) {
		List<AllTeacher2> resultList=new ArrayList();
		for (AllTeacher allTeacher : list) {
			AllTeacher2 result=new AllTeacher2();
			result.setId(allTeacher.getId());
			result.setRealname(allTeacher.getRealname());
			result.setName(allTeacher.getName());
			result.setImage(allTeacher.getImage());
			result.setTechtime(allTeacher.getTechtime());
			result.setTechyear(allTeacher.getTechyear());
		

			Subject sub=new Subject();
			Grade gra=new Grade();
			TeacherType teacherType=new TeacherType();

			sub.setId(Integer.parseInt(allTeacher.getSid()));
			sub.setLabel(allTeacher.getSlabel());
			result.setSubject(sub);

			gra.setId(Integer.parseInt(allTeacher.getGid()));
			gra.setLabel(allTeacher.getGlabel());
			result.setGrade(gra);

			teacherType.setId(Integer.parseInt(allTeacher.getTtid()));
			teacherType.setType(allTeacher.getType());
			result.setTeacherType(teacherType);
			//放入resultList中
			resultList.add(result);
		}
		return resultList;
	}
	
	
	
	//教师json格式转化为统一格式的方法  将AllTeacher3 转成AllTeacher2
	//为解决动态sql而写出的
		public static List<AllTeacher2> formatJson2(List<AllTeacher3> list ) {
			List<AllTeacher2> resultList=new ArrayList();
			for (AllTeacher3 allTeacher : list) {
				AllTeacher2 result=new AllTeacher2();
				result.setId(allTeacher.getId()+"");
				result.setRealname(allTeacher.getRealname());
				result.setName(allTeacher.getName());
				result.setImage(allTeacher.getImage());
				result.setTechtime(allTeacher.getTechtime());
				result.setTechyear(allTeacher.getTechyear());


				Subject sub=new Subject();
				Grade gra=new Grade();
				TeacherType teacherType=new TeacherType();

				sub.setId(allTeacher.getSid());
				sub.setLabel(allTeacher.getSlabel());
				result.setSubject(sub);

				gra.setId(allTeacher.getGid());
				gra.setLabel(allTeacher.getGlabel());
				result.setGrade(gra);

				teacherType.setId(allTeacher.getTtid());
				teacherType.setType(allTeacher.getType());
				result.setTeacherType(teacherType);
				//放入resultList中
				resultList.add(result);
			}
			return resultList;
		}
}
