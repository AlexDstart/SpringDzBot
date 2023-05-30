package ru.skypro.lessons.springboot.weblibrary.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Employee> findByPositionName(String positionName);
    List<Employee> findBySalaryGreaterThan(int compareSalary);



    List<Employee> getListEmployeesForDeleting();

    List<Employee> findAllByOrderBySalaryDesc();

    Page<Employee> findAll(Pageable pageable);

    void removeEmployee(Employee employee);

    void findEmployeeById(int id);


}