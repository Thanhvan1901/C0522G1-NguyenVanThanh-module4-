package codegym.dto.FacilityDto;

import java.util.List;

public class FacilityTypeDto {

    private int id;

    private String name;

    private List<FacilityDto> facilities;

    public FacilityTypeDto() {
    }

    public FacilityTypeDto(int id, String name, List<FacilityDto> facilities) {
        this.id = id;
        this.name = name;
        this.facilities = facilities;
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

    public List<FacilityDto> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<FacilityDto> facilities) {
        this.facilities = facilities;
    }
}
