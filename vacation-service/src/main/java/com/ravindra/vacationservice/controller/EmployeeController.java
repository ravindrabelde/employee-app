package com.ravindra.vacationservice.controller;

import com.ravindra.vacationservice.exceptions.EmployeeNotFoundException;
import com.ravindra.vacationservice.model.Employee;
import com.ravindra.vacationservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import java.util.Collection;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    Logger logger = LogManager.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public Collection<Employee> getAllEmployees() {
        return employeeRepository.getEmployees();
    }

    @PutMapping("/{id}/work/{daysWorked}")
    public Employee work(@PathVariable Long id, @PathVariable int daysWorked) {
        Employee employee = employeeRepository.findEmployee(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }
        logger.info("Employee with id " + id + " worked " + daysWorked + " day/days");
        employee.work(daysWorked);
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}/takeVacation/{days}")
    public Employee takeVacation(@PathVariable Long id, @PathVariable float days) {
        Employee employee = employeeRepository.findEmployee(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }
        logger.info("Employee with id " + id + " took vacation for " + days + " day/days");
        employee.takeVacation(days);
        return employeeRepository.save(employee);
    }
}
