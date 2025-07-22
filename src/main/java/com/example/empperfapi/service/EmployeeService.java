package com.example.empperfapi.service;

import com.example.empperfapi.dto.EmployeeDTO;
import com.example.empperfapi.dto.EmployeeDetailsDTO;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getFilteredEmployees(LocalDate reviewDate, Integer score, List<String> departments, List<String> projects);

    EmployeeDetailsDTO getEmployeeDetailsById(Long id);
}
