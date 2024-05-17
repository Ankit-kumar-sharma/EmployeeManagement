package com.example.demo.service;

import com.example.demo.BonusData;
import com.example.demo.BonusResponse;
import com.example.demo.CustomDateUtility;
import com.example.demo.EmployeeBonus;
import com.example.demo.model.Employee;
import com.example.demo.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Date;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> saveEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    public BonusResponse getEligibleEmployeeForBonus(String date) {
        BonusResponse response = new BonusResponse();
        List<BonusData> bonusDataList = new ArrayList<>();

        Date dateAfterParsing = CustomDateUtility.parseDate(date);
        if (dateAfterParsing == null) {
            response.setErrorMessage("Unable to Parse the date Kindly check date and try again!");
            return response;
        }
        List<Employee> eligibleEmployees = new ArrayList<>();
        try {
            eligibleEmployees = employeeRepository.findEligibleEmployees(dateAfterParsing);
        } catch (Exception e) {
            response.setErrorMessage("Error Occurred while fetching employees data!");
            return response;
        }
        if(eligibleEmployees==null || eligibleEmployees.size()==0){
            response.setErrorMessage("No Data available,Kindly add the data first then try to get it !");
            return response;
        }

        // Group employees by currency
        Map<String, List<Employee>> currencyMap = eligibleEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getCurrency));

        for (Map.Entry<String, List<Employee>> entry : currencyMap.entrySet()) {
            String currency = entry.getKey();
            List<Employee> employees = entry.getValue();

            // Sort employees by name
            employees.sort(Comparator.comparing(Employee::getEmpName));

            // Map employees to EmployeeBonus objects
            List<EmployeeBonus> employeeBonuses = employees.stream()
                    .map(employee -> new EmployeeBonus(employee.getEmpName(), employee.getAmount()))
                    .collect(Collectors.toList());

            bonusDataList.add(new BonusData(currency, employeeBonuses));
        }

        response.setData(bonusDataList);
        return response;
    }

}


