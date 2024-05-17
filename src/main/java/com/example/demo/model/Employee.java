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
    private String department;
    @Column
    private double amount;
    @Column
    private String currency;

    @Temporal(TemporalType.DATE)
    private Date joiningDate;

    @Temporal(TemporalType.DATE)
    private Date exitDate;

    public Employee() {
    }
    public void setEmpName(String empName){
        this.empName=empName;
    }
    public void setDepartment(String department){
        this.department=department;
    }
    public void setAmount(double amount){
        this.amount=amount;
    }
    public void setCurrency(String currency){
        this.currency=currency;
    }
    public String getCurrency(){
        return this.currency;
    }
    public String getEmpName(){
        return this.empName;
    }
    public double getAmount(){
        return this.amount;
    }
    public void setJoiningDate(String joiningDateStr) {
        this.joiningDate = parseDate(joiningDateStr);
    }

    public void setExitDate(String exitDateStr) {
        this.exitDate = parseDate(exitDateStr);
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
