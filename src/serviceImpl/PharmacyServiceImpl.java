package serviceImpl;

import database.DataBase;
import model.Pharmacy;
import service.PharmacyService;

import java.util.ArrayList;
import java.util.List;

public class PharmacyServiceImpl implements PharmacyService {
    @Override
    public String savePharmacy(Pharmacy pharmacy) {
        DataBase.pharmacies.add(pharmacy);
        return "Успешна: ";
    }

    @Override
    public List<Pharmacy> getAllPharmacy() {
        return DataBase.pharmacies;
    }

    @Override
    public Pharmacy getByIdPharmacy(Long pharmacyId) {
        for (Pharmacy pharmacy : DataBase.pharmacies){
            if (pharmacy.getId().equals(pharmacyId)){
                return pharmacy;
            }
        }
        return null;
    }

    @Override
    public String updatePharmacyById(Long pharmacyId, Pharmacy newPharmacy) {
        for (Pharmacy pharmacy1 : DataBase.pharmacies){
            if (pharmacy1.getId() == pharmacyId){
                pharmacy1.setName(newPharmacy.getName());
                pharmacy1.setAddress(newPharmacy.getAddress());
                return  "Успешно обновлен." ;

            }
        }
        return "Аптека табылган жок: ";
    }

    @Override
    public String deletePharmacyById(Long pharmacyId) {
        for (Pharmacy pharmacy : DataBase.pharmacies){
            if (pharmacy.getId() == pharmacyId){
                DataBase.pharmacies.remove(pharmacy);
                return "Pharmacy c Id " + pharmacyId + " удалить ";
            }
        }
        return "Pharmacy c Id " + pharmacyId + " Не найдена";
    }

}
