import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from './employee.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private apiUrl = 'http://localhost:8080/api/employees';

  constructor(private http: HttpClient) { }

  getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.apiUrl);
  }

  work(employee: Employee, daysWorked: number): Observable<Employee> {
    return this.http.put<Employee>(`${this.apiUrl}/${employee.id}/work/${daysWorked}`, {});
  }

  takeVacation(employee: Employee, days: number): Observable<Employee> {
    return this.http.put<Employee>(`${this.apiUrl}/${employee.id}/takeVacation/${days}`, {});
  }
}
