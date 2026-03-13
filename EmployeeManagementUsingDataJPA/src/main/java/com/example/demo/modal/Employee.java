package com.example.demo.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;


import lombok.NoArgsConstructor;




@Entity
@Table(name = "employee_data_jpa")
@Data
@NoArgsConstructor
@AllArgsConstructor    //@Data=@Getter/@Setter/@ToString/@EqualsAndHashCode/@AllArgsConstructor

public class Employee {
	@Id
	@Column(name = "empno")
	@Min(value=1 , message = "Employee id cannot be negtive.")
	private int empId;
	@NotBlank(message = "Name cannot be empty and blank.")
	@Column(name = "ename", nullable = false, length = 10)
	@Size(min = 5,max = 10,message="Name length  must be in 5-10")
	private String empName;
	@Min(value = 1000,message = "Salary cannot be below 1000")
	@Max(value = 10000,message = "Salary cannot be above 10000")
	private int empSal;
	@NotEmpty(message = "Designation cannot be empty.")
	private String empDesg;

	
}
