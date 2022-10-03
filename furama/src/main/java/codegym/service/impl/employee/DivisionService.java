package codegym.service.impl.employee;

import  codegym.model.employee.Division;
import  codegym.repository.employee.IDivisionRepository;
import codegym.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {

    @Autowired
    private IDivisionRepository iDivisionRepository;

    @Override
    public List<Division> findAll() {
        return this.iDivisionRepository.findAll();
    }
}
