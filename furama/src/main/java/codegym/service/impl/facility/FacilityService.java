package codegym.service.impl.facility;

import codegym.model.facility.Facility;
import codegym.repository.facility.IFacilityRepository;
import codegym.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository iFacilityRepository ;
    @Override
    public Page<Facility> findAllByNameContaining(String name, Pageable pageable) {
        return iFacilityRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public void deleteById(int id) {
        iFacilityRepository.deleteById(id);
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }
}
