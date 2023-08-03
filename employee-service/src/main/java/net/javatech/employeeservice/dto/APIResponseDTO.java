package net.javatech.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class APIResponseDTO {
    private EmployeeDto empDto;
    private DepartmentDto deptDto;
}
