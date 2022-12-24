package com.fullStackApp.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fullStackApp.test.model.Student;
import com.fullStackApp.test.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}
	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll(); //here 200 error code it means we are getting availabe list of object 200 means ok status code
//		List<Student> list=new ArrayList();
//		return list;  //if i set empty list then in postman i received 404 error code not found 
	}
	@Override
	public int deleteStudent(int id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
		return 1;
	}
	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get();
	}
	@Override
	public Student updateStudent(Student student, int id) {
		// TODO Auto-generated method stub
		
		return studentRepository.save(student);
	}
	@Override
	public List<Student> getAllStudentPerPage(int offset, int pageSize) {
		// TODO Auto-generated method stub
		
		Pageable pageable=PageRequest.of(offset, pageSize);
		
		Page<Student> page=studentRepository.findAll(pageable);
		
		
		List<Student> content = page.getContent();
		return content;
				
				
	}

}
