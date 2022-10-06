package codegym.dto.employee;


import codegym.model.employee.Division;
import codegym.model.employee.EducationDegree;
import codegym.model.employee.Position;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class EmployeeDto implements Validator {


    @NotBlank(message = "Không Được Để Trống")
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Phải viết hoa chữ cái của mỗi từ!")
    private String name;

    @Min(18)
    private String dateOfBirth;

    @NotBlank(message = "Không Được Để Trống")
    @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$",
            message = "Vui Lòng Nhập Lại")
    private String idCard;

    @NotNull(message = "Không Được Để Trống")
    private String salary;

    @NotBlank(message = "Không Được Để Trống")
    @Pattern(regexp = "^(090|091|\\\\(84\\\\)\\\\+90|\\\\(84\\\\)\\\\+91)[0-9]{7}$",
            message = "Vui Lòng Nhập Lại")
    private String phoneNumber;

    @Email
    private String email;

    @NotBlank(message = "Không Được Để Trống")
    private String address;

    @NotNull(message = "Không Được Để Trống")
    private Position position;

    @NotNull(message = "Không Được Để Trống")
    private EducationDegree educationDegree;

    @NotNull(message = "Không Được Để Trống")
    private Division division;

    public EmployeeDto() {
    }

    public EmployeeDto(String name, String dateOfBirth, String idCard, String salary, String phoneNumber, String email, String address, Position position, EducationDegree educationDegree, Division division) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}
