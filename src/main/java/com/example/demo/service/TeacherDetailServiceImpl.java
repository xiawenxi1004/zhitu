package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TeacherCaseMapper;
import com.example.demo.dao.TeacherDetailMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.AllTeacher;
import com.example.demo.model.AllTeacher2;
import com.example.demo.model.AllTeacher3;
import com.example.demo.model.Grade;
import com.example.demo.model.NodeCollTeacher;
import com.example.demo.model.NodeTeacherCase;
import com.example.demo.model.Subject;
import com.example.demo.model.TeacherCase;
import com.example.demo.model.TeacherExperience;
import com.example.demo.model.TeacherType;
import com.example.demo.model.ZhiTuResult;
@Service
public class TeacherDetailServiceImpl implements TeacherDetailService {
	@Autowired
	private TeacherDetailMapper teacherDetailMapper;
	@Autowired
	private  UserMapper userMapper;

	@Override
	public ZhiTuResult getAllInfoDetail(Integer uid,Integer tid) {
		
		//判断用户是否登录
		if (uid!=0) {
			//该用户收藏的教师列表
			List<AllTeacher3> collTeaList = userMapper.selectColl(uid);
			//将是否被收藏置为1  1表示被收藏
			for (AllTeacher3 teacher3 : collTeaList) {
				//更新当前教师isCollect字段
				Integer id = teacher3.getId();
				teacherDetailMapper.UpdateIsCollect(id);
				//teacher3.setIsCollect(1);
			} 
		}else {
			teacherDetailMapper.UpdateAllIsCollect();
		}
			List<AllTeacher> teacherDetailList = teacherDetailMapper.getAllInfoDetail(tid);
			List<AllTeacher2> resultList = formatJson(teacherDetailList);
			NodeCollTeacher node=new NodeCollTeacher();
			node.setTeacher(resultList);
			return ZhiTuResult.ok(node);
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
				result.setIsCollect(allTeacher.getIsCollect());
				result.setPrice(allTeacher.getPrice());
				result.setIntro(allTeacher.getIntro());
				
				Subject sub=new Subject();
				Grade gra=new Grade();
				TeacherCase teachercase=new TeacherCase();
				TeacherExperience teacherExperience=new TeacherExperience();
				TeacherType teacherType=new TeacherType();

				sub.setId(Integer.parseInt(allTeacher.getSid()));
				sub.setLabel(allTeacher.getSlabel());
				result.setSubject(sub);

				gra.setId(Integer.parseInt(allTeacher.getGid()));
				gra.setLabel(allTeacher.getGlabel());
				result.setGrade(gra);
				
				if ( !(allTeacher.getTeteacherId()== null) && !(allTeacher.getTeteacherId() == "") ) {
				teachercase.setId(Integer.parseInt(allTeacher.getTcuserId()));
				
				teachercase.setTitle(allTeacher.getTctitle());
				teachercase.setContent(allTeacher.getTccontent());
				NodeTeacherCase nodeTeacherCase=new NodeTeacherCase();
				List<TeacherCase> teacherCase = new ArrayList<>();
				teacherCase.add(teachercase);
				nodeTeacherCase.setTeacherCases(teacherCase);
				result.setTeacherCase(teacherCase);
				//result.setTeacherCase(teacherCase);
				}
				
				if ( !(allTeacher.getTeteacherId()== null) && !(allTeacher.getTeteacherId() == "") ) {
					teacherExperience.setId(Integer.parseInt(allTeacher.getTeteacherId()));
			
				teacherExperience.setTitle(allTeacher.getTetitle());
				teacherExperience.setContent(allTeacher.getTecontent());
				}
				result.setTeacherExperience(teacherExperience);
				
				
				teacherType.setId(Integer.parseInt(allTeacher.getTtid()));
				teacherType.setType(allTeacher.getType());
				result.setTeacherType(teacherType);
				//放入resultList中
				resultList.add(result);
			}
			return resultList;
		}
	
}
