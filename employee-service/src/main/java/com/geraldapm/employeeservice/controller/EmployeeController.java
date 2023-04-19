package com.geraldapm.employeeservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geraldapm.employeeservice.dto.BaseResponse;
import com.geraldapm.employeeservice.model.Employee;
import com.geraldapm.employeeservice.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public ResponseEntity<BaseResponse<Employee>> add(@RequestBody Employee department) {
        Employee employeeResponse = employeeRepository.addEmployee(department);
        LOGGER.info("Employee add: {}", department);
        return ResponseEntity.ok(new BaseResponse<>(employeeResponse));
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<Employee>>> findAll() {
        List<Employee> employeeResponse = employeeRepository.findAll();
        LOGGER.info("Employee find all");
        return ResponseEntity.ok(new BaseResponse<>(employeeResponse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<Employee>> findById(@PathVariable Long id) {
        Employee employeeResponse = employeeRepository.findById(id);
        LOGGER.info("Employee find by id={}", id);
        return ResponseEntity.ok(new BaseResponse<>(employeeResponse));
    }

}
