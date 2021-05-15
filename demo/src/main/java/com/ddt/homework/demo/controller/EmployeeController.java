package com.ddt.homework.demo.controller;

import com.ddt.homework.demo.model.entity.Department;
import com.ddt.homework.demo.model.entity.Employee;
import com.ddt.homework.demo.model.request.EmployeeRequest;
import com.ddt.homework.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/employee")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public Employee addEmployee(@RequestBody EmployeeRequest request){
        return employeeService.save(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public Employee updateEmployee(@RequestBody EmployeeRequest request){
        return employeeService.save(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public String deleteEmployee(@PathVariable long id){
        employeeService.deleteById(id);
        return "SUCCESS";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<Employee> findByCondition(@RequestParam(required = false) String name,
                                          @RequestParam(required = false) Long id,
                                          @RequestParam(required = false) Integer age,
                                          @RequestParam(required = false) String departmentName,
                                          @RequestParam(defaultValue = "1", required = false) Integer page,
                                          @RequestParam(defaultValue = "10", required = false) @Max(value=10) Integer pageSize){
        return employeeService.find(name, id, age, departmentName, page, pageSize);
    }
}
