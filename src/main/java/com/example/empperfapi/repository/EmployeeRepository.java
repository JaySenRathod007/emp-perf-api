package com.example.empperfapi.repository;

import com.example.empperfapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // We'll add custom filtering methods later
}

