package com.example.demo.model;

import java.util.List;

/*
 * 为了将json老师那里转化成数组
 */
public class AllTeacher2 {
	private String id;
	private String realname;
	private String name;
	private String image;
	private Subject subject;
	private Grade grade;
	private TeacherType teacherType;
	private Integer price;
	private Integer isCollect;
	private String intro;
	//private TeacherCase teacherCase;
	private List<TeacherCase> teacherCase;
	

	public List<TeacherCase> getTeacherCase() {
		return teacherCase;
	}

	public void setTeacherCase(List<TeacherCase> teacherCase) {
		this.teacherCase = teacherCase;
	}

	private TeacherExperience teacherExperience; 
	
	public TeacherExperience getTeacherExperience() {
		return teacherExperience;
	}

	public void setTeacherExperience(TeacherExperience teacherExperience) {
		this.teacherExperience = teacherExperience;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Integer getIsCollect() {
		return isCollect;
	}

	public void setIsCollect(Integer isCollect) {
		this.isCollect = isCollect;
	}
	public TeacherType getTeacherType() {
		return teacherType;
	}

	public void setTeacherType(TeacherType teacherType) {
		this.teacherType = teacherType;
	}

	private String techtime;
	private String techyear;
	

	public String getTechtime() {
		return techtime;
	}

	public void setTechtime(String techtime) {
		this.techtime = techtime;
	}

	public String getTechyear() {
		return techyear;
	}

	public void setTechyear(String techyear) {
		this.techyear = techyear;
	}

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}


	

	
}
