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
            for (Pharmacy pharmacy : DataBase.pharmacies){
                if (pharmacy.getId() == pharmacyId){
                    pharmacy.getMedicines().add(medicine);
                    DataBase.medicines.add(medicine);
                    return "Кошулду";
                }
            }
            return "Аптека id " + pharmacyId + " Табылган жок";
    }

    @Override
    public List<Medicine> getAllMedicineByPharmacyId(Long pharmacyId) {
        for (Pharmacy pharmacy : DataBase.pharmacies){
            if (pharmacy.getId()==pharmacyId){
               return pharmacy.getMedicines();
            }
        }
        System.out.println("Аптека id " + pharmacyId + " табылган жок: ");
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
                System.out.println("даары id " + medicineId + " табылган жок: ");
                break;
            }
        }
        System.out.println("Аптека id " + pharmacyId + " табылган жок: ");

        return null;
    }

    // Ошибка чыгат барып голикасын сурап текшертип ал
    @Override
    public String updateMedicineById(Long pharmacyId, Long medicineId, Medicine newMedicine) {
        for (Pharmacy pharmacy : DataBase.pharmacies){
            if (pharmacy.getId() == pharmacyId){
                for (Medicine medicine: pharmacy.getMedicines()){
                    if (medicine.getId() == medicineId){
                        medicine.setName(newMedicine.getName());
                        medicine.setPrice(newMedicine.getPrice());
                        medicine.setDescription(newMedicine.getDescription());
                        medicine.setDateOfDelivery(newMedicine.getDateOfDelivery());
                        medicine.setExpirationDate(newMedicine.getExpirationDate());
                        return "Ийгиликтуу озгорду";
                    }
                }
            }
        }
        return "Табылган жок!!!";
    }

    @Override
    public String deleteMedicineById(Long pharmacyId, Long medicineId) {
        for (Pharmacy pharmacy : DataBase.pharmacies){
            if (pharmacy.getId()==pharmacyId){
                for (Medicine medicine: pharmacy.getMedicines()){
                    if (medicine.getId() == medicineId){
                        pharmacy.getMedicines().remove(medicine);
                        return "Ийгиликтуу очтуу";
                    }
                }
            }
        }
        return "Не найдено " + medicineId;
    }

    @Override
    public List<Medicine> sortByPrice(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("asc")){
            DataBase.medicines.sort(Comparator.comparingInt(Medicine::getPrice));
            return DataBase.medicines;
        }else if (ascOrDesc.equalsIgnoreCase("desc")){
            Comparator<Medicine>medicineComparator = Comparator.comparingInt(Medicine::getPrice).reversed();
            DataBase.medicines.sort(medicineComparator);
            return DataBase.medicines;
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
            return DataBase.medicines;
        }
        return null;
    }

    @Override
    public List<Medicine> sortByExpirationDate(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("asc")){
            DataBase.medicines.sort(Comparator.comparing(Medicine::getExpirationDate));
            return DataBase.medicines;
        }else if (ascOrDesc.equalsIgnoreCase("desc")){
            Comparator<Medicine>medicineComparator = Comparator.comparing(Medicine::getExpirationDate).reversed();
            DataBase.medicines.sort(medicineComparator);
            return DataBase.medicines;
        }
        return null;
    }
}
