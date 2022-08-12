package com.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.VO.ResponseTemplate;
import com.student.entity.Student;

@Service
public interface StudentService {
	
	Student add(Student stu);
	List<Student> list();
	Student searchById(long id);
	ResponseTemplate stuWithColl(long stuId);
	Student assignCollege(long stuId, long collId);
	List<Student> getByCollId(long coll_id);
	List<Student> getStudentByCollegeWithDescAge(long coll_id);
}
