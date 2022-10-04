package codegym.model.contract;


import javax.persistence.*;

@Entity
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "quantity")
    private int quantity ;

    @ManyToOne
    @JoinColumn(name = "contract_id" , referencedColumnName = "id")
    private Contract contracts ;

    @ManyToOne
    @JoinColumn(name = "attach_facility_id" , referencedColumnName = "id")
    private AttachFacility attachFacility ;

    public ContractDetail() {
    }

    public ContractDetail(int id, int quantity, Contract contracts, AttachFacility attachFacility) {
        this.id = id;
        this.quantity = quantity;
        this.contracts = contracts;
        this.attachFacility = attachFacility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contract getContracts() {
        return contracts;
    }

    public void setContracts(Contract contracts) {
        this.contracts = contracts;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
