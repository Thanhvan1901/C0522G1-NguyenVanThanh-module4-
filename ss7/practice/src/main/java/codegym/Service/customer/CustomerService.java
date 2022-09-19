package codegym.Service.customer;

import codegym.Service.province.IProvinceService;
import codegym.model.Customer;
import codegym.model.Province;
import codegym.reposiroty.ICustomerReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private  ICustomerReposiroty iCustomerReposiroty ;

    @Override
    public Iterable<Customer> findAll() {
        return iCustomerReposiroty.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return iCustomerReposiroty.findById(id);
    }

    @Override
    public void save(Customer customer) {
        iCustomerReposiroty.save(customer);
    }

    @Override
    public void remove(Long id) {
        iCustomerReposiroty.deleteById(id);
    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return iCustomerReposiroty.findAllByProvince(province);
    }
}
