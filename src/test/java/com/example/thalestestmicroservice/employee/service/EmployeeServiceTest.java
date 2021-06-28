package com.example.thalestestmicroservice.employee.service;

import com.example.thalestestmicroservice.employee.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    @Autowired
    EmployeeService employeeService;

    @Test
    void getSalaryPerYear() {
        employeeService = new EmployeeService();
        int salary = 100000;
        Employee employee = new Employee();
        employee.setEmployeeSalary(salary);
        Assertions.assertEquals(1200000, this.employeeService.getSalaryPerYear(employee));
    }
}