package com.ddt.homework.demo.servoceImpl;

import com.ddt.homework.demo.dao.EmployeeRepository;
import com.ddt.homework.demo.model.entity.Department;
import com.ddt.homework.demo.model.entity.Employee;
import com.ddt.homework.demo.model.request.EmployeeRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository mockEmployeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeServiceImplUnderTest;

    @Test
    void testSave() {
        // Setup
        final EmployeeRequest request = new EmployeeRequest(1L, "name", 0, "phoneNumber", "address", 0, 0L);
        final Department department = new Department();
        department.setId(0L);
        final Employee expectedResult = new Employee("name", 0, "phoneNumber", "address", 0, department);
        expectedResult.setId(1L);

        // Configure EmployeeRepository.getOne(...).
        final Department department1 = new Department();
        department1.setId(0L);
        final Employee employee = new Employee("name", 0, "phoneNumber", "address", 0, department1);
        employee.setId(1L);
        when(mockEmployeeRepository.getOne(1L)).thenReturn(employee);
        when(mockEmployeeRepository.save(employee)).thenReturn(employee);

        // Run the test
        final Employee result = employeeServiceImplUnderTest.save(request);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetOne() {
        // Setup
        final Department department = new Department();
        department.setId(0L);
        department.setName("name");
        department.setEmployees(Arrays.asList(new Employee("name", 0, "phoneNumber", "address", 0, new Department())));
        final Employee expectedResult = new Employee("name", 0, "phoneNumber", "address", 0, department);

        // Configure EmployeeRepository.getOne(...).
        final Department department1 = new Department();
        department1.setId(0L);
        department1.setName("name");
        department1.setEmployees(Arrays.asList(new Employee("name", 0, "phoneNumber", "address", 0, new Department())));
        final Employee employee = new Employee("name", 0, "phoneNumber", "address", 0, department1);
        when(mockEmployeeRepository.getOne(0L)).thenReturn(employee);

        // Run the test
        final Employee result = employeeServiceImplUnderTest.getOne(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testDeleteById() {
        // Run the test
        employeeServiceImplUnderTest.deleteById(0L);

        // Verify the results
        verify(mockEmployeeRepository).deleteById(0L);
    }

    @Test
    void testFind() {
        // Configure EmployeeRepository.findAll(...).
        final Department department = new Department();
        department.setId(0L);
        department.setName("name");
        Employee employee = new Employee("name", 0, "phoneNumber", "address", 0, department);
        employee.setId(1L);
        final Page<Employee> employees = new PageImpl<>(Arrays.asList(employee));
        when(mockEmployeeRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(employees);

        // Run the test
        final Page<Employee> result = employeeServiceImplUnderTest.find("name", 0L, 0, "departmentName", 1, 10);

        // Verify the results
        assertThat(employeeServiceImplUnderTest.find("name", 0L, 0, "departmentName", 1, 10).getContent().get(0).getId()).isEqualTo(1L);
    }
}
