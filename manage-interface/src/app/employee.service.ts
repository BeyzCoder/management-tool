import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';
import { Department } from './department';
import { Task } from './task';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private apiServerUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  public getEmployee(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.apiServerUrl}/dashboard/employee/`)
  }

  public getDepartment(): Observable<Department[]> {
    return this.http.get<Department[]>(`${this.apiServerUrl}/department/`)
  }

  public addEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(`${this.apiServerUrl}/dashboard/employee/`, employee)
  }

  public addDepartment(department: Department): Observable<Department> {
    return this.http.post<Department>(`${this.apiServerUrl}/department/`, department)
  }

  public addTask(employeeId: number | undefined, task: Task): Observable<void> {
    return this.http.post<void>(`${this.apiServerUrl}/dashboard/employee/task/${employeeId}`, task)
  }

  public updateEmployee(employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(`${this.apiServerUrl}/dashboard/employee/update`, employee)
  }

  public deleteEmployee(employeeId: number | undefined): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/dashboard/employee/delete/${employeeId}`);
  }
}