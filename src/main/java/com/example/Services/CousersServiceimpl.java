package com.example.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Repositorys.CourseRepository;
import com.example.model.Courses;

@Service
public  class CousersServiceimpl implements CourseService{

	@Autowired
	CourseRepository courserepository;
	
	
	public CousersServiceimpl() {
		super();
	}


	@Override
	public List<Courses> getAllCourses() {
		List<Courses> list = new ArrayList<>();
		
		courserepository.findAll().forEach(list::add);
		
		return list;
	}


	@Override
	public Courses getCoursesById(Long c_id) {
		courserepository.findById(c_id).orElseThrow(()->new ResourceNotFoundException("Course not found."));
		return courserepository.findById(c_id).get();
	}


	@Override
	public Courses saveSCourses(Courses course) {
		return courserepository.save(course);
	}


	@Override
	public void updateCourses(Long c_id, Courses course) {
		courserepository.findById(c_id).orElseThrow(()->new ResourceNotFoundException("Course not found."));
		Courses oldCourse = courserepository.findById(c_id).get();
		
		System.out.println(oldCourse.toString());
		
		oldCourse.setC_name(course.getC_name());
		
		
		
		oldCourse.setC_duration(course.getC_duration());
		
		courserepository.save(oldCourse);
		
	}


	@Override
	public void deleteCourses(Long c_id) {
		courserepository.findById(c_id).orElseThrow(()->new ResourceNotFoundException("Course not found."));
		courserepository.deleteById(c_id);
	}

	



	
	


}
