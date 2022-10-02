package codegym.service.impl;

import codegym.model.Phone;
import codegym.repository.ISmartphoneRepository;
import codegym.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartphoneService implements ISmartphoneService {
    @Autowired
    private ISmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<Phone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Optional<Phone> findById(Long id) {
        return smartphoneRepository.findById(id);
    }

    @Override
    public Phone save(Phone phone) {
        return smartphoneRepository.save(phone);
    }

    @Override
    public void remove(Long id) {
        smartphoneRepository.deleteById(id);
    }
}
