package com.example.demo.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.EmployeeNotFound;
import com.example.demo.modal.Employee;
import com.example.demo.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController { // http://localhost:8083/employees
	EmployeeService service;

	

	@GetMapping("/message") // http://localhost:8083/employees/message
	public String getMsg() {

		return "Hello API..";

	}

	@PostMapping("/save") // http://localhost:8083/employees/save
	public String createEmployee(@RequestBody @Validated Employee employee) {
		return service.saveEmployee(employee);
	}

	@PutMapping("/update") // http://localhost:8083/employees/update
	public String updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}

	@DeleteMapping("/delete/{employeeId}") // URL: http://localhost:8083/employees/delete/5
	public String deleteEmployee(@PathVariable("employeeId") int id) {
		return service.deleteEmployee(id);
	}

	@GetMapping("/fetch/{employeeId}") // URL: http://localhost:8083/employees/fetch/5
	public Employee getEmployee(@PathVariable("employeeId") int id) throws EmployeeNotFound {
		return service.getEmployee(id);
	}

	@GetMapping("/fetchall") // URL: http://localhost:8083/employees/fetchall
	public List<Employee> getAllEmployee() {
		return service.getAllEmployees();
	}

	@GetMapping("/designation/{desg}") // URL: http://localhost:8083/employees/designation/trainer
	public List<Employee> getEmployeesByDesignation(@PathVariable("desg") String designation) {
	    return service.getByDesgEmployee(designation);
	}

	@GetMapping("/fetchallBetween") // URL: http://localhost:8083/employees/fetchallBetween
	public List<Employee> getAllEmployee2(@RequestParam("start") int initialSal, @RequestParam("end") int finalSal) {
		return service.getBetweemSalEmployee(initialSal, finalSal);
	}

}
