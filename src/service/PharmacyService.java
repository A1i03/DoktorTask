package service;

import model.Pharmacy;

import java.util.List;

public interface PharmacyService {
    String savePharmacy(Pharmacy pharmacy);

    List<Pharmacy> getAllPharmacy();

    Pharmacy getByIdPharmacy(Long pharmacyId);

    String updatePharmacyById(Long pharmacyId, Pharmacy newPharmacy);

    String deletePharmacyById(Long pharmacyId);

}