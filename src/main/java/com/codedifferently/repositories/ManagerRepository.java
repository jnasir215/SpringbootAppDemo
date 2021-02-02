package com.codedifferently.repositories;

import com.codedifferently.domains.Manager;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ManagerRepository extends CrudRepository<Manager, Long> {
    Optional<Manager> findByFirstName(String name);
}
