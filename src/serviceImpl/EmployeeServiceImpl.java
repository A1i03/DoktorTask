package serviceImpl;

import database.DataBase;
import enums.Position;
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
        return "Ийгиликтуу кошулду: ";
    }

    @Override
    public String assignEmployeeToPharmacy(Long pharmacyId, Long employeeId) {
        for (Pharmacy pharmacy : DataBase.pharmacies){
            if (pharmacy.getId() == pharmacyId){
                for (Employee employee : pharmacy.getEmployees()){
                    if (employee.getId() == employeeId){
                        pharmacy.getEmployees().add(employee);
                        return "Ийгиликтуу кошулду: ";
                    }
                }
            }
        }
    return "Табылбады!!!";
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
        for (Pharmacy pharmacy : DataBase.pharmacies){
            if (pharmacy.getId() == pharmacyId){
                for (Employee employee : pharmacy.getEmployees()){
                    if (employee.getId() == employeeId){
                        employee.setFullName(newEmployee.getFullName());
                        employee.setEmail(newEmployee.getEmail());
                        employee.setPhoneNumber(newEmployee.getPhoneNumber());
                        employee.setExperience(newEmployee.getExperience());
                        employee.setPosition(newEmployee.getPosition());
                        employee.setGender(newEmployee.getGender());
                        return "Ийгиликтуу озгорду!!!";
                    }

                }
            }
        }

        return "Табылган жок!!!";
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

    public List<Employee> filterEmployeeByPosition(String position) {
        List<Employee> admin = new ArrayList<>();
        List<Employee> pharmacist = new ArrayList<>();
        List<Employee> teller = new ArrayList<>();
        if (position.equalsIgnoreCase("ADMIN")){
            for (Employee employee : DataBase.employees) {
                if (employee.getPosition().equals(Position.ADMIN)){
                    admin.add(employee);
                }
            }
            return admin;
        }else if (position.equalsIgnoreCase("PHARMACIST")){
            for (Employee employee : DataBase.employees) {
                if (employee.getPosition().equals(Position.PHARMACIST)){
                    pharmacist.add(employee);
                }
            }
            return pharmacist;
        } else if (position.equalsIgnoreCase("TELLER")) {
            for (Employee employee : DataBase.employees) {
                if (employee.getPosition().equals(Position.TELLER)){
                    teller.add(employee);
                }
            }
            return teller;
        }
        System.err.println("Туура жазыныз!!!");
        return null;
    }

}
