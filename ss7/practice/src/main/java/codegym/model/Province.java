package codegym.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Province")
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String provice_name ;

    @OneToMany(mappedBy = "province")
    private Set<Customer> customers ;

    public Province() {
    }

    public Province(String provice_name) {
        this.provice_name = provice_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvice_name() {
        return provice_name;
    }

    public void setProvice_name(String provice_name) {
        this.provice_name = provice_name;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
