package com.example.demo.model;

import java.util.List;

public class Node {
	private List<AllTeacher> teacher;
	private List<Subject3> subjects;
	private List<Banner> banner;
	
	
	public List<Banner> getBanner() {
		return banner;
	}
	public void setBanner(List<Banner> banner) {
		this.banner = banner;
	}
	public List<AllTeacher> getTeacher() {
		return teacher;
	}
	public void setTeacher(List<AllTeacher> teacher) {
		this.teacher = teacher;
	}
	public List<Subject3> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject3> subjects) {
		this.subjects = subjects;
	}


	
	
	
	
}
