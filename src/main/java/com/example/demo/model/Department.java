package com.example.demo.model;

import jakarta.persistence.*;


@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long department_id;

    @Column
    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String name) {
        this.department = name;
    }

}