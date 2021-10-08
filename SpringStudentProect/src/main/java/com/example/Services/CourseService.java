package com.example.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Courses;
import com.example.model.Students;

@Service
public interface CourseService{

	 List<Courses> getAllCourses();
	 Courses getCoursesById(Long c_id);

	 Courses saveSCourses(Courses course);
		
		
		void updateCourses(Long c_id, Courses course);
		
		void deleteCourses(Long c_id);
		


	
}
