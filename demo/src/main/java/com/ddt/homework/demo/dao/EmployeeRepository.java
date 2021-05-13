package com.ddt.homework.demo.dao;

import com.ddt.homework.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT * FROM EMPLOYEE WHERE NAME = ?1", nativeQuery = true)
    Employee findByName(String name);

    void deleteById(long id);

//    @Query(value = "INSERT INTO EMPLOYEE (NAME, DEPARTMENT_ID, GENDER, PHONE_NUMBER, ADDRESS,AGE, CREATE_TIME, UPDATE_TIME)" +
//            "values (?1,?2,?3,?4,?5,?6,?7);"
//            , nativeQuery = true)
//    Employee save(String name, Long departmentId, Integer gender, PHONE_NUMBER);
}
