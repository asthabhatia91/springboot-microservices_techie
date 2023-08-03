package net.javatech.employeeservice.service;

import net.javatech.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(url="http://localhost:8080", value="DEPARTMENT-SERVICE")
@FeignClient(name="DEPARTMENT-SERVICE")
public interface IAPIClient {
    @GetMapping("api/departments/dept/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String deptCode);

}
