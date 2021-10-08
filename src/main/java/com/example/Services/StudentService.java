package com.example.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Students;

@Service

public interface StudentService {

   List<Students> getAllStudents();
   Students getStudentsById(Long id);

	Students saveStudents(Students students);
	
	
	void updateStudents(Long id, Students students);
	
	void deleteStudents(Long id);

	



	


}
