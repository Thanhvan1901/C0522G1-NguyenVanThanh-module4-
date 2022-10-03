package codegym.model.contract;

import javax.persistence.*;
import java.util.List;

@Entity
public class AttachFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "name")
    private String name ;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "unit")
    private String unit ;

    @Column(name = "status")
    private String  status ;

    @OneToMany(mappedBy = "attachFacility")
    private List<ContractDetail> contractDetails ;

    public AttachFacility() {
    }

    public AttachFacility(int id, String name, Double cost, String unit, String status, List<ContractDetail> contractDetails) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.contractDetails = contractDetails;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
