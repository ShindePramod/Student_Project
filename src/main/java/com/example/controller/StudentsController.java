package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Services.StudentService;
import com.example.model.Students;

@RestController
@RequestMapping("/")
public class StudentsController {

	@Autowired
	StudentService studentservice;

	public StudentsController() {
		super();
	}
	
	@GetMapping("/gettingAll")
	public ResponseEntity<List<Students>> getAllStudents() {

		List<Students> list = studentservice.getAllStudents();

		return new ResponseEntity<>(list, HttpStatus.OK);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Students> getStudentsById(@PathVariable Long id) {

		return new ResponseEntity<>(studentservice.getStudentsById(id), HttpStatus.OK);
	}
	
	@PostMapping("/saveAll")
	public ResponseEntity<Students> saveStudent(@RequestBody Students students) {

		Students students1 = studentservice.saveStudents(students);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("students", "api/student" + students.getId());

		return new ResponseEntity<>(students, httpHeaders, HttpStatus.CREATED);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Students> updateStudent(@PathVariable("id") Long id,
			@RequestBody Students students) {

		studentservice.updateStudents(id, students);
		return new ResponseEntity<Students>(studentservice.getStudentsById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Students> deleteStudent(@PathVariable("id") Long id) {

		studentservice.deleteStudents(id);
		return new ResponseEntity<Students>(HttpStatus.OK);

	}

}
