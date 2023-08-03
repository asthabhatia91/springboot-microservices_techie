package net.javatech.employeeservice.service;

import lombok.AllArgsConstructor;
import net.javatech.employeeservice.dto.APIResponseDTO;
import net.javatech.employeeservice.dto.DepartmentDto;
import net.javatech.employeeservice.dto.EmployeeDto;
import net.javatech.employeeservice.entity.Employee;
import net.javatech.employeeservice.repository.IEmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {
    IEmployeeRepository employeeRepository;
   // private RestTemplate restTemplate;
   //private WebClient webClient;
    private IAPIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee emp= new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDeptCode());
        Employee savedEmployee = employeeRepository.save(emp);
        return new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDeptCode()
        );
    }

    @Override
    public APIResponseDTO getEmployeeById(Long empId) {
        Employee employee=employeeRepository.findById(empId).get();
//        ResponseEntity<DepartmentDto> responseEntity= restTemplate.getForEntity(
//                "http://localhost:8080/api/departments/dept/"+employee.getDeptCode(),
//                DepartmentDto.class
//        );
        //DepartmentDto departmentDto= responseEntity.getBody();
//        DepartmentDto departmentDto= webClient.get().uri("http://localhost:8080/api/departments/dept/"+employee.getDeptCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        DepartmentDto departmentDto=apiClient.getDepartment(employee.getDeptCode());


        EmployeeDto empDto= new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDeptCode()
        );
        APIResponseDTO apiResponseDTO= new APIResponseDTO();
        apiResponseDTO.setDeptDto(departmentDto);
        apiResponseDTO.setEmpDto(empDto);

        return apiResponseDTO;


    }
}
