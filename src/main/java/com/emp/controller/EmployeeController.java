package com.emp.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.emp.bean.EmployeeDTO;
import com.emp.expection.EmployeeNotFoundException;
import com.emp.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping(path = { "", "/all" })
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        var employeesList = service.getAllEmployees();
        return new ResponseEntity<>(employeesList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Object> findEmployeeById(@PathVariable Integer id) {
        var employeeByID = service.getEmployeeByID(id);
        if (employeeByID.isPresent()) {
            return new ResponseEntity<>(employeeByID.get(), new HttpHeaders(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee ID With " + id + " Not Found !", new HttpHeaders(), HttpStatus.OK);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addAndUpdateEmployee(@Valid @RequestBody EmployeeDTO emp) {
        var insertedEmp = service.addAndUpdateEmployee(emp);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/employee/find/{id}")
                .buildAndExpand(insertedEmp.getEid()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        Optional<EmployeeDTO> e = service.getEmployeeByID(id);
        if (e.isPresent()) {
            service.deleteEmployee(e.get());
            return new ResponseEntity<>("Deleted", new HttpHeaders(), HttpStatus.FORBIDDEN);
        } else {
            throw new EmployeeNotFoundException("Employee with ID: " + id + " Not Found !");
        }
    }
}