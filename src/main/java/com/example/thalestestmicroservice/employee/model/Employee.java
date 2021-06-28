package com.example.thalestestmicroservice.employee.model;

public class Employee {
    private int id;
    private String employeeName;
    private int employeeSalary;
    private int employeeAge;
    private String profileImage;
    private int employeeAnualSalary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employee_name) {
        this.employeeName = employee_name;
    }

    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employee_age) {
        this.employeeAge = employee_age;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public int getEmployeeAnualSalary() {
        return employeeAnualSalary;
    }

    public void setEmployeeAnualSalary(int employeeAnualSalary) {
        this.employeeAnualSalary = employeeAnualSalary;
    }
}
