package com.college.VO;

import java.util.ArrayList;
import java.util.List;

import com.college.entity.College;

public class RequestTemplate {

	private College college;
	private List<Student> studentList = new ArrayList<Student>();
	
	
	public RequestTemplate(College college, List<Student> studentList) {
		super();
		this.college = college;
		this.studentList = studentList;
	}


	public College getCollege() {
		return college;
	}


	public void setCollege(College college) {
		this.college = college;
	}


	public List<Student> getStudentList() {
		return studentList;
	}


	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}


	public RequestTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
