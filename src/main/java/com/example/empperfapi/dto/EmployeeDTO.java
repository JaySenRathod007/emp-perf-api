package com.example.empperfapi.dto;

import java.util.List;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private String department;
    private List<String> projects;
    private Double salary;

    public EmployeeDTO(Long id, String name, String email, String department, List<String> projects, Double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.projects = projects;
        this.salary = salary;
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

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}

