package net.javatech.departmentservice.service;

import net.javatech.departmentservice.dto.DepartmentDto;

public interface IDepartmentService {
    DepartmentDto saveDepartment(DepartmentDto deptDto);
    DepartmentDto getDepartmentByCode(String deptCode);
    DepartmentDto getAllDepartments();
}
