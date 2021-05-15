package com.ddt.homework.demo.controller;

import com.ddt.homework.demo.model.entity.Department;
import com.ddt.homework.demo.model.entity.Employee;
import com.ddt.homework.demo.model.request.EmployeeRequest;
import com.ddt.homework.demo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService mockEmployeeService;

    @Test
    void testAddEmployee() throws Exception {
        // Configure EmployeeService.save(...).
        final Department department = new Department();
        department.setId(1L);
        final Employee employee = new Employee("Sunny14", 1, "0912345677", "taipei2", 20, department);
        employee.setId(1L);
        final EmployeeRequest employeeRequest = new EmployeeRequest(1L, "Sunny14", 1, "0912345677", "taipei2", 20, 1L);
        when(mockEmployeeService.save(employeeRequest)).thenReturn(employee);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(employeeRequest);
        final MockHttpServletResponse response = mockMvc.perform(put("/employee")
                .content(requestJson).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(mockEmployeeService.save(employeeRequest)).isInstanceOf(Employee.class);
    }

    @Test
    void testUpdateEmployee() throws Exception {
        // Configure EmployeeService.save(...).
        final Department department = new Department();
        department.setId(1L);
        final Employee employee = new Employee("Sunny14", 1, "0912345677", "taipei2", 20, department);
        employee.setId(1L);
        final EmployeeRequest employeeRequest = new EmployeeRequest(1L, "Sunny14", 1, "0912345677", "taipei2", 20, 1L);
        when(mockEmployeeService.save(employeeRequest)).thenReturn(employee);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(employeeRequest);
        final MockHttpServletResponse response = mockMvc.perform(put("/employee")
                .content(requestJson).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(mockEmployeeService.save(employeeRequest)).isEqualTo(employee);
    }

    @Test
    void testDeleteEmployee() throws Exception {
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(delete("/employee/{id}", 11)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("SUCCESS");
    }

    @Test
    void testFindByCondition() throws Exception {
        // Configure EmployeeService.findAll(...).
        final Department department = new Department();
        department.setId(1L);
        department.setName("department1");
        Employee employee = new Employee("Sunny1", 1, "0912345678", "taiwan", 32, department);
        employee.setId(1L);
        final Page<Employee> employees = new PageImpl<>(Collections.singletonList(employee));
        when(mockEmployeeService.find("Sunny1", 1L, 32, "department1", 1, 10)).thenReturn(employees);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/employee")
                .param("name", "Sunny1")
                .param("id", "1")
                .param("age", "32")
                .param("departmentName", "department1")
                .param("page", "1")
                .param("size", "10")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(mockEmployeeService.find("Sunny1", 1L, 32, "department1", 1, 10).getContent().get(0).getId()).isEqualTo(1L);
    }
}
