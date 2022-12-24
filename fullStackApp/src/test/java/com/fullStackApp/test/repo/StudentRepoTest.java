package com.fullStackApp.test.repo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fullStackApp.test.model.Student;
import com.fullStackApp.test.repository.StudentRepository;

@SpringBootTest
public class StudentRepoTest {
	
	@Autowired
	private StudentRepository repository;

	@Test
	void isPersonExistById() {
		
		Student student=new Student(12, "ramesh", "latur", 20.30);
		repository.save(student);
		
		//Boolean actualResult=repository.isStudentExistById(12);
		
		//assertThat(actualResult).isTrue();
	}
}
