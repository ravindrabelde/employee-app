package com.ravindra.vacationservice.controller;

import com.ravindra.vacationservice.exceptions.EmployeeNotFoundException;
import com.ravindra.vacationservice.model.Employee;
import com.ravindra.vacationservice.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;

@RestController
@RequestMapping("/api/employees")
@Slf4j
public class EmployeeController {

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
        log.info("Employee with id " + id + " worked " + daysWorked + " day/days");
        employee.work(daysWorked);
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}/takeVacation/{days}")
    public Employee takeVacation(@PathVariable Long id, @PathVariable float days) {
        Employee employee = employeeRepository.findEmployee(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }
        log.info("Employee with id " + id + " took vacation for " + days + " day/days");
        employee.takeVacation(days);
        return employeeRepository.save(employee);
    }
}
