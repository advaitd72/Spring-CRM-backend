package com.example.demo.dao;

import com.example.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public  EmployeeDAO(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    //create
    @Transactional
    public void createEmployee(Employee employee){
        entityManager.persist(employee);
    }

    //read
    public Employee findEmployeeById(int id){
      return entityManager.find(Employee.class, id);
    }

    public List<Employee> findAllEmployees(){
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee",Employee.class);
        return theQuery.getResultList();
     }

    //update
    @Transactional
    public Employee updateEmployee(Employee employee){
        return entityManager.merge(employee);
    }

    //delete
    @Transactional
    public void deleteEmployee(Employee employee){
        entityManager.remove(employee);
    }
}
