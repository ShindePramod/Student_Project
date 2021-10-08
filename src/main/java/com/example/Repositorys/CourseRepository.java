package com.example.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Courses;

public interface CourseRepository extends JpaRepository<Courses, Long>{

}
