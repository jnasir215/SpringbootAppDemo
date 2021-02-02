package com.codedifferently.bootstrap;

import com.codedifferently.domains.Employee;
import com.codedifferently.domains.Manager;
import com.codedifferently.repositories.EmployeeRepository;
import com.codedifferently.repositories.ManagerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final ManagerRepository managerRepository;

    public BootStrapData(EmployeeRepository employeeRepository, ManagerRepository managerRepository) {
        this.employeeRepository = employeeRepository;
        this.managerRepository = managerRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running...");

        Employee employee = new Employee();
        employee.setFirstName("Holly");
        employee.setLastName("Chaffee");

        employeeRepository.save(employee);

        Manager manager = new Manager();
        manager.setFirstName("Kojo");
        manager.setLastName("Gillett");

        managerRepository.save(manager);

        System.out.println("Number of employees: " + employeeRepository.count());
    }
}
