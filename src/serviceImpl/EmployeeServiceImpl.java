package serviceImpl;

import database.DataBase;
import model.Employee;
import model.Pharmacy;
import service.EmployeeService;
import service.PharmacyService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public String saveEmployee(Employee employee) {
        DataBase.employees.add(employee);
        return null;
    }

    @Override
    public boolean assignEmployeeToPharmacy(Long pharmacyId, Long employeeId) {
    return true;
    }

    @Override
    public List<Employee> getAllEmployee(Long pharmacyId) {
        return DataBase.employees;
    }

    @Override
    public Employee getByIdEmployee(Long pharmacyId, Long employeeId) {
            for (Pharmacy pharmacy : DataBase.pharmacies){
                if (pharmacy.getId()==pharmacyId){
                    for (Employee employee:pharmacy.getEmployees()){
                        if (employee.getId() == employeeId){
                            return employee;
                        }
                    }
                }
            }
        return null;
    }

    @Override
    public String updateEmployeeById(Long pharmacyId, Long employeeId, Employee newEmployee) {
        return null;
    }

    @Override
    public String deleteEmployeeById(Long pharmacyId, Long employeeId) {
        for (Pharmacy pharmacy : DataBase.pharmacies){
            if (pharmacy.getId()==pharmacyId){
                for (Employee employee:pharmacy.getEmployees()){
                    if (employee.getId()==employeeId){
                        DataBase.employees.remove(employee);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public List<Employee> filterEmployeeByPosition(String position) {
        List<Employee>filterEmployee = new ArrayList<>();
        for (Employee employee: DataBase.employees){
            if (employee.getPosition().equals(position)){
                filterEmployee.add(employee);
            }
        }
        return filterEmployee;
    }

}
