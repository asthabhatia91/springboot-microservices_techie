package net.javatech.departmentservice.controller;

import lombok.AllArgsConstructor;
import net.javatech.departmentservice.dto.DepartmentDto;
import net.javatech.departmentservice.service.IDepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private IDepartmentService deptService;

    // Build save dept REST Api
    @PostMapping("/submit")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto deptDto){
        DepartmentDto savedDeptDto= deptService.saveDepartment(deptDto);
        return new ResponseEntity<>(savedDeptDto, HttpStatus.CREATED);
    }

    @GetMapping("/dept/{department-code}")
    public  ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String deptCode){
        DepartmentDto deptDto= deptService.getDepartmentByCode(deptCode);
        return new ResponseEntity<>(deptDto, HttpStatus.OK);
    }

}
