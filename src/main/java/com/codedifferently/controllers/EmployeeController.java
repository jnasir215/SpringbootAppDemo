package com.codedifferently.controllers;

import com.codedifferently.domains.Employee;
import com.codedifferently.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping("")
    public Employee getEmployee() {
        Optional<Employee> employee = employeeRepository.findByFirstName("Holly");
        return employee.get();
    }

    @RequestMapping("/employees/{firstName}")
    public Employee getEmployeeFirstName(@PathVariable String firstname) {
        Optional<Employee> employee = employeeRepository.findByFirstName(firstname);
        return employee.get();
    }
}
