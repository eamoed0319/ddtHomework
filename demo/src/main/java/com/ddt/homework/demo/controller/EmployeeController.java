package com.ddt.homework.demo.controller;

import com.ddt.homework.demo.model.Employee;
import com.ddt.homework.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/{name}")
    public Employee getOneEmployee(@PathVariable String name){
        return employeeService.findByName(name);
    }
}
