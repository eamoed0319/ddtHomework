package com.ddt.homework.demo.servoceImpl;

import com.ddt.homework.demo.dao.EmployeeRepository;
import com.ddt.homework.demo.model.entity.Department;
import com.ddt.homework.demo.model.entity.Employee;
import com.ddt.homework.demo.model.request.EmployeeRequest;
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
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public Employee save(EmployeeRequest request) {
        Employee employee;
        if (Objects.isNull(request.getId())){
            employee = setAddEmployeeEntity(request);
        } else {
            employee = setUpdateEmployeeEntity(request);
        }
        return employeeRepository.save(employee);
    }

    /**
     * 只是組參數故不寫測試
     * @param request
     * @return
     */
    private Employee setAddEmployeeEntity(EmployeeRequest request){
        Department department = new Department();
        department.setId(request.getDepartmentId());
        return new Employee(request.getName(), request.getGender(), request.getPhoneNumber(),
                request.getAddress(), request.getAge(), department);
    }

    /**
     * 只是組參數故不寫測試
     * @param request
     * @return
     */
    private Employee setUpdateEmployeeEntity(EmployeeRequest request){
        Department department = new Department();
        department.setId(request.getDepartmentId());
        Employee employee = new Employee(request.getName(), request.getGender(), request.getPhoneNumber(),
                request.getAddress(), request.getAge(), department);
        employee.setId(request.getId());
        employee.setCreateTime(getOne(request.getId()).getCreateTime());
        return employee;
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
    public Page<Employee> find(String name, Long id, Integer age, String departmentName, Integer page, Integer size) {
        Specification<Employee> specification = combinationQueryConditions(name, id, age, departmentName);
        Pageable pageable = PageRequest.of(page - 1, size);
        return employeeRepository.findAll(specification, pageable);
    }

    /**
     * 只是組Specification物件故不寫測試
     * @param name
     * @param id
     * @param age
     * @param departmentName
     * @return
     */
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
