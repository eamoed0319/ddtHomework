package com.ddt.homework.demo.servoceImpl;

import com.ddt.homework.demo.dao.EmployeeRepository;
import com.ddt.homework.demo.model.Employee;
import com.ddt.homework.demo.model.EmployeeVO;
import com.ddt.homework.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeVO findByName(String name) {
        return new EmployeeVO(employeeRepository.findByName(name));
    }

    @Override
    @Transactional
    public EmployeeVO save(Employee Employee) {
        return new EmployeeVO(employeeRepository.save(Employee));
    }

    @Override
    public Employee getOne(long id) {
        return employeeRepository.getOne(id);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }
}
