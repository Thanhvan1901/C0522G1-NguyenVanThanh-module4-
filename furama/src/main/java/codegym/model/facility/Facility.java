package codegym.model.facility;


import codegym.model.contract.Contract;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "facility")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String area;
    private String cost;
    private String maxPeople;

    @OneToMany(mappedBy = "facility" , cascade = CascadeType.ALL)
    private Set<Contract> contracts ;

    private int is_delete ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rent_type_id",referencedColumnName = "id")
    private RentType rentType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="facility_type_id",referencedColumnName = "id")
    private FacilityType facilityType;

    private String standardRoom;

    private String descriptionOtherConvenience;

    private String poolArea;

    private String numberOfFloors;

    @Column(columnDefinition = "")
    private String facilityFree;
//    @OneToMany(mappedBy = "facility",cascade = CascadeType.ALL)
//    private Set<Contract> contractFacility;

    public Facility() {
    }

    public Facility(int id, String name, String area, String cost, String maxPeople, Set<Contract> contracts, int is_delete, RentType rentType, FacilityType facilityType, String standardRoom, String descriptionOtherConvenience, String poolArea, String numberOfFloors, String facilityFree) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.contracts = contracts;
        this.is_delete = is_delete;
        this.rentType = rentType;
        this.facilityType = facilityType;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public int getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }
}
