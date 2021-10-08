package com.example.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Repositorys.StudentRepository;
import com.example.model.Students;

@Service
public class StudentServiceimpl implements StudentService {

	@Autowired
	StudentRepository studentrepository;
	
	
	public StudentServiceimpl(StudentRepository studentrepository) {
		super();
		this.studentrepository = studentrepository;
	}

	@Override
	public List<Students> getAllStudents() {
		
		List<Students> list = new ArrayList<>();
		studentrepository.findAll().forEach(list::add);
		return list;
	}

	@Override
	public Students getStudentsById(Long id) {
		studentrepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student not found."));
		return studentrepository.findById(id).get();
	}

	@Override
	public Students saveStudents(Students students) {
		
		return studentrepository.save(students);
	}

	@Override
	public void updateStudents(Long id, Students students) {
		studentrepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student not found.")); 
		Students oldStudent = studentrepository.findById(id).get();
		System.out.println(oldStudent.toString());
		
		oldStudent.setName(students.getName());
		oldStudent.setLastName(students.getLastName());
	
		oldStudent.setMobile_num(students.getMobile_num());
		
		studentrepository.save(oldStudent);
		
		
	}

	@Override
		public void deleteStudents(Long id) {
		studentrepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student not found.")); //To check Student is available or not by Student id
		studentrepository.deleteById(id);
	}

	


}
