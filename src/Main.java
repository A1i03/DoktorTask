import database.GenerateId;
import enums.Gender;
import enums.Position;
import model.Employee;
import model.Medicine;
import model.Pharmacy;
import serviceImpl.EmployeeServiceImpl;
import serviceImpl.MedicineServiceImpl;
import serviceImpl.PharmacyServiceImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PharmacyServiceImpl pharmacyService = new PharmacyServiceImpl();
        MedicineServiceImpl medicineService = new MedicineServiceImpl();
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();



        while (true) {
            System.out.println("Выбрать команду: ");
            System.out.println("""
                    1.~~~~~~~~~~~~Pharmacy~~~~~~~~~~~~
                    2.~~~~~~~~~~~~Medicine~~~~~~~~~~~~
                    3.~~~~~~~~~~~~Employee~~~~~~~~~~~~
                                    
                    """);
            try {
                int com = new Scanner(System.in).nextInt();
                switch (com) {
                    case 1: {
                        boolean choice = true;
                        while (choice) {
                            System.out.println("Выбрать команду: ");
                            System.out.println("""
                                    1.savePharmacy
                                    2.getAllPharmacy
                                    3.getByIdPharmacy
                                    4.updatePharmacyById
                                    5.deletePharmacyById 
                                    6.Exit
                                           """);
                            try {
                                int comanda = new Scanner(System.in).nextInt();

                                switch (comanda) {
                                    case 1: {
                                        Pharmacy pharmacy = new Pharmacy();
                                        pharmacy.setId(GenerateId.genPharmacy());
                                        System.out.println("Аптеканын атын жаз: ");
                                        pharmacy.setName(new Scanner(System.in).nextLine());
                                        System.out.println("Аптеканын адресин жаз: ");
                                        pharmacy.setAddress(new Scanner(System.in).nextLine());
                                        System.out.println(pharmacyService.savePharmacy(pharmacy));
                                        break;

                                    }
                                    case 2: {
                                        System.out.println(pharmacyService.getAllPharmacy());
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("Аптеканын Id-жазыныз");
                                        System.out.println(pharmacyService.getByIdPharmacy(new Scanner(System.in).nextLong()));
                                        break;
                                    }
                                    case 4: {
                                        System.out.println("Кайсы аптеканы озгортун келсе ошонун ID-жаз:  ");
                                        Long id = new Scanner(System.in).nextLong();
                                        Pharmacy pharmacy = new Pharmacy();
                                        System.out.println("Аптеканын атын жаз: ");
                                        pharmacy.setName(new Scanner(System.in).nextLine());
                                        System.out.println("Аптеканын адресин жаз: ");
                                        pharmacy.setAddress(new Scanner(System.in).nextLine());
                                        System.out.println(pharmacyService.updatePharmacyById(id, pharmacy));
                                        break;
                                    }
                                    case 5: {
                                        System.out.println("ОЧуро турган аптеканы ID-жаз: ");
                                        System.out.println(pharmacyService.deletePharmacyById(new Scanner(System.in).nextLong()));
                                        break;
                                    }
                                    case 6: {
                                        choice = false;

                                    }

                                }



                            } catch (Exception e) {
                                System.out.println(" Туура жазсаныз боло!!!");
                            }
                        }
                        break;
                    }

                    case 2: {
                        boolean choice1 = true;
                        while (choice1) {
                            System.out.println("Выбрать команду");
                            System.out.println("""
                                    1addMedicineToPharmacy
                                    2.getAllMedicineByPharmacyId
                                    3.getByIdMedicine
                                    4.updateMedicineById // пака пустой
                                    5.deleteMedicineById
                                    6.sortByPrice
                                    7.sortByDeliveryDate
                                    8.sortByExpirationDate
                                            """);
                            try {
                                int comm = new Scanner(System.in).nextInt();

                                switch (comm) {
                                    case 1: {
                                        Medicine medicine = new Medicine();
                                        System.out.println("Аптеканын Id-жаз: ");
                                        Long id = new Scanner(System.in).nextLong();
                                        System.out.println("Даарынын атын жаз: ");
                                        medicine.setName(new Scanner(System.in).nextLine());
                                        System.out.println("Даарынын акчасын жаз: ");
                                        medicine.setPrice(new Scanner(System.in).nextInt());
                                        System.out.println("Канча даары бар жазыныз: ");
                                        medicine.setQuantity(new Scanner(System.in).nextInt());
                                        System.out.println("Даарынын описниясын  жаз: ");
                                        medicine.setDescription(new Scanner(System.in).nextLine());
                                        System.out.println("Даарын алып келген кунун Жаз: ");
                                        medicine.setDateOfDelivery(LocalDate.of(new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt()));
                                        System.out.println("Даарыны срогун жаз: ");
                                        medicine.setExpirationDate(LocalDate.of(new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt()));
                                        System.out.println(medicineService.addMedicineToPharmacy(id, medicine));
                                        break;
                                    }
                                    case 2: {
                                        System.out.println("Аптеканын id-жазыныз: ");
                                        System.out.println(medicineService.getAllMedicineByPharmacyId(new Scanner(System.in).nextLong()));
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("Аптеканын ID - жазыныз:  ");
                                        Long id = new Scanner(System.in).nextLong();
                                        System.out.println("Даарынын ID - жазыныз:  ");
                                        Long idd = new Scanner(System.in).nextLong();
                                        medicineService.getByIdMedicine(id, idd);
                                        break;
                                    }
                                    case 4: {
                                        System.out.println("Кайсыл даарыны озгорткунуз келсе ошонун ID-жазыныз: ");
                                        Long idPar = new Scanner(System.in).nextLong();
                                        System.out.println("Аптеканын Id-жаз: ");
                                        Long idMed = new Scanner(System.in).nextLong();
                                        Medicine medicine1 = new Medicine();
                                        System.out.println("Даарынын атын жаз: ");
                                        medicine1.setName(new Scanner(System.in).nextLine());
                                        System.out.println("Даарынын акчасын жаз: ");
                                        medicine1.setPrice(new Scanner(System.in).nextInt());
                                        System.out.println("Канча даары бар жазыныз: ");
                                        medicine1.setQuantity(new Scanner(System.in).nextInt());
                                        System.out.println("Даарынын описниясын  жаз: ");
                                        medicine1.setDescription(new Scanner(System.in).nextLine());
                                        System.out.println("Даарын алып келген кунун Жаз: ");
                                        medicine1.setDateOfDelivery(LocalDate.of(new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt()));
                                        System.out.println("Даарыны срогун жаз: ");
                                        medicine1.setExpirationDate(LocalDate.of(new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt()));
                                        System.out.println(medicineService.updateMedicineById(idPar, idMed, medicine1));
                                        break;
                                    }
                                    case 5: {
                                        System.out.println("Очуро турган Аптеканн Id- жазыныз: ");
                                        Long id = new Scanner(System.in).nextLong();
                                        System.out.println("Очуро турган Даарынын ID- жазыныз:  ");
                                        Long Idd = new Scanner(System.in).nextLong();
                                        medicineService.deleteMedicineById(id, Idd);
                                        break;
                                    }
                                    case 6: {
                                        System.out.println("asc или desc");
                                        System.out.println(medicineService.sortByPrice(new Scanner(System.in).nextLine()));
                                        break;
                                    }
                                    case 8: {
                                        System.out.println("asc или desc");
                                        System.out.println(medicineService.sortByDeliveryDate(new Scanner(System.in).nextLine()));
                                        break;
                                    }
                                    case 9: {
                                        System.out.println("asc или desc");
                                        System.out.println(medicineService.sortByExpirationDate(new Scanner(System.in).nextLine()));
                                        break;
                                    }
                                    case 10: {
                                        choice1 = false;
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Туура жазынызчы!!!");
                            }
                        }
                        break;
                    }
                    case 3: {
                        boolean choice2 = true;
                        while (choice2) {
                            System.out.println("Выбрать команду");
                            System.out.println("""
                                    1.saveEmployee
                                    2.assignEmployeeToPharmacy
                                    3.getAllEmployee
                                    4.getByIdEmployee
                                    5.updateEmployeeById // пака пустой
                                    6.deleteEmployeeById
                                    7.filterEmployeeByPosition
                                            """);
                            try {
                                int commanda = new Scanner(System.in).nextInt();
                                switch (commanda) {
                                    case 1: {
                                        Employee employee = new Employee();
                                        System.out.println("Жумушчунун ID-жазыныз: ");
                                        employee.setId(GenerateId.genEmployee());
                                        System.out.println("Жумушчунун ФИО жазыныз: ");
                                        employee.setFullName(new Scanner(System.in).nextLine());
                                        System.out.println("Жумушчунун Email - жазыныз: ");
                                        employee.setEmail(new Scanner(System.in).nextLine());
                                        System.out.println("Жумушчунун phoneNumber - жазыныз: ");
                                        employee.setPhoneNumber(new Scanner(System.in).nextLine());
                                        System.out.println("Жумушчунун experience - жазыныз: ");
                                        employee.setExperience(new Scanner(System.in).nextDouble());
                                        System.out.println("Жумушчунун position - жазыныз: " + Arrays.toString(Position.values()));
                                        employee.setPosition(Position.valueOf(new Scanner(System.in).nextLine()));
                                        System.out.println("Жумушчунун Gender - жазыныз: " + Arrays.toString(Gender.values()));
                                        employee.setGender(Gender.valueOf(new Scanner(System.in).nextLine()));
                                        System.out.println(employeeService.saveEmployee(employee));
                                        break;
                                    }
                                    case 2: {
                                        System.out.println("Жумушчунун iD- жазыныз: ");
                                        Long idEmp = new Scanner(System.in).nextLong();
                                        System.out.println("Жумушчуну кайсыл аптекага киргизесин ошону Id - жазыныз: ");
                                        Long idPar = new Scanner(System.in).nextLong();
                                        System.out.println(employeeService.assignEmployeeToPharmacy(idPar, idEmp));
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("Кайсыл аптеканын жумушчсуларын аласын: ");
                                        employeeService.getAllEmployee(new Scanner(System.in).nextLong());
                                        break;
                                    }
                                    case 4: {
                                        System.out.println("Жумушчунун ID - жазыныз: ");
                                        Long idem = new Scanner(System.in).nextLong();
                                        System.out.println("Жумушчсу иштеген аптеканы ID- жазыныз: ");
                                        Long idPar = new Scanner(System.in).nextLong();
                                        System.out.println(employeeService.getByIdEmployee(idem, idPar));
                                        break;
                                    }
                                    case 5: {
                                        Employee employee = new Employee();
                                        System.out.println("Озгорто турган Жумушчунун ID-жазыныз: ");
                                        Long idEm = new Scanner(System.in).nextLong();
                                        System.out.println("Жумушчу жайгашкан аптекаын жазыныз: ");
                                        Long idPAr = new Scanner(System.in).nextLong();
                                        System.out.println("Жумушчунун ФИО жазыныз: ");
                                        employee.setFullName(new Scanner(System.in).nextLine());
                                        System.out.println("Жумушчунун Email - жазыныз: ");
                                        employee.setEmail(new Scanner(System.in).nextLine());
                                        System.out.println("Жумушчунун phoneNumber - жазыныз: ");
                                        employee.setPhoneNumber(new Scanner(System.in).nextLine());
                                        System.out.println("Жумушчунун experience - жазыныз: ");
                                        employee.setExperience(new Scanner(System.in).nextDouble());
                                        System.out.println("Жумушчунун position - жазыныз: " + Arrays.toString(Position.values()));
                                        employee.setPosition(Position.valueOf(new Scanner(System.in).nextLine()));
                                        System.out.println("Жумушчунун Gender - жазыныз: " + Arrays.toString(Gender.values()));
                                        employee.setGender(Gender.valueOf(new Scanner(System.in).nextLine()));
                                        System.out.println(employeeService.updateEmployeeById(idPAr, idEm, employee));
                                        break;
                                    }
                                    case 6: {
                                        System.out.println("Жумушчу жайгашкан аптеканын ID-жазыныз: ");
                                        Long idPAR = new Scanner(System.in).nextLong();
                                        System.out.println("Жумушчуунун ID -  жазыныз: ");
                                        Long idEM = new Scanner(System.in).nextLong();
                                        employeeService.deleteEmployeeById(idPAR, idEM);
                                        break;
                                    }
                                    case 7: {
                                        System.out.println("Жумушчунун позисиясясын жазыныз: " + Arrays.toString(Position.values()));
                                        System.out.println(employeeService.filterEmployeeByPosition(new Scanner(System.in).nextLine()));
                                        break;
                                    }
                                    case 8: {
                                        choice2 = false;
                                    }

                                }
                            } catch (Exception e) {
                                System.out.println("Туура жазсаныз боло!!! ");
                            }
                        }
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Туура жазсаныз боло!!! ");
            }
        }
    }

}
