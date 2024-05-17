package com.example.demo.controller;

import com.example.demo.BonusResponse;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeListWrapper;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public ResponseEntity<String> saveEmployees(@RequestBody EmployeeListWrapper employeeListWrapper) {
        List<Employee> employees = employeeListWrapper.getEmployees();
        try {
            employeeService.saveEmployees(employees);
        } catch (Exception e) {
            return new ResponseEntity<>("Error Occurred while storing employee data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Employees details  saved successfully", HttpStatus.CREATED);
    }
}
