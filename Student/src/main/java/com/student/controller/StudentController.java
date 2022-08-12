package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.VO.ResponseTemplate;
import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService stuService;
	
	@PostMapping
	public Student add(@RequestBody Student stu)
	{
		return stuService.add(stu);
	}
	
	@GetMapping
	public List<Student> liststu(){
		return stuService.list();
	}
	
	@GetMapping("/{stuId}")
	public ResponseTemplate stuWithColl(@PathVariable long stuId)
	{
		return stuService.stuWithColl(stuId);
	}
	
	@PutMapping("/{stuId}/{collId}")
	public String updateCollege(@PathVariable long stuId,@PathVariable long collId)
	{
		Student stu = stuService.assignCollege(stuId,collId);
		if(stu!=null)
		{
			return stu.toString();
		}
		return "Sorry. Department or Employee Not Found";
	}
	
	@GetMapping("/student-with-ascname/{coll_id}")
	public List<Student> getByCollId(@PathVariable long coll_id)
	{
		return stuService.getByCollId(coll_id);
	}
	
	@GetMapping("/student-with-desc-age/{coll_id}")
	public List<Student> getStudentByCollegeWithDescAge(@PathVariable long coll_id)
	{
		return stuService.getStudentByCollegeWithDescAge(coll_id);
	}
}







