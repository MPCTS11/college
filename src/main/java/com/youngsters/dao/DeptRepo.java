package com.youngsters.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youngsters.model.Department;

public interface DeptRepo extends JpaRepository< Department,String> {

}
