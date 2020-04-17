package com.youngsters.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youngsters.model.Student;

public interface StudentRepo extends JpaRepository<Student,Integer> {

}
