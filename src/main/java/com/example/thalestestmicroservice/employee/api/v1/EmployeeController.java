package com.example.thalestestmicroservice.employee.api.v1;

import com.example.thalestestmicroservice.employee.model.Employee;
import com.example.thalestestmicroservice.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployees(@PathVariable int id) {
        return employeeService.getEmployeeId(id);
    }
}
