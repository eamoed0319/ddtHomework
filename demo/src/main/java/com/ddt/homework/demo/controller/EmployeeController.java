package com.ddt.homework.demo.controller;

import com.ddt.homework.demo.model.entity.Employee;
import com.ddt.homework.demo.model.request.EmployeeRequest;
import com.ddt.homework.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;

@RestController
@RequestMapping("/employee")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody EmployeeRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.save(request));
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody EmployeeRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.save(request));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id){
        employeeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("SUCCESS");
    }

    @GetMapping
    public ResponseEntity<Page<Employee>> findByCondition(@RequestParam(required = false) String name,
                                          @RequestParam(required = false) Long id,
                                          @RequestParam(required = false) Integer age,
                                          @RequestParam(required = false) String departmentName,
                                          @RequestParam(defaultValue = "1", required = false) Integer page,
                                          @RequestParam(defaultValue = "10", required = false) @Max(value=10, message = "pageSize必須小於或等於10") Integer pageSize){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.find(name, id, age, departmentName, page, pageSize));
    }
}
