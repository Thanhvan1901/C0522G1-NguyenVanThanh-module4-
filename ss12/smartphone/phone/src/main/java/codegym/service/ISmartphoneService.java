package codegym.service;

import codegym.model.Phone;

import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Phone> findAll();

    Optional<Phone> findById(Long id);

    Phone save(Phone smartPhone);

    void remove(Long id);
}
