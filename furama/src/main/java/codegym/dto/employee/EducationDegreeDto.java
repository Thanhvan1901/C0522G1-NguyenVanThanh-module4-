package codegym.dto.employee;

import java.util.List;

public class EducationDegreeDto {

    private int id;

    private String Name;

    private List<EmployeeDto> employees;

    public EducationDegreeDto() {
    }

    public EducationDegreeDto(int id, String name, List<EmployeeDto> employees) {
        this.id = id;
        Name = name;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }
}
