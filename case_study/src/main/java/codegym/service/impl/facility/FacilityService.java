package codegym.service.impl.facility;

import  codegym.model.facility.Facility;
import  codegym.repository.facility.IFacilityRepository;
import  codegym.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Page<Facility> findAllByNameContaining(String nameFacility, Pageable pageable) {
        return this.iFacilityRepository.findAllByNameContaining(nameFacility, pageable);
    }

    @Override
    public List<Facility> showFacilityList() {
        return this.iFacilityRepository.findAll();
    }

    @Override
    public void save(Facility facility) {
        this.iFacilityRepository.save(facility);
    }

    @Override
    public Facility findById(int id) {
        return this.iFacilityRepository.getById(id);
    }

    @Override
    public void deleteById(int id) {
        this.iFacilityRepository.deleteById(id);
    }

}
