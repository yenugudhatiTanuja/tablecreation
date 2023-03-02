package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Department;
import com.spring.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/deptlist")
	public List<Department> getDepartment()
	{
		return this.departmentService.getAllDepartment();
	}
	
	@PostMapping("/adddept")
	public Department addDepartment(@RequestBody Department department) 
	{
		return this.departmentService.addDepartment(department);
	}
	@DeleteMapping("/deldept/{id}")
	public String delDepartment(@PathVariable int id)
	{
		this.departmentService.deleteDepartment(id);
		return "Department has been deleted";
	}
	
}
