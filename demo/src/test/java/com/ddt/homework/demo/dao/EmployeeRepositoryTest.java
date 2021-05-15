package com.ddt.homework.demo.dao;

import com.ddt.homework.demo.servoceImpl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class EmployeeRepositoryTest {

    @Mock
    private EmployeeRepository employeeRepositoryTest;

    @Test
    void deleteById() {
        // Run the test
        employeeRepositoryTest.deleteById(0L);

        // Verify the results
        verify(employeeRepositoryTest).deleteById(0L);
    }
}