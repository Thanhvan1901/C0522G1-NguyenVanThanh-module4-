package codegym.dto.customer;

import codegym.model.customer.CustomerType;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class CustomerDto implements Validator {

    private int id ;

    @NotBlank(message = "Không Được Để Trống")
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Phải viết hoa chữ cái của mỗi từ!")
    private String name;

    @NotBlank(message = "Không Được Để Trống")
    private String dateOfBirth;

    @NotBlank(message = "Không Được Để Trống")
    private String gender;

    @NotBlank(message = "Không Được Để Trống")
    @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$",
    message = "Vui Lòng Nhập Lại")
    private String idCard;

    @NotBlank(message = "Không Được Để Trống")
    @Pattern(regexp = "^(090|091|\\\\(84\\\\)\\\\+90|\\\\(84\\\\)\\\\+91)[0-9]{7}$",
            message = "Vui Lòng Nhập Lại")
    private String phoneNumber;

    @NotBlank(message = "Không Được Để Trống")
    @Email
    private String email;

    @NotBlank(message = "Không Được Để Trống")
    private String address;

    @NotNull(message = "Không Được Để Trống")
    private CustomerType customerType;

    public CustomerDto() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}
