package com.ddt.homework.demo.service;

import com.ddt.homework.demo.model.Employee;
import com.ddt.homework.demo.model.EmployeeVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

public interface EmployeeService {
    EmployeeVO findByName(String name);

    EmployeeVO save(Employee employee);

    Employee getOne(long id);

    void deleteById(long id);

    Page<Employee> findAll(String name, Long id, Integer age, String departmentName, Integer page, Integer size);
}
