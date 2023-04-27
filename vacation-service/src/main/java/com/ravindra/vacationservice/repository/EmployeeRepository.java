package com.ravindra.vacationservice.repository;

import com.ravindra.vacationservice.model.Employee;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class EmployeeRepository {

	Map<Long, Employee> employees;

	public EmployeeRepository() {
		this.employees = new HashMap<>();
	}

	public Employee save(Employee employee) {
		this.employees.put(employee.getId(), employee);
		return employee;
	}

	public Employee findEmployee(long id) {
		return employees.get(id);
	}

	public Collection<Employee> getEmployees() {
		return employees.values();
	}

}
