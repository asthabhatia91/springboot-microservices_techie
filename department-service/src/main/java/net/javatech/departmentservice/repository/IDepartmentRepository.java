package net.javatech.departmentservice.repository;

import net.javatech.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Long> {
    Department findDepartmentByDeptCode(String deptCode);
}
