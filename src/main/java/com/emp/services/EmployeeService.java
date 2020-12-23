package com.emp.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.emp.bean.Employee;
import com.emp.bean.EmployeeDTO;
import com.emp.dao.EmployeeDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeDAO empDao;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        var listEmp = empDao.findAll();
        return listEmp.stream().map(e -> new EmployeeDTO(e.getEid(), e.getEname(), e.getEmail(), e.getSalary(),
                e.getPhone(), e.getRole(), e.getDept())).collect(Collectors.toList());
    }

    @Override
    public Optional<EmployeeDTO> getEmployeeByID(final Integer id) {
        Optional<Employee> emp = empDao.findById(id);
        if (emp.isPresent()) {
            var e = emp.get();
            return Optional.of(new EmployeeDTO(e.getEid(), e.getEname(), e.getEmail(), e.getSalary(), e.getPhone(),
                    e.getRole(), e.getDept()));
        } else {
            return Optional.of(null);
        }

    }

    @Override
    public EmployeeDTO addAndUpdateEmployee(EmployeeDTO e) {
        var emp = empDao
                .save(new Employee(e.getEname(), e.getEmail(), e.getSalary(), e.getPhone(), e.getRole(), e.getDept()));
        return new EmployeeDTO(emp.getEid(), emp.getEname(), emp.getEmail(), emp.getSalary(), emp.getPhone(),
                emp.getRole(), emp.getDept());
    }

    @Override
    public void deleteEmployee(EmployeeDTO e) {
        empDao.delete(new Employee(e.getEname(), e.getEmail(), e.getSalary(), e.getPhone(), e.getRole(), e.getDept()));
    }

}
