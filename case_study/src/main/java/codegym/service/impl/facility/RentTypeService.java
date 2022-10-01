package codegym.service.impl.facility;

import  codegym.model.facility.RentType;
import  codegym.repository.facility.IRentTypeRepository;
import  codegym.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {

    @Autowired
    private IRentTypeRepository iRentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return this.iRentTypeRepository.findAll();
    }
}
