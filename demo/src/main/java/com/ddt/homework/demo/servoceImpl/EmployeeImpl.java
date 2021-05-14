package com.ddt.homework.demo.servoceImpl;

import com.ddt.homework.demo.dao.EmployeeRepository;
import com.ddt.homework.demo.model.Department;
import com.ddt.homework.demo.model.Employee;
import com.ddt.homework.demo.model.EmployeeVO;
import com.ddt.homework.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

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

    @Override
    public Page<Employee> findAll(String name, Long id, Integer age, String departmentName, Integer page, Integer size) {
        Specification<Employee> specification = combinationQueryConditions(name, id, age, departmentName);
        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> employeeList = employeeRepository.findAll(specification, pageable);
        employeeList.getContent().forEach(employee -> {
            employee.getDepartment().setEmployees(null);
        });
        return employeeList;
    }

    private Specification<Employee> combinationQueryConditions(String name, Long id, Integer age, String departmentName){
        Specification<Employee> specification = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();
            if (name != null && !"".equals(name)) {
                predicates.add(cb.equal(root.<String>get("name"), name));
            }
            if (id != null) {
                predicates.add(cb.equal(root.<Long>get("id"), id));
            }
            if (age != null) {
                predicates.add(cb.equal(root.<Integer>get("age"), age));
            }
            if (departmentName != null && !"".equals(departmentName)) {
                Join<Employee, Department> departments = root.join("department");
                predicates.add(cb.equal(departments.get("name"), departmentName));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        return specification;
    }
}
