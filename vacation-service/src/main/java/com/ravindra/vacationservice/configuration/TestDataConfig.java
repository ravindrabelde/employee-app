package com.ravindra.vacationservice.configuration;

import com.ravindra.vacationservice.model.Employee;
import com.ravindra.vacationservice.model.HourlyEmployee;
import com.ravindra.vacationservice.model.Manager;
import com.ravindra.vacationservice.model.SalariedEmployee;
import com.ravindra.vacationservice.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class TestDataConfig {
	@Bean
	public CommandLineRunner loadData(EmployeeRepository employeeRepository) {
		return (args) -> {
			Random random = new Random();
			long id = 1;
			for (int i = 0; i < 10; i++) {
				Employee hourlyEmployee = new HourlyEmployee(id++);
				hourlyEmployee.work(random.nextInt(261));
				employeeRepository.save(hourlyEmployee);

				Employee salariedEmployee = new SalariedEmployee(id++);
				salariedEmployee.work(random.nextInt(261));
				employeeRepository.save(salariedEmployee);

				Employee manager = new Manager(id++);
				manager.work(random.nextInt(261));
				employeeRepository.save(manager);
			}
		};
	}
}
