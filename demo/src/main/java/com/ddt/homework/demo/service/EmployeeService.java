package com.ddt.homework.demo.service;

import com.ddt.homework.demo.model.entity.Employee;
import com.ddt.homework.demo.model.request.EmployeeRequest;
import org.springframework.data.domain.Page;

public interface EmployeeService {

    Employee save(EmployeeRequest request);

    Employee getOne(long id);

    void deleteById(long id);

    Page<Employee> find(String name, Long id, Integer age, String departmentName, Integer page, Integer size);
}
