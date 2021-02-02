package com.codedifferently.controllers;

import com.codedifferently.domains.Employee;
import com.codedifferently.domains.Manager;
import com.codedifferently.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ManagerController {

    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @RequestMapping("")
    public Manager getManager() {
        Optional<Manager> manager = managerRepository.findByFirstName("Kojo");
        return manager.get();
    }

    @RequestMapping("/manager/{firstName}")
    public Manager getManagerFirstName(@PathVariable String firstname) {
        Optional<Manager> manager = managerRepository.findByFirstName(firstname);
        return manager.get();
    }
}
