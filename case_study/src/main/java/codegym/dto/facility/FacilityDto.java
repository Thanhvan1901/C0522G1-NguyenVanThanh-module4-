package codegym.dto.facility;

import  codegym.common.facility.FacilityValidate;
import  codegym.model.facility.FacilityType;
import  codegym.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FacilityDto implements Validator {

    private String name;

    private String area;

    private String cost;

    private String maxPeople;

    private String standard;

    private String otherConvenience;

    private String poolArea;

    private String floors;

    private String facilityFree;

    private RentType rentType;

    private FacilityType facilityType;

    public FacilityDto() {
    }

    public FacilityDto(String name, String area, String cost, String maxPeople, String standard, String otherConvenience, String poolArea, String floors, String facilityFree, RentType rentType, FacilityType facilityType) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standard = standard;
        this.otherConvenience = otherConvenience;
        this.poolArea = poolArea;
        this.floors = floors;
        this.facilityFree = facilityFree;
        this.rentType = rentType;
        this.facilityType = facilityType;
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

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getOtherConvenience() {
        return otherConvenience;
    }

    public void setOtherConvenience(String otherConvenience) {
        this.otherConvenience = otherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}
