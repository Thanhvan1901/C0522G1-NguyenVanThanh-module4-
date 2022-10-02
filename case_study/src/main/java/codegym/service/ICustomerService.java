package codegym.service;

import codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {

    Page<Customer> findAllByNameContaining(String nameCustomer, Pageable pageable);

    Page<Customer> findAllByContracts_EndDateBefore(String now ,Pageable pageable);

    void save(Customer customer);

    Customer findById(int id);

    void deleteById(int id);
}
