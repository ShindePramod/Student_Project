package com.example.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Students;

public interface StudentRepository extends JpaRepository<Students, Long> {

}
