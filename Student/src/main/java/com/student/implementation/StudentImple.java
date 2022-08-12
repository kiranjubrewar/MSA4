package com.student.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.student.VO.College;
import com.student.VO.ResponseTemplate;
import com.student.entity.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;

@Component
public class StudentImple implements StudentService {

	@Autowired
	private StudentRepository stuRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Student add(Student stu) {
		return stuRepo.save(stu);
	}

	@Override
	public List<Student> list() {
		return stuRepo.findAll();
	}

	@Override
	public Student searchById(long id) {
		return stuRepo.findById(id);
	}

	@Override
	public ResponseTemplate stuWithColl(long stuId) {
		ResponseTemplate RT = new ResponseTemplate();
		Student stu = stuRepo.findById(stuId);
		
		long coll_id = stu.getId();
		College coll = restTemplate.getForObject("http://COLLEGE-SERVICE/college/"+coll_id, College.class);
		RT.setCollege(coll);
		RT.setStudent(stu);
		return RT;
	}

	@Override
	public Student assignCollege(long stuId, long collId) {
		Student stu = stuRepo.findById(stuId);
		College coll = restTemplate.getForObject("http://COLLEGE-SERVICE/college/"+collId, College.class);
		if(stu==null || coll==null)
		{
			return null;
		}
		stu.setId(collId);
		stuRepo.save(stu);
		return stu;
	}

	@Override
	public List<Student> getByCollId(long coll_id) {
		return stuRepo.getByCollId(coll_id);
	}

	@Override
	public List<Student> getStudentByCollegeWithDescAge(long coll_id) {
		return stuRepo.getStudentByCollegeWithDescAge(coll_id);
	}
	

}
