package com.example.demo.controller;

import com.example.demo.BonusResponse;
import com.example.demo.model.EmployeeListWrapper;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tci")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("//employee-bonus")
    public BonusResponse getEmployeeBonus(@RequestParam("date") String date) {
        return employeeService.getEligibleEmployeeForBonus(date);
    }

    @PostMapping("/employee-bonus")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeListWrapper employee) {
        try {
            employeeService.saveEmployees(employee.getEmployees());
            return new ResponseEntity<>("Employee saved successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error saving employees: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
