package com.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Department;
import com.spring.repository.DepartmentRepository;

@Service
@Transactional
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	public List<Department> getAllDepartment()
	{
		return departmentRepository.findAll();
	}
	
	public Department addDepartment(Department department)
	{
		return departmentRepository.save(department);
	}
	
	public Department searchById(int deptId)
	{
		return departmentRepository.findById(deptId).get();
	}
	public void deleteDepartment(int deptId) {
		
		departmentRepository.deleteById(deptId);			
	}

}
