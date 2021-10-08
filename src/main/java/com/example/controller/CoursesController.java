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

import com.example.Services.CourseService;
import com.example.model.Courses;

@RestController
@RequestMapping("/courses")
public class CoursesController {
	
	@Autowired
	CourseService courseservice;

	public CoursesController() {
		super();
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Courses>> getAllCourses() {

		List<Courses> list = courseservice.getAllCourses();

		return new ResponseEntity<>(list, HttpStatus.OK);

	}
	
	@GetMapping("/{c_id}")
	public ResponseEntity<Courses> getCourseById(@PathVariable Long c_id) {

		return new ResponseEntity<>(courseservice.getCoursesById(c_id), HttpStatus.OK);
	}
	
	@PostMapping("/saves")
	public ResponseEntity<Courses> saveCourse(@RequestBody Courses course) {

		Courses course1 = courseservice.saveSCourses(course);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("course", "/courses" + course1.getC_id());

		return new ResponseEntity<>(course1, httpHeaders, HttpStatus.CREATED);

	}
	
	
	@PutMapping("/{courseId}")
	public ResponseEntity<Courses> updateCourse(@PathVariable("courseId") Long courseId,
			@RequestBody Courses courseModel) {

		courseservice.updateCourses(courseId, courseModel);
		return new ResponseEntity<Courses>(courseservice.getCoursesById(courseId), HttpStatus.OK);
	}
	
	@DeleteMapping("/{courseId}")
	public ResponseEntity<Courses> deleteCourse(@PathVariable("courseId") Long courseId){
		
		courseservice.deleteCourses(courseId);
		return new ResponseEntity<Courses>(HttpStatus.OK);
			
	}
}
