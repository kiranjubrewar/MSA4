package com.college.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.college.VO.Student;
import com.college.VO.RequestTemplate;
import com.college.entity.College;
import com.college.repository.CollegeRepository;
import com.college.service.CollegeService;

@Component
public class CollegeImpl implements CollegeService {

	@Autowired
	CollegeRepository collRepo;
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public College add(College coll) {
		return collRepo.save(coll);
	}

	@Override
	public List<College> list() {
		return collRepo.findAll();
	}

	@Override
	public College update(long id, String name) {
		College coll = collRepo.findById(id);
		coll.setName(name);
		return collRepo.save(coll);
	}

	@Override
	public College searchById(long id) {
		if(collRepo.findById(id)==null)
		{
			return null;
		}
		return collRepo.findById(id);
	}

	@Override
	public List<RequestTemplate> listWithStu() {
		List<RequestTemplate> fullList = new ArrayList<RequestTemplate>();
		List<College> allColl = this.list();
		Iterator<College> ir = allColl.iterator();
		while(ir.hasNext())
		{
			College clg = ir.next();
			ResponseEntity<Student[]> response =
					  restTemplate.getForEntity(
							  "http://STUDENT-SERVICE/student/student-with-ascname/"+clg.getId(),
					  Student[].class);
			Student[] students = response.getBody();
			List<Student> stds = Arrays.asList(students);
 			RequestTemplate RTm = new RequestTemplate();
			RTm.setCollege(clg);
			RTm.setStudentList(stds);
			fullList.add(RTm);
		}
		return fullList;
	}

	@Override
	public RequestTemplate specificCollStudent(long coll_id) {
		College college  = this.searchById(coll_id);
		
		ResponseEntity<Student[]> response =
				  restTemplate.getForEntity(
						  "http://STUDENT-SERVICE/student/student-with-desc-age/"+college.getId(),
				  Student[].class);
		Student[] std = response.getBody();
		List<Student> students = Arrays.asList(std);
		RequestTemplate requestTemplate = new RequestTemplate();
		
		requestTemplate.setCollege(college);
		requestTemplate.setStudentList(students);
		
		return requestTemplate;
	}

}
