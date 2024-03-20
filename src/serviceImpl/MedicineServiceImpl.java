package serviceImpl;

import database.DataBase;
import model.Employee;
import model.Medicine;
import model.Pharmacy;
import service.MedicineService;

import java.util.Comparator;
import java.util.List;

public class MedicineServiceImpl implements MedicineService {
    @Override
    public String addMedicineToPharmacy(Long pharmacyId, Medicine medicine) {
        Pharmacy pharmacyToAddMedicine = null;
        for (Pharmacy pharmacy1 : DataBase.pharmacies){
            if (!pharmacy1.getId().equals(pharmacyId)){
                pharmacyToAddMedicine =pharmacy1;
                break;
            }
        }
        if (pharmacyToAddMedicine == null){
            return "Pharmacy with ID " + pharmacyId + " not found.";
        }
        pharmacyToAddMedicine.setMedicines((List<Medicine>) medicine);

        return "Успешно" + pharmacyId + "Нет ID";
    }

    @Override
    public Medicine getAllMedicineByPharmacyId(Long pharmacyId) {
        for (Pharmacy medicine : DataBase.pharmacies){
            if (medicine.getId()==pharmacyId){
                return medicine.getMedicines();
            }else {
                System.out.println("Мындай Id жок ");
            }
        }
        return null;
    }

    @Override
    public Medicine getByIdMedicine(Long pharmacyId, Long medicineId) {
        for (Pharmacy pharmacy : DataBase.pharmacies){
            if (pharmacy.getId() == pharmacyId){
                for (Medicine medicine : pharmacy.getMedicines()){
                    if (medicine.getId() == medicineId){
                        return medicine;
                    }
                }
            }
        }
        return null;
    }

    // Ошибка чыгат барып голикасын сурап текшертип ал
    @Override
    public String updateMedicineById(Long pharmacyId, Long medicineId, Medicine newMedicine) {
        if (pharmacyId == null || medicineId == null) {
            return "ID.";
        }
        Medicine existingMedicine = getAllMedicineByPharmacyId(medicineId);
        if (existingMedicine == null) {
            return "";
        }

        if (!existingMedicine.getId().equals(pharmacyId)) {
            return "";
        }
        existingMedicine.setName(newMedicine.getName());
        existingMedicine.setDescription(newMedicine.getDescription());
        existingMedicine.setPrice(newMedicine.getPrice());

        getAllMedicineByPharmacyId(existingMedicine.getId());

        return "";
    }

    @Override
    public String deleteMedicineById(Long pharmacyId, Long medicineId) {
        for (Pharmacy pharmacy : DataBase.pharmacies){
            if (pharmacy.getId()==pharmacyId){
                for (Employee employee : DataBase.employees){
                    if (employee.getId() == medicineId){
                        DataBase.employees.remove(employee);
                        return "Удалить успешно " + medicineId;
                    }
                }
            }
        }
        return "Не найдено " + medicineId;
    }

    @Override
    public List<Medicine> sortByPrice(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("999")){
            DataBase.medicines.sort(Comparator.comparingInt(Medicine::getPrice));
            return DataBase.medicines;
        }else if (ascOrDesc.equalsIgnoreCase("1111")){
            Comparator<Medicine>medicineComparator = Comparator.comparingInt(Medicine::getPrice).reversed();
            DataBase.medicines.sort(medicineComparator);
        }
        return null;
    }

    @Override
    public List<Medicine> sortByDeliveryDate(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("asc")){
            DataBase.medicines.sort(Comparator.comparing(Medicine::getDateOfDelivery));
            return DataBase.medicines;
        }else if (ascOrDesc.equalsIgnoreCase("desc")){
            Comparator<Medicine>medicineComparator = Comparator.comparing(Medicine::getDateOfDelivery).reversed();
            DataBase.medicines.sort(medicineComparator);
        }
        return null;
    }

    @Override
    public List<Medicine> sortByExpirationDate(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("999")){
            DataBase.medicines.sort(Comparator.comparing(Medicine::getExpirationDate));
            return DataBase.medicines;
        }else if (ascOrDesc.equalsIgnoreCase("1111")){
            Comparator<Medicine>medicineComparator = Comparator.comparing(Medicine::getExpirationDate).reversed();
            DataBase.medicines.sort(medicineComparator);
        }
        return null;
    }
}
