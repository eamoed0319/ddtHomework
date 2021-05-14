package com.ddt.homework.demo.controller;

import com.ddt.homework.demo.model.Department;
import com.ddt.homework.demo.model.Employee;
import com.ddt.homework.demo.model.EmployeeVO;
import com.ddt.homework.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/new")
    public EmployeeVO addEmployee(@RequestParam String name,
                                  @RequestParam Integer gender,
                                  @RequestParam String phoneNumber,
                                  @RequestParam String address,
                                  @RequestParam Integer age,
                                  @RequestParam Long departmentId){
        Department department = new Department();
        department.setId(departmentId);
        Employee employee = new Employee(name, gender, phoneNumber, address, age, department);
        return employeeService.save(employee);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/update")
    public EmployeeVO updateEmployee(@RequestParam long id,
                                     @RequestParam String name,
                                     @RequestParam Integer gender,
                                     @RequestParam String phoneNumber,
                                     @RequestParam String address,
                                     @RequestParam Integer age,
                                     @RequestParam Long departmentId){
        Department department = new Department();
        department.setId(departmentId);
        Employee employee = new Employee(name, gender, phoneNumber, address, age, department);
        employee.setId(id);
        employee.setCreateTime(employeeService.getOne(id).getCreateTime());
        return employeeService.save(employee);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public String deleteEmployee(@PathVariable long id){
        employeeService.deleteById(id);
        return "SUCCESS";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/all")
    public Page<Employee> findByCondition(@RequestParam(required = false) String name,
                                          @RequestParam(required = false) Long id,
                                          @RequestParam(required = false) Integer age,
                                          @RequestParam(required = false) String departmentName,
                                          @RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "10") Integer size){
        return employeeService.findAll(name, id, age, departmentName, page - 1, size);
    }
}
