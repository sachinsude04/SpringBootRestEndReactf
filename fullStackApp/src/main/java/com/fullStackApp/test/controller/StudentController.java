package com.fullStackApp.test.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fullStackApp.test.model.Student;
import com.fullStackApp.test.service.StudentService;

@RestController
@CrossOrigin
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	private Logger logger=LoggerFactory.getLogger(StudentController.class);
	
	@PostMapping("/student")
	public ResponseEntity<Student> save(@RequestBody Student student) {
		
		Student student2=null;
		try {
			student2=studentService.save(student);
			System.out.println(student2);
			return ResponseEntity.of(Optional.of(student2));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		 
	}
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getAllStudent()
	{
		List<Student> list=studentService.getAllStudent();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		else
			return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/student/{offset}/{pagesize}")
	public ResponseEntity<List<Student>> getAllStudentPerpage(@PathVariable("offset") int offset,@PathVariable("pagesize") int pageSize)
	{
		List<Student> list=studentService.getAllStudentPerPage(offset,pageSize);
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		else
			return ResponseEntity.of(Optional.of(list));
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable("id") int id)
	{
		
		System.out.println("in  delete controller"+id);
		try {
		      studentService.deleteStudent(id);
		      return ResponseEntity.ok().build();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
		
		Student student= studentService.getStudentById(id);
		if (student==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.of(Optional.of(student));
		}
	}
	
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody() Student student,@PathVariable("id") int id) {
		
		try {
		studentService.updateStudent(student,id);
		return ResponseEntity.ok().body(student);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	} 
	
	@PostMapping("/student-image")
	public ResponseEntity<?> uploadImage(@RequestParam("images") MultipartFile[] files){
		
		Arrays.stream(files).forEach(file->{
			logger.info("file name: {}",file.getOriginalFilename());
			logger.info("file content: {}",file.getContentType());
			logger.info("file size: {}",file.getSize());
			System.out.println("*****************************");
		});
		return ResponseEntity.ok("file Uploaded");
	}
	
}
