package codegym.service.impl.employee;

import  codegym.model.employee.EducationDegree;
import  codegym.repository.employee.IEducationDegreeRepository;
import  codegym.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {

    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return this.iEducationDegreeRepository.findAll();
    }
}
