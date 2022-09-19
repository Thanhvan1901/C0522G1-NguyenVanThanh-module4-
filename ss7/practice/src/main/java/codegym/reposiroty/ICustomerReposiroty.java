package codegym.reposiroty;

import codegym.model.Customer;
import codegym.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerReposiroty extends PagingAndSortingRepository<Customer , Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
