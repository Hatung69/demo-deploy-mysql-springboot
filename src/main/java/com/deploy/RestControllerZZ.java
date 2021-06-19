package com.deploy;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deploy.enities.Student;
import com.deploy.repo.StudentRepo;

@RestController
@CrossOrigin(origins="*")// in this line add your url and thats is all for spring boot side
public class RestControllerZZ {
	static final Logger log = Logger.getLogger(RestControllerZZ.class);

	@Autowired
	private StudentRepo studentRepo;

	@Value("${my.word}")
	private String myWord;

	@GetMapping("api/v1/hello")
	public String hello() {
		return myWord;
	}

	// Get list Student
	@GetMapping("api/v1/students")
	public ResponseEntity<List<Student>> getListStudent() {
		List<Student> students = (List<Student>) studentRepo.findAll();
		return ResponseEntity.ok(students);
	}

	// Get list Student
	@PostMapping("api/v1/students")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		studentRepo.save(student);
		return new ResponseEntity<Student>(student, HttpStatus.CREATED);
	}
}
