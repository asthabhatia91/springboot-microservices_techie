package net.javatech.employeeservice.service;

import net.javatech.employeeservice.dto.APIResponseDTO;
import net.javatech.employeeservice.dto.EmployeeDto;
import net.javatech.employeeservice.entity.Employee;

public interface IEmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDTO getEmployeeById(Long empId);
}
