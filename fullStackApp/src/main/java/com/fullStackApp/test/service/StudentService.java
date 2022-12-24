package com.fullStackApp.test.service;

import java.util.List;

import com.fullStackApp.test.model.Student;

public interface StudentService {
	
	public Student save(Student student);
	public List<Student> getAllStudent();
	public int deleteStudent(int id);
	public Student getStudentById(int id);
	public Student updateStudent(Student student,int id);
	public List<Student> getAllStudentPerPage(int offset,int pageSize);

}
