package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modal.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// persist() //merge() //remove() //find()-->for single row entries
	// createQuery()-->for multi-row query

	@Query("select e from Employee e where e.empDesg=?1")
	public abstract List<Employee> getByDesgEmployee(String empDesg);

	@Query("select e from Employee e where e.empSal between :min and :max")
	public abstract List<Employee> getBetweemSalEmployee(@Param("min") int initialSal, @Param("max") int finalSal);

}
