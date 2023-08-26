package com.isaachome.demo.service;

import com.isaachome.demo.payload.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public Employee createEmployee(){
       return Employee.builder()
                .name("John Petrucci")
                .email("johnPetrucci@gmail.com")
                .empCode("EMP007").build();
    }
}
