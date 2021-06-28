package com.example.thalestestmicroservice.employee.service;

import com.example.thalestestmicroservice.employee.model.Employee;
import com.example.thalestestmicroservice.employee.model.EmployeeRequestMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class EmployeeService {
    private final static String URL = "http://dummy.restapiexample.com/api/v1";

    public List<Employee> getEmployees() {

        List<Employee> employeeList = new ArrayList<>();
        String url = URL + "/employees";
        EmployeeRequestMap employeeRequestMap = get(url);

        for (HashMap emp: (List<HashMap>) employeeRequestMap.getData()) {
            Employee employee = new Employee();
            employee.setId((int) emp.get("id"));
            employee.setEmployeeName((String) emp.get("employee_name"));
            employee.setEmployeeSalary((int) emp.get("employee_salary"));
            employee.setEmployeeAge((int) emp.get("employee_age"));
            employee.setProfileImage((String) emp.get("profile_image"));
            employee.setEmployeeAnualSalary(getSalaryPerYear(employee));
            employeeList.add(employee);
        }

        return employeeList;
    }

    public Employee getEmployeeId(int id) {
        Employee employee = new Employee();
        String url = URL + "/employee/" + id;
        EmployeeRequestMap employeeRequestMap = get(url);
        HashMap map = (HashMap) employeeRequestMap.getData();
        employee.setId((int) map.get("id"));
        employee.setEmployeeName((String) map.get("employee_name"));
        employee.setEmployeeSalary((int) map.get("employee_salary"));
        employee.setEmployeeAge((int) map.get("employee_age"));
        employee.setProfileImage((String) map.get("profile_image"));
        employee.setEmployeeAnualSalary(getSalaryPerYear(employee));
        return  employee;
    }

    private EmployeeRequestMap get(String url) {
        try{
            EmployeeRequestMap employeeRequestMap = new EmployeeRequestMap();
            URL objUrl = new URL(url);
            HttpURLConnection con = (HttpURLConnection) objUrl.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println(response.toString());
                ObjectMapper mapper = new ObjectMapper();

                employeeRequestMap = mapper.readValue(response.toString(), EmployeeRequestMap.class);

                if(employeeRequestMap.getData() != null) return employeeRequestMap;
                else {
                    throw new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Data Employee Not Found");
                }
            } else {
                System.out.println("GET request not worked");
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Info Employee Not Found");
            }
        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Info Employee Not Found", e);
        }
    }

    public int getSalaryPerYear(Employee employee){
        return employee.getEmployeeSalary() * 12;
    }
}
