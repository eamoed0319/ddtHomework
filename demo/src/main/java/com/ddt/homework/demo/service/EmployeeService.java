package com.ddt.homework.demo.service;

import com.ddt.homework.demo.model.Employee;
import com.ddt.homework.demo.model.EmployeeVO;

public interface EmployeeService {
    EmployeeVO findByName(String name);

    EmployeeVO save(Employee employee);

    Employee getOne(long id);

    void deleteById(long id);
}
