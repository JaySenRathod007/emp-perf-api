package com.example.empperfapi.dto;

import java.time.LocalDate;
import java.util.List;

public class EmployeeDetailsDTO {
    private Long id;
    private String name;
    private String email;
    private String department;
    private Double salary;
    private LocalDate dateOfJoining;
    private String managerName;

    private List<String> projectNames;
    private List<PerformanceReviewDTO> recentReviews;

    public EmployeeDetailsDTO(Long id, String name, String email, String department, Double salary, LocalDate dateOfJoining, String managerName, List<String> projectNames, List<PerformanceReviewDTO> recentReviews) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
        this.managerName = managerName;
        this.projectNames = projectNames;
        this.recentReviews = recentReviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public List<String> getProjectNames() {
        return projectNames;
    }

    public void setProjectNames(List<String> projectNames) {
        this.projectNames = projectNames;
    }

    public List<PerformanceReviewDTO> getRecentReviews() {
        return recentReviews;
    }

    public void setRecentReviews(List<PerformanceReviewDTO> recentReviews) {
        this.recentReviews = recentReviews;
    }
}

