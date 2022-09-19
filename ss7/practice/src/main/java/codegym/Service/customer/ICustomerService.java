package codegym.Service.customer;

import codegym.Service.IGeneralService;
import codegym.model.Customer;
import codegym.model.Province;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
