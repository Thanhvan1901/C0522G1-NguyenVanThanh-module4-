package codegym.controller;

import codegym.dto.customer.CustomerDto;
import codegym.model.customer.Customer;
import codegym.model.customer.CustomerType;
import codegym.service.ICustomerService;
import codegym.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;


    @GetMapping("/")
    public String goCustomerList(@PageableDefault(size = 3) Pageable pageable,
                                 @RequestParam Optional<String> keySearch,
                                 Model model) {

        String keyVal = keySearch.orElse("");

        model.addAttribute("customers",
                this.iCustomerService.findAllByNameContaining(keyVal, pageable));

        model.addAttribute("keySearch", keyVal);

        return "customer/customer-list";
    }

    @GetMapping("/create")
    public String goCreateForm(Model model) {

        model.addAttribute("customerDto", new CustomerDto());

        model.addAttribute("customerTypeList",
                this.iCustomerTypeService.findAll());

        return "customer/customer-create";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute CustomerDto customerDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Model model) {

        new CustomerDto().validate(customerDto, bindingResult);

        if (bindingResult.hasErrors()){
            model.addAttribute("customerTypeList",
                    this.iCustomerTypeService.findAll());
            return "customer/customer-create";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        CustomerType customerType = new CustomerType();
        customerType.setId(customerDto.getCustomerType().getId());
        customer.setCustomerType(customerType);

        this.iCustomerService.save(customer);

        redirectAttributes.addFlashAttribute("message",
                "successfully added new");

        return "redirect:/customer/";
    }

    @GetMapping("/edit")
    public String goEditForm(@RequestParam int id,
                             Model model) {

        model.addAttribute("customer",
                this.iCustomerService.findById(id));

        model.addAttribute("customerTypeList",
                this.iCustomerTypeService.findAll());

        return "customer/customer-edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute Customer customer,
                                 RedirectAttributes redirectAttributes) {

        this.iCustomerService.save(customer);

        redirectAttributes.addFlashAttribute("message",
                "successfully update");

        return "redirect:/customer/";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam int customerId) {

        this.iCustomerService.deleteById(customerId);

        return "redirect:/customer/";
    }
}
