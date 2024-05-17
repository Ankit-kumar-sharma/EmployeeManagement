package com.example.demo;

public class EmployeeBonus {
    private String empName;
    private double amount;

    public EmployeeBonus() {
    }

    public EmployeeBonus(String empName, double amount) {
        this.empName = empName;
        this.amount = amount;
    }

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
}