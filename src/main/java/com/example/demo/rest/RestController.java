package com.example.demo.rest;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/crm")
public class RestController {
    private EmployeeDAO employeeDAO;

    @Autowired
    public RestController(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeDAO.findAllEmployees();
    }


    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        return employeeDAO.findEmployeeById(employeeId);
    }

    @PostMapping("/employees")
    public void createEmployees(@RequestBody List<Employee> employeesList){
        System.out.println(employeesList);
        for (Employee employee : employeesList) {
            employeeDAO.createEmployee(employee);
        }
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeDAO.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id){
        Employee employee = employeeDAO.findEmployeeById(id);
        employeeDAO.deleteEmployee(employee);
    }
}
