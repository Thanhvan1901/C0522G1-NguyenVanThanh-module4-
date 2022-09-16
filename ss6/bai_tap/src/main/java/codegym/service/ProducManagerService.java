package codegym.service;

import codegym.model.Product;
import codegym.repository.IProductManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProducManagerService implements IProducManagerService {

    @Autowired
    private IProductManagerRepository iProductManagerRepository;

    @Override
    public List<Product> findAll() {
        return iProductManagerRepository.findAll();
    }

    @Override
    public void save(Product produc) {
        iProductManagerRepository.save(produc);
    }

    @Override
    public Product findById(int id) {
        return iProductManagerRepository.findById(id).get();
    }

    @Override
    public void update(Product produc) {
        iProductManagerRepository.save(produc);
    }

    @Override
    public void remove(int id) {
        iProductManagerRepository.delete(findById(id));
    }

    @Override
    public List<Product> search(String name) {
        return iProductManagerRepository.findByName(name);
    }
    
}
