package codegym.service;

import codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {

    Page<Facility> findAllByNameContaining(String name , Pageable pageable);

    void deleteById(int id);

    void save(Facility facility);
}
