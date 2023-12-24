This project is to train me how to properly create a CRUD method and authentication. The project will consist of a login and register page functionality. Then the user will have two types of account one going to
have an admin page and an employee page. The admin can see all employees,
add employees, edit employee's info, delete employee. For the employee's action,
can see his/her dashboard.

The package project was built on Maven.

All of this idea came from the studies I have watched and read, then combine them all together to create this project.

Languages:
- Java --version 17
- SQL
- TypeScript

Frameworks:
- Spring-Boot
- Angular

Tools:
- Docker
- Postgres
- Bootstrap

HOW TO USE THIS!

After cloning this repository. go to its directory then type this
```bash
docker-compose up
```

Then wait for at least a minute and you will be able to go to this url
```
http://localhost:4200/
```

Now you can use the Employee Management System.

Features:
- Add Employee
- Add Department Field
- Add Task
- Edit Employee
- Delete Employee
- Search Employee and Department

To see the database, just type this command line.
```bash
docker exec -it accounts-db psql -U testdev -d AccountInformationDB
```