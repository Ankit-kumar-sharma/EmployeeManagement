package com.example.demo;

import java.util.List;

public class BonusData {
    private String currency;
    private List<EmployeeBonus> employees;

    public BonusData() {
    }

    public BonusData(String currency, List<EmployeeBonus> employees) {
        this.currency = currency;
        this.employees = employees;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<EmployeeBonus> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeBonus> employees) {
        this.employees = employees;
    }
}