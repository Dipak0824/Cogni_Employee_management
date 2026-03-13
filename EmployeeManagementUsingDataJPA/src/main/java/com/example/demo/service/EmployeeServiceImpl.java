package com.example.demo.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.example.demo.exception.EmployeeNotFound;
import com.example.demo.modal.Employee;
import com.example.demo.repository.EmployeeRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeRepository repository;



	@Override
	public String saveEmployee(Employee employee) {
		repository.save(employee);
		return "Employee added successfully";
	}

	@Override
	public String updateEmployee(Employee employee) {

		repository.save(employee);
		return "Employee updated successfully";
	}

	@Override
	public String deleteEmployee(int empId) {
		repository.deleteById(empId);
		return "Employee deleted successfully";

	}

	@Override
	public Employee getEmployee(int empId) throws EmployeeNotFound {

		Optional<Employee> optional=repository.findById(empId);
		
		if(optional.isEmpty()) {
			throw new EmployeeNotFound("No employee found with this id.");
		}else {
		return optional.get();
		}
		
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	public List<Employee> getByDesgEmployee(String empDesg) {

		return repository.getByDesgEmployee(empDesg);
	}

	@Override
	public List<Employee> getBetweemSalEmployee(int initailSal, int finalSal) {

		return repository.getBetweemSalEmployee(initailSal, finalSal);
	}

}
