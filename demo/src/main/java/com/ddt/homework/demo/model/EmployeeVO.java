package com.ddt.homework.demo.model;

import com.ddt.homework.demo.model.entity.Employee;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeVO {

    public EmployeeVO() {
    }

    public EmployeeVO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.gender = employee.getGender();
        this.phoneNumber = employee.getPhoneNumber();
        this.address = employee.getAddress();
        this.age = employee.getAge();
        this.createTime = employee.getCreateTime();
        this.updateTime = employee.getUpdateTime();
        this.departmentId = employee.getDepartment().getId();
        this.departmentName = employee.getDepartment().getName();
    }

    private Long id;
    private String name;
    private Integer gender;
    private String phoneNumber;
    private String address;
    private Integer age;
    private Date createTime;
    private Date updateTime;
    private Long departmentId;
    private String departmentName;

}
