package codegym.dto.customer;

import java.util.List;

public class CustomerTypeDto {

    private int id;

    private String name;

    private List<CustomerDto> customerDtos;

    public CustomerTypeDto() {
    }

    public CustomerTypeDto(int id, String name, List<CustomerDto> customerDtos) {
        this.id = id;
        this.name = name;
        this.customerDtos = customerDtos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CustomerDto> getCustomerDtos() {
        return customerDtos;
    }

    public void setCustomerDtos(List<CustomerDto> customerDtos) {
        this.customerDtos = customerDtos;
    }
}
