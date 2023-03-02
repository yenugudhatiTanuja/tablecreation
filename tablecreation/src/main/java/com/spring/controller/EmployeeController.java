package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Department;
import com.spring.Employee;
import com.spring.service.DepartmentService;
import com.spring.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	
	
	@GetMapping("/emplist")
	public List<Employee> getEmployee()
	{
		return this.employeeService.getAllEmployee();
	}
	//http://localhost:8080/addemp1?deptid=3
	@PostMapping("/addemp")
	public String addEmployee(@RequestBody Employee employee,@RequestParam ("deptid")int deptId) 
	{
		//System.out.println("======>"+this.departmentService.getAllDepartment());
		Department d = this.departmentService.searchById(deptId);
		//System.out.println("Dept id===>"+deptId);
		//System.out.println("Emp===>"+employee.getEmpName());
		employee.setDepartment(d);
	
				this.employeeService.addEmployee(employee);
				return "Employee added has been successfully";
	
	}
	//http://localhost:8080/addemp1/3
	@PostMapping("/addemp1/{deptid}")
	public String addEmployee1(@RequestBody Employee employee,@PathVariable int deptid) 
	{
		//System.out.println("======>"+this.departmentService.getAllDepartment());
		Department d = this.departmentService.searchById(deptid);
		//System.out.println("Dept id===>"+deptId);
		//System.out.println("Emp===>"+employee.getEmpName());
		employee.setDepartment(d);
	
				this.employeeService.addEmployee(employee);
				return "Employee added has been successfully";
	
	}
	
	@DeleteMapping("/delemp/{id}")
	public String delEmployee(@PathVariable int id)
	{
		this.employeeService.deleteEmplyee(id);
		return "Employee has been deleted";
	}
	
	
}
