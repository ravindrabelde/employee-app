import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee.model';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent implements OnInit {
  employees: Employee[] = [];

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.getEmployees();
  }

  getEmployees(): void {
    this.employeeService.getEmployees().subscribe(
      (employees) => {
        this.employees = employees;
      },
      (error) => {
        console.error('Error fetching employees:', error);
      }
    );
  }

  work(employee: Employee, daysWorked: number): void {
    this.employeeService.work(employee, daysWorked).subscribe(updatedEmployee => {
      employee.vacationDays = updatedEmployee.vacationDays;
    });
  }

  takeVacation(employee: Employee, days: number): void {
    this.employeeService.takeVacation(employee, days).subscribe(updatedEmployee => {
      employee.vacationDays = updatedEmployee.vacationDays;
    });
  }
}
