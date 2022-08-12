package com.college.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.college.VO.RequestTemplate;
import com.college.entity.College;

@Service
public interface CollegeService {
	College add(College dept);
	List<College> list();
	College update(long id,String name);
	College searchById(long id);
	List<RequestTemplate> listWithStu();
	RequestTemplate specificCollStudent(long coll_id);
}
