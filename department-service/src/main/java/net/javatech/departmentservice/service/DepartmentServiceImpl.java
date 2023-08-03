package net.javatech.departmentservice.service;

import lombok.AllArgsConstructor;
import net.javatech.departmentservice.dto.DepartmentDto;
import net.javatech.departmentservice.entity.Department;
import net.javatech.departmentservice.repository.IDepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements IDepartmentService {

    private IDepartmentRepository deptRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto deptDto) {
        Department dept = new Department(
                deptDto.getId(),
                deptDto.getDeptName(),
                deptDto.getDeptDescription(),
                deptDto.getDeptCode()
        );
        Department saveDept = deptRepository.save(dept);
        DepartmentDto savedDto= new DepartmentDto(
          saveDept.getId(),
          saveDept.getDeptName(),
          saveDept.getDeptDescription(),
          saveDept.getDeptCode()
        );
        return savedDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String deptCode) {

        Department dept = deptRepository.findDepartmentByDeptCode(deptCode);
        return new DepartmentDto(dept.getId(), dept.getDeptName(),dept.getDeptDescription(), dept.getDeptCode());
    }
    @Override
    public DepartmentDto getAllDepartments() {
        return null;
    }
}
