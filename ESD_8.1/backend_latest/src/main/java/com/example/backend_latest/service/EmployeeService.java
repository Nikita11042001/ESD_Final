package com.example.backend_latest.service;

import com.example.backend_latest.model.Employee;
import com.example.backend_latest.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private final EmpRepository empRepository;

    @Autowired
    public EmployeeService(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

    public Employee login(Employee emp) {
        // Use the Spring Data JPA repository to perform the login operation
        Employee loggedInEmp = empRepository.findByEmailAndPassword(emp.getEmail(), emp.getPassword());


        // If no login happens, consider throwing an exception or returning a specific result
        return loggedInEmp;
    }
}
