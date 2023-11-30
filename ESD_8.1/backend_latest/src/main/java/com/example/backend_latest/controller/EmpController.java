package com.example.backend_latest.controller;

import com.example.backend_latest.model.Employee;
import com.example.backend_latest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/emp")
public class EmpController {

    @Autowired
    private EmployeeService employeeService; // Use consistent naming

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Employee emp) {
        Employee loggedInEmp = employeeService.login(emp);

        if (loggedInEmp != null) {
            return ResponseEntity.ok(loggedInEmp);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
