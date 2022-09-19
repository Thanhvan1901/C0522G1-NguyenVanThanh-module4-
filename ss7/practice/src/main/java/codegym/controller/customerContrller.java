package codegym.controller;

import codegym.Service.customer.ICustomerService;
import codegym.Service.province.IProvinceService;
import codegym.model.Customer;
import codegym.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class customerContrller {

    @Autowired
    private ICustomerService iCustomerService ;

    @Autowired
    private IProvinceService iProvinceService ;

    @GetMapping("")
    public String showCustomerList(Model model){
        model.addAttribute("customerList" , iCustomerService.findAll());
        model.addAttribute("provinceList",iProvinceService.findAll());
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer" ,new Customer());
        model.addAttribute("proviceList",iProvinceService.findAll());
        return "/create" ;
    }

    @PostMapping("/save")
    public String save(Customer customer , RedirectAttributes redirect){
        this.iCustomerService.save(customer);
        redirect.addFlashAttribute("msg" ,"Create New ok ");
        return "redirect:/" ;
    }

}
