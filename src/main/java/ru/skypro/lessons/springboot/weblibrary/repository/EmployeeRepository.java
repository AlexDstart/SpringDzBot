package ru.skypro.lessons.springboot.weblibrary.repository;



import ru.skypro.lessons.springboot.weblibrary.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getListEmployees();
    void addEmployee(List<Employee> employees);



    List<Employee> getListEmployeesForDeleting();

    void editEmployee(int id, Employee newEmployee);

    void removeEmployee(Employee employee);

    void findEmployeeById(int id);


}