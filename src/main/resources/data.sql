-- Departments
INSERT INTO department (id, name, budget) VALUES (1, 'Engineering', 1000000);
INSERT INTO department (id, name, budget) VALUES (2, 'HR', 300000);
INSERT INTO department (id, name, budget) VALUES (3, 'IT', 500000);

-- Employees
INSERT INTO employee (id, name, email, department_id, date_of_joining, salary, manager_id)
VALUES (1, 'John Doe', 'john@example.com', 1, '2022-01-10', 85000, null);

INSERT INTO employee (id, name, email, department_id, date_of_joining, salary, manager_id)
VALUES (2, 'Jane Smith', 'jane@example.com', 1, '2020-03-01', 120000, null);

INSERT INTO employee (id, name, email, department_id, date_of_joining, salary, manager_id)
VALUES (3, 'Mike Brown', 'mike@example.com', 2, '2023-07-15', 65000, 2);

-- Projects
INSERT INTO project (id, name, start_date, end_date, department_id)
VALUES (1, 'Payroll System', '2023-01-01', '2023-12-31', 1),
       (2, 'HR Migration', '2024-01-01', '2024-12-31', 2);

-- Employee_Project
INSERT INTO employee_project (id, employee_id, project_id, assigned_date, role)
VALUES (1, 1, 1, '2023-01-15', 'Developer'),
       (2, 1, 2, '2024-01-01', 'Consultant'),
       (3, 3, 2, '2024-02-01', 'Support');

-- Performance Reviews
INSERT INTO performance_review (id, employee_id, review_date, score, review_comments)
VALUES (1, 1, '2024-12-01', 4, 'Consistent improvement'),
       (2, 1, '2024-06-01', 3, 'Needs mentorship'),
       (3, 1, '2023-12-01', 5, 'Excellent work'),
       (4, 3, '2024-06-01', 4, 'Good collaboration');
