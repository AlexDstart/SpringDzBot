package ru.skypro.lessons.springboot.weblibrary.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final List<Employee> employeeList = new ArrayList<>();

    public EmployeeRepositoryImpl() {
        employeeList.add(new Employee(1, "Алексей", 40_000));
        employeeList.add(new Employee(2, "Виктор", 15_000));
        employeeList.add(new Employee(3, "Иван", 60_000));
        employeeList.add(new Employee(4, "Влад", 15_000));
    }

    @Override
    public List<Employee> getListEmployees() {
        return employeeList;
    }

    @Override
    public void addEmployee(List<Employee> employees) {
        employees.addAll(employeeList);
    }

    @Override
    public void editEmployee(int id, Employee newEmployee) {
        for (Employee employee : employeeList) {
            if (employee != null) {
                if (employee.getId() == id) {
                    employeeList.remove(employee);
                    employeeList.add(newEmployee);

                }
            }


        }
    }


    @Override
    public List<Employee> getListEmployeesForDeleting() {
        return null;
    }


    @Override
    public void removeEmployee(Employee employee) {
        employeeList.remove(employee);
    }


    @Override
    public void findEmployeeById(int id) {
        for (Employee employee : employeeList) {
            if(employee!= null){
              if(employee.getId()==id){
                  System.out.println(employee.getName() +" "+ employee.getSalary()+" "+ employee.getId());
              }

            }
        }
    }

}
