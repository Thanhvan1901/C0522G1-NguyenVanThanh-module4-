package codegym.service.impl;


import codegym.model.MedicalDeclaration;
import codegym.repository.IMedicalDeclarationRepository;
import codegym.service.IMedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalDeclarationService implements IMedicalDeclarationService {
    @Autowired
    private IMedicalDeclarationRepository medicalDeclarationRepository;

    @Override
    public List<String> getDays() {
        return this.medicalDeclarationRepository.getDays();
    }

    @Override
    public List<String> getMonths() {
        return this.medicalDeclarationRepository.getMonths();
    }

    @Override
    public List<String> getYears() {
        return this.medicalDeclarationRepository.getYears();
    }

    @Override
    public List<String> getGender() {
        return this.medicalDeclarationRepository.getGender();
    }

    @Override
    public List<String> getNationalities() {
        return this.medicalDeclarationRepository.getNationalities();
    }

    @Override
    public List<String> getTransports() {
        return this.medicalDeclarationRepository.getTransports();
    }

    @Override
    public void add(MedicalDeclaration medicalDeclaration) {
        this.medicalDeclarationRepository.add(medicalDeclaration);
    }

    @Override
    public List<MedicalDeclaration> listOfMedicalDeclaration() {
        return this.medicalDeclarationRepository.listOfMedicalDeclaration();
    }

    @Override
    public void update(int id, MedicalDeclaration medicalDeclaration) {
        this.medicalDeclarationRepository.update(id, medicalDeclaration);
    }

    @Override
    public MedicalDeclaration findById(int id) {
        return this.medicalDeclarationRepository.findById(id);
    }
}
