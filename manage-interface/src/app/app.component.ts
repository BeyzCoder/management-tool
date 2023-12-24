import { Component, OnInit } from '@angular/core';
import { Employee } from './employee';
import { EmployeeService } from './employee.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Department } from './department';
import { Task } from './task';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  public employees: Employee[] = [];
  public departments: Department[] | undefined;
  public editEmployee: Employee | null | undefined;
  public deleteEmployee: Employee | null | undefined;

  public taskEmployee: Employee | null | undefined;
  
  constructor(private employeeService: EmployeeService) { }

  ngOnInit() {
    this.getEmployees();
    this.getDepartments();
  }

  public getEmployees(): void {
    this.employeeService.getEmployee().subscribe(
      (response: Employee[]) => {
        this.employees = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getDepartments(): void {
    this.employeeService.getDepartment().subscribe(
      (response: Department[]) => {
        this.departments = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenModal(employee: Employee | null, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal')
    if (mode === 'add') {
      button.setAttribute('data-target', '#addEmployeeModal');
    }
    if (mode === 'dept') {
      button.setAttribute('data-target', '#addDepartmentModal');
    } 
    if (mode === 'edit') {
      this.editEmployee = employee;
      button.setAttribute('data-target', '#updateEmployeeModal');
    }
    if (mode === 'task') {
      this.taskEmployee = employee;
      button.setAttribute('data-target', '#addTaskModal');
    }
    if (mode === 'delete') {
      this.deleteEmployee = employee;
      button.setAttribute('data-target', '#deleteEmployeeModal');
    }
    container?.append(button);
    button.click();
  }

  public onAddDepartment(deptForm: NgForm): void {
    document.getElementById('add-department-form')?.click();
    this.employeeService.addDepartment(deptForm.value).subscribe(
      (response: Department) => {
        alert(`Department ${response.field} has been added to the system.`);
        this.getDepartments();
        deptForm.reset();
      },  
      (error: HttpErrorResponse) => {
        alert(error.message);
        deptForm.reset();
      }
    )
  }

  public onAddEmployee(addForm: NgForm): void {
    document.getElementById('add-employee-form')?.click();
    this.employeeService.addEmployee(addForm.value).subscribe(
      (response: Employee) => {
        alert(`${response.name} has been added to the system.`);
        this.getEmployees();
        addForm.reset();
      },  
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public searchEmployee(key: string): void {
    const results: Employee[] = [];
    for (let employee of this.employees) {
      if (employee.name.toLowerCase().indexOf(key.toLowerCase()) !== -1 
      || employee.department.field.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(employee);
      }
    }

    this.employees = results;
    if (results.length === 0 || !key) {
      this.getEmployees();
    } 
  }

  public onAddTask(taskForm: NgForm, employeeId: number | undefined): void {
    // Create a new Date object representing the current date and time
    const currentDate: Date = new Date();

    // Extract individual components (year, month, day, etc.) if needed
    const year: number = currentDate.getFullYear();
    const month: number = currentDate.getMonth() + 1; // Months are 0-indexed
    const day: number = currentDate.getDate();

    taskForm.value['createDate'] = `${year}-${month}-${day}`;

    console.log(taskForm.value);

    document.getElementById('add-task-form')?.click();
    this.employeeService.addTask(employeeId, taskForm.value).subscribe(
      (response: void) => {
        alert(`Added new task`);
        this.getEmployees();
        taskForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        taskForm.reset();
      }

    )
  }

  public onUpdateEmployee(employee: Employee): void {
    this.employeeService.updateEmployee(employee).subscribe(
      (response: Employee) => {
        alert(`${response.name}'s profile has been changed.`);
        this.getEmployees();
      },  
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteEmployee(employeeId: number | undefined): void {
    this.employeeService.deleteEmployee(employeeId).subscribe(
      (response: void) => {
        alert("The account has been deleted.");
        this.getEmployees();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}