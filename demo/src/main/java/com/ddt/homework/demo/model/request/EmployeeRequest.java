package com.ddt.homework.demo.model.request;

import com.ddt.homework.demo.model.entity.Department;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class EmployeeRequest implements Serializable {

    public EmployeeRequest() {
    }

    public EmployeeRequest(Long id, String name, Integer gender, String phoneNumber, String address, Integer age, Long departmentId) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.age = age;
        this.departmentId = departmentId;
    }

    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private Integer gender;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String address;
    @NotNull
    private Integer age;
    @NotNull
    private Long departmentId;
}
