package abc.service.impl;

import abc.model.Customer;
import abc.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
@Service
public class SimpleCustomerServiceImpl implements CustomerService {
    private static List<Customer> customers ;
    private static long autoIncreaseId = 0 ;
    static {
        customers = asList (
                new Customer(autoIncreaseId++,"Nguyễn Văn Thanh","nvt@gmai.com","Đà nẵng "),
                new Customer(autoIncreaseId++,"Võ Như Vinh","vinh@gmai.com","Quảng Nam "),
                new Customer(autoIncreaseId++,"Nguyễn Hữu Thức","thuc@gmai.com","Nghệ An"),
                new Customer(autoIncreaseId++,"Nguyễn Văn Tuấn","tuan@gmai.com","Huế")
        );
    }
    @Override
    public List<Customer> findAll() {

        return new ArrayList<>(customers);
    }

    @Override
    public Customer findOne(Long id) {
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return null ;
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        return null ;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public void delete(List<Customer> customers) {

    }

    @Override
    public void deleteAll() {

    }
}
