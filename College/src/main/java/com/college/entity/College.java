package com.college.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int noOfStu;
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
	public int getNoOfStu() {
		return noOfStu;
	}
	public void setNoOfStu(int noOfStu) {
		this.noOfStu = noOfStu;
	}
	public College(String name, int noOfStu) {
		super();
		this.name = name;
		this.noOfStu = noOfStu;
	}
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
