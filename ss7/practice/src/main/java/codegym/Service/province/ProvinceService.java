package codegym.Service.province;

import codegym.model.Province;
import codegym.reposiroty.IProvinceReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceService implements IProvinceService {

    @Autowired
    private IProvinceReposiroty iProvinceReposiroty ;


    @Override
    public Iterable<Province> findAll() {
        return iProvinceReposiroty.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        return iProvinceReposiroty.findById(id);
    }

    @Override
    public void save(Province province) {
        iProvinceReposiroty.save(province) ;
    }

    @Override
    public void remove(Long id) {
        iProvinceReposiroty.deleteById(id);
    }
}
