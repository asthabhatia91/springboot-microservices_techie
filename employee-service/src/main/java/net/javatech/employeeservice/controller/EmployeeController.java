package net.javatech.employeeservice.controller;

import lombok.AllArgsConstructor;
import net.javatech.employeeservice.dto.APIResponseDTO;
import net.javatech.employeeservice.dto.EmployeeDto;
import net.javatech.employeeservice.service.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    IEmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto empDto){
        EmployeeDto savedEmployeeDto= employeeService.saveEmployee(empDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDTO> getEmployee(@PathVariable("id") Long empId){
        APIResponseDTO apiResponseDTO=employeeService.getEmployeeById(empId);
        return new ResponseEntity<>(apiResponseDTO, HttpStatus.OK);
    }

}
