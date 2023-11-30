package com.example.backend_latest.service;

import com.example.backend_latest.model.Employee;
import com.example.backend_latest.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmpServiceImpl extends EmployeeService {

    @Autowired
    private EmpRepository emprepository;

    public EmpServiceImpl(EmpRepository empRepository) {
        super(empRepository);
    }

    @Override
    public Employee login(Employee emp) {
        try {
            String empEmail = emp.getEmail();
            String empPassword = emp.getPassword();
            return emprepository.findByEmailAndPassword(empEmail, empPassword);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }
}
