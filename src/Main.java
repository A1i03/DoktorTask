import model.Employee;
import serviceImpl.EmployeeServiceImpl;
import serviceImpl.MedicineServiceImpl;
import serviceImpl.PharmacyServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PharmacyServiceImpl pharmacyService = new PharmacyServiceImpl();
        MedicineServiceImpl medicineService = new MedicineServiceImpl();
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        while (true){
            System.out.println("Выбрать команду");
            System.out.println("""
                    ~~~~~~~~~~~~Pharmacy~~~~~~~~~~~~
                    1.savePharmacy
                    2.getAllPharmacy
                    3.gertByIdPharmacy
                    4.updatePharmacyById
                    5.deletePharmacyById
                    ~~~~~~~~~~~~Medicine~~~~~~~~~~~~
                    6.addMedicineToPharmacy
                    7.getAllMedicineByPharmacyId
                    8.getByIdMedicine
                    9.updateMedicineById // пака пустой
                    10.deleteMedicineById
                    11.sortByPrice
                    12.sortByDeliveryDate
                    13.sortByExpirationDate
                    ~~~~~~~~~~~~Employee~~~~~~~~~~~~
                    14.saveEmployee
                    15.assignEmployeeToPharmacy
                    16.getAllEmployee
                    17.getByIdEmployee
                    18.updateEmployeeById // пака пустой
                    19.deleteEmployeeById
                    20.filterEmployeeByPosition
                    """);
            int comanda = scanner1.nextInt();
            switch (comanda){
                case 1: {

                    break;
                }
                case 2: {

                    break;
                }
                case 3: {

                    break;
                }
                case 4: {

                    break;
                }
                case 5: {

                    break;
                }
                case 6: {

                    break;
                }
                case 7: {

                    break;
                }
                case 8: {

                    break;
                }
                case 9: {

                    break;
                }
                case 10: {

                    break;
                }
                case 11: {

                    break;
                }
                case 12: {

                    break;
                }
                case 133: {

                    break;
                }
                case 14: {

                    break;
                }
                case 15: {

                    break;
                }
                case 16: {

                    break;
                }
                case 17: {

                    break;
                }
                case 18: {

                    break;
                }
                case 19: {

                    break;
                }
                case 20: {

                    break;
                }

            }
        }
    }
}