This is just a practice project to learn Spring Boot.
It does CRUD operations working with a local MySQL server. 

To run the project the only setup needed is, 
1. MySQL server running at: localhost:3306
2. A db created with name employee_tracker
3. A table created with name: "employee" and columns: id, first_name, last_name
4. MySQL server should have a user: "springstudent" with password: springstudent

Thats it, then on postman you can try doing the following 

1. POST /employees with payload: [ {"firstName":"Steve", "lastName":"Jobs"}, .... ]   => Should get added to the db
2. GET /employees => Should return the created eployees
3. GET /employees/1 => Should return the single employee
4. PUT /employees with payload: {"id": "1" , "firstName":"Steve", "lastName":"Jobs"} => Should update the employee
5. DELETE /employee/{id}  => Should delete the employee 
