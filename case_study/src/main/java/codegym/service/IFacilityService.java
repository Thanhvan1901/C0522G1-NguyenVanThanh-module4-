package codegym.service;

import codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {

    Page<Facility> findAllByNameContaining(String nameFacility, Pageable pageable);

    List<Facility> showFacilityList();

    void save(Facility facility);

    Facility findById(int id);

    void deleteById(int id);

}
