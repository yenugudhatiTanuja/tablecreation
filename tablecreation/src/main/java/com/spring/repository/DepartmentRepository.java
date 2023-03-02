package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.Department;


public interface DepartmentRepository extends JpaRepository<Department,Integer>{

}
