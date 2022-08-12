package com.college.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.entity.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {

	College findById(long id);

//	@Query(value="SELECT e.* FROM employee e WHERE e.dept_id=:id ", nativeQuery = true)
//	List<Employee> empByDept(@Param("id") long id);
}
