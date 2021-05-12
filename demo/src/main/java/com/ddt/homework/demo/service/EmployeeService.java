package com.ddt.homework.demo.service;

import com.ddt.homework.demo.model.Employee;

public interface EmployeeService {
    Employee findByName(String name);
}
