package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CollectTeacherMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.AllTeacher2;
import com.example.demo.model.AllTeacher3;
import com.example.demo.model.Grade;
import com.example.demo.model.Node;
import com.example.demo.model.NodeCollTeacher;
import com.example.demo.model.Subject;
import com.example.demo.model.TeacherType;
import com.example.demo.model.User;
import com.example.demo.model.User2;
import com.example.demo.model.UserNode;
import com.example.demo.model.ZhiTuResult;
@Service
public class UserServiceImpl  implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Autowired 
	private CollectTeacherMapper collectTeacherMapper;
	//注册用户
	@Override
	public ZhiTuResult createUser(User user) {
		ZhiTuResult checkData = checkData(user.getPhone());
		if ((boolean) checkData.getData()) {
			userMapper.insertUser(user);
			return ZhiTuResult.ok();
		}
		return ZhiTuResult.build(500,  "This user already exists");

	}
	//可以注册ture  已存在 false不可以
	@Override
	public ZhiTuResult checkData(String phone) {
		List<User> list = userMapper.selectByPhone(phone);
		//从数据库中查询信息，为空表示可以注册
		if(list==null||list.size()==0){
			return ZhiTuResult.ok(true);
		}
		return ZhiTuResult.ok(false);
	}
	

	@Override
	public ZhiTuResult doLogin(User user) {
		List<User> list = userMapper.selectUser(user);
		//转化成user2
		if (list.size()!=0) {
			User user1 = list.get(0);
			User2 user2=new User2();
			user2.setName(user1.getPhone());
			user2.setUserId(user1.getUserId());
			//转成UserNode
			UserNode userNode=new UserNode();
			userNode.setUser(user2);
			return ZhiTuResult.ok(userNode);
		}
		return ZhiTuResult.build(500, "该用户尚未注册");
	}
	
	//收藏老师页面
	@Override
	public ZhiTuResult selectColl(Integer uid) {
		List<AllTeacher3>  collTeacherList = userMapper.selectColl(uid);
		List<AllTeacher2> collTeacher = formatJson2(collTeacherList);
		NodeCollTeacher node=new NodeCollTeacher();
		node.setTeacher(collTeacher);
		
		return ZhiTuResult.ok(node);
	}

	//转换类型
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
	
	//收藏教师
	@Override
	public ZhiTuResult addColl(Integer uid, Integer tid) {
		
		try {
			collectTeacherMapper.insertCollTeacher(uid, tid);
		} catch (Exception e) {
			e.printStackTrace();
			return ZhiTuResult.build(500, "收藏失败");
		}
		return ZhiTuResult.ok();
	}
	@Override
	public ZhiTuResult removeColl(Integer uid, Integer tid) {
		try {
			collectTeacherMapper.deleteCollTeacher(uid, tid);
		} catch (Exception e) {
			
			e.printStackTrace();
			ZhiTuResult.build(500, "取消收藏失败");
		}
		return ZhiTuResult.ok();
	}

}
