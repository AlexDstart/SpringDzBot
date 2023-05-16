package ru.skypro.lessons.springboot.weblibrary.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.weblibrary.controller.List.Employee;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final List<Employee> employeeList = List.of(
            new Employee("Алексей", 40_000),
            new Employee("Виктор", 15_000),
            new Employee("Иван", 60_000),
            new Employee("Влад", 15_000));

    @Override
    public List<Employee> getListEmployees() {
        return employeeList;
    }
}
