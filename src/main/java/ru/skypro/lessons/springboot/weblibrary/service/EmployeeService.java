package ru.skypro.lessons.springboot.weblibrary.service;

import ru.skypro.lessons.springboot.weblibrary.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    String getEmployeeSalaryTotalSum();
    String getEmployeeSalaryMinSum();
    String getEmployeeSalaryMaxSum();

    String getEmployeeHighSalary();

    Optional<Employee> findEmployeeById(int id);

    void addEmployee(List<Employee> employees);

    void editEmployee(int id, Employee newEmployee);

    String getEmployeeById(int id);

    void deleteEmployeeById(int id);

    String getEmployeesWithSalaryHigherThan(int compareSalary);
}
