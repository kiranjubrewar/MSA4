package com.student.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String gender;
	private int age;
	private long dept_id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getDept_id() {
		return dept_id;
	}
	public void setDept_id(long dept_id) {
		this.dept_id = dept_id;
	}
	
	public Student(String name, String gender, int age, long dept_id) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.dept_id = dept_id;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + " , gender=" + gender + ", age=" + age
				+ ", dept_id=" + dept_id + "]";
	}
	
	
}
