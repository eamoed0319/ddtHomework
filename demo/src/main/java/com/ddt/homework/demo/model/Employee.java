package com.ddt.homework.demo.model;

import com.sun.tracing.ProviderName;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer departmentID;
    @Column(nullable = false)
    private Integer gender;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private Integer age;
    @CreatedDate
    @Column(nullable = false)
    private Date createTime;
    @LastModifiedDate
    @Column(nullable = false)
    private Date updateTime;

    @ManyToOne
    @JoinColumn(name="departmentID")
    private Department department;



}
