package com.emp.services;

import java.util.List;
import java.util.Optional;

import com.emp.bean.EmployeeDTO;

public interface IEmployeeService {

    public List<EmployeeDTO> getAllEmployees();

    public Optional<EmployeeDTO> getEmployeeByID(final Integer id);

    public EmployeeDTO addAndUpdateEmployee(EmployeeDTO emp);

    public void deleteEmployee(EmployeeDTO emp);

}
