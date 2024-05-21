package com.example.demo.model;




import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String empName;
    @Column
    private double amount;
    @Column
    private String currency;

    @Temporal(TemporalType.DATE)
    private Date joiningDate;

    @Temporal(TemporalType.DATE)
    private Date exitDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;


    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = parseDate(joiningDate);
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(String exitDate) {
        this.exitDate = parseDate(exitDate);
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(String departmentName) {
        Department department=new Department();
        department.setDepartment(departmentName);
        this.department = department;
    }
    private Date parseDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("MMM-dd-yyyy");
        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}