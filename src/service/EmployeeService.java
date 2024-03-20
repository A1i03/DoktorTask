package service;

import model.Employee;

import java.util.List;

public interface EmployeeService {
    String saveEmployee(Employee employee);
    boolean assignEmployeeToPharmacy(Long pharmacyId,Long employeeId);
    List<Employee> getAllEmployee(Long pharmacyId);
    Employee getByIdEmployee(Long pharmacyId,Long employeeId);
    String updateEmployeeById(Long pharmacyId,Long employeeId,Employee newEmployee);
    String deleteEmployeeById(Long pharmacyId,Long employeeId);

    List<Employee> filterEmployeeByPosition(String position);



}