package com.college.VO;

public class Student {
		private long id;
		private String name;
		private double salary;
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
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public long getDept_id() {
			return dept_id;
		}
		public void setDept_id(long dept_id) {
			this.dept_id = dept_id;
		}

		public Student(String name, double salary, String gender, int age, long dept_id) {
			super();
			this.name = name;
			this.salary = salary;
			this.gender = gender;
			this.age = age;
			this.dept_id = dept_id;
		}
		public Student() {
			super();
		}
}
