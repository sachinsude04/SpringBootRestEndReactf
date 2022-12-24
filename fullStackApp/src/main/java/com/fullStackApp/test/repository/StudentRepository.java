package com.fullStackApp.test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fullStackApp.test.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	

	
	
	
	

}
