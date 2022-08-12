package com.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findById(long id);

	@Query(value="SELECT * FROM student WHERE coll_id=:coll_id ORDER BY name ASC", nativeQuery = true)
	List<Student> getByCollId(@Param("coll_id") long coll_id);
	
	@Query(value="SELECT * FROM student WHERE coll_id=:coll_id ORDER BY age DESC", nativeQuery = true)
	List<Student> getStudentByCollegeWithDescAge(@Param("coll_id") long coll_id);
}
