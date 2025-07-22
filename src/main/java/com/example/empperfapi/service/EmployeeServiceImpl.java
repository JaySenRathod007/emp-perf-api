package com.example.empperfapi.service;

import com.example.empperfapi.dto.EmployeeDTO;
import com.example.empperfapi.dto.EmployeeDetailsDTO;
import com.example.empperfapi.dto.PerformanceReviewDTO;
import com.example.empperfapi.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EntityManager entityManager;

    public EmployeeServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<EmployeeDTO> getFilteredEmployees(LocalDate reviewDate, Integer score, List<String> departments, List<String> projects) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);
        root.fetch("department", JoinType.LEFT);
        root.fetch("projects", JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<>();

        // Filter by department name (contains any)
        if (departments != null && !departments.isEmpty()) {
            Join<Employee, Department> deptJoin = root.join("department", JoinType.LEFT);
            Predicate deptPredicate = deptJoin.get("name").in(departments);
            predicates.add(deptPredicate);
        }

        // Filter by project name (contains any)
        if (projects != null && !projects.isEmpty()) {
            Join<Employee, EmployeeProject> epJoin = root.join("projects", JoinType.LEFT);
            Join<EmployeeProject, Project> projectJoin = epJoin.join("project", JoinType.LEFT);
            Predicate projectPredicate = projectJoin.get("name").in(projects);
            predicates.add(projectPredicate);
        }

        // Filter by review score for specific reviewDate
        if (reviewDate != null && score != null) {
            Subquery<Long> subquery = query.subquery(Long.class);
            Root<PerformanceReview> reviewRoot = subquery.from(PerformanceReview.class);
            subquery.select(reviewRoot.get("employee").get("id"))
                    .where(
                            cb.equal(reviewRoot.get("reviewDate"), reviewDate),
                            cb.equal(reviewRoot.get("score"), score)
                    );
            predicates.add(root.get("id").in(subquery));
        }

        query.select(root).distinct(true)
                .where(predicates.toArray(new Predicate[0]));

        List<Employee> employees = entityManager.createQuery(query).getResultList();

        // Map to DTO
        return employees.stream().map(e -> {
            String deptName = e.getDepartment() != null ? e.getDepartment().getName() : null;
            List<String> projectNames = e.getProjects() != null
                    ? e.getProjects().stream()
                    .map(ep -> ep.getProject().getName())
                    .collect(Collectors.toList())
                    : new ArrayList<>();
            return new EmployeeDTO(e.getId(), e.getName(), e.getEmail(), deptName, projectNames, e.getSalary());
        }).collect(Collectors.toList());
    }

    @Override
    public EmployeeDetailsDTO getEmployeeDetailsById(Long id) {
        Employee employee = entityManager.find(Employee.class, id);

        if (employee == null) {
            throw new RuntimeException("Employee not found with ID: " + id);
        }

        String deptName = employee.getDepartment() != null ? employee.getDepartment().getName() : null;
        String managerName = employee.getManager() != null ? employee.getManager().getName() : null;

        List<String> projectNames = employee.getProjects() != null
                ? employee.getProjects().stream()
                .map(ep -> ep.getProject().getName())
                .collect(Collectors.toList())
                : new ArrayList<>();

        List<PerformanceReviewDTO> recentReviews = employee.getReviews() != null
                ? employee.getReviews().stream()
                .sorted(Comparator.comparing(PerformanceReview::getReviewDate).reversed())
                .limit(3)
                .map(r -> new PerformanceReviewDTO(r.getReviewDate(), r.getScore(), r.getReviewComments()))
                .collect(Collectors.toList())
                : new ArrayList<>();

        return new EmployeeDetailsDTO(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                deptName,
                employee.getSalary(),
                employee.getDateOfJoining(),
                managerName,
                projectNames,
                recentReviews
        );
    }
}

