package com.ddt.homework.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Employee")
@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler"})
public class Employee implements Serializable {

    public Employee() {
    }

    public Employee(String name, Integer gender, String phoneNumber, String address, Integer age, Department department) {
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.age = age;
        this.department = department;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer gender;
    private String phoneNumber;
    private String address;
    private Integer age;
    @CreatedDate
    private Date createTime;
    @LastModifiedDate
    private Date updateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="department_id")
    private Department department;
}
