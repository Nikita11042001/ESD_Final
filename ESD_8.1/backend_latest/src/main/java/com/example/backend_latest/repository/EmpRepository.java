package com.example.backend_latest.repository;

import com.example.backend_latest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Employee, Long> {

    // Spring Data JPA will automatically generate the query based on this method name
    // It assumes you have a property named 'email' in your Employee entity
    Employee findByEmailAndPassword(String email, String password);
}
