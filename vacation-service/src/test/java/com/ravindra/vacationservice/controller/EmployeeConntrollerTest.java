package com.ravindra.vacationservice.controller;

import com.ravindra.vacationservice.exceptions.EmployeeNotFoundException;
import com.ravindra.vacationservice.model.Employee;
import com.ravindra.vacationservice.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeController employeeController;

	private Employee employee1;
	private Employee employee2;

	@BeforeEach
	void setUp() {
		employee1 = new Employee(1L) {
			@Override
			public void work(int daysWorked) {
				// Implement work method
			}
		};

		employee2 = new Employee(2L) {
			@Override
			public void work(int daysWorked) {
				// Implement work method
			}
		};
	}

	@Test
	void testGetAllEmployees() {
		when(employeeRepository.getEmployees()).thenReturn(Arrays.asList(employee1, employee2));

		Collection<Employee> employees = employeeController.getAllEmployees();

		assertEquals(2, employees.size());
		assertTrue(employees.contains(employee1));
		assertTrue(employees.contains(employee2));
	}

	@Test
	void testWorkEmployeeFound() {
		when(employeeRepository.findEmployee(1L)).thenReturn(employee1);
		when(employeeRepository.save(employee1)).thenReturn(employee1);

		Employee updatedEmployee = employeeController.work(1L, 5);

		assertEquals(employee1, updatedEmployee);
	}

	@Test
	void testWorkEmployeeNotFound() {
		when(employeeRepository.findEmployee(1L)).thenReturn(null);

		assertThrows(EmployeeNotFoundException.class, () -> employeeController.work(1L, 5));
	}

	@Test
	void testTakeVacationEmployeeFound() {
		when(employeeRepository.findEmployee(1L)).thenReturn(employee1);
		when(employeeRepository.save(employee1)).thenReturn(employee1);

		Employee updatedEmployee = employeeController.takeVacation(1L, 2.0f);

		assertEquals(employee1, updatedEmployee);
	}

	@Test
	void testTakeVacationEmployeeNotFound() {
		when(employeeRepository.findEmployee(1L)).thenReturn(null);

		assertThrows(EmployeeNotFoundException.class, () -> employeeController.takeVacation(1L, 2.0f));
	}
}