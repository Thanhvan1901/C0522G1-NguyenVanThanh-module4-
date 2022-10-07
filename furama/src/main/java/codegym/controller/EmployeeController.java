package codegym.controller;


import codegym.dto.employee.EmployeeDto;
import codegym.model.employee.Employee;
import codegym.service.IDivisionService;
import codegym.service.IEducationDegreeService;
import codegym.service.IEmployeeService;
import codegym.service.IPositionService;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IEducationDegreeService iEducationDegreeService;

    @Autowired
    private IPositionService iPositionService;

    @Autowired
    private IDivisionService iDivisionService;

    @GetMapping("/")
    public String goHome(@PageableDefault(size = 3)Pageable pageable,
                         @RequestParam (value = "name" , defaultValue = "") String name,
                         Model model){

        model.addAttribute("employees",
                this.iEmployeeService.findAllByNameContaining(name, pageable));

        model.addAttribute("educationDegrees",
                this.iEducationDegreeService.findAll());

        model.addAttribute("positions",
                this.iPositionService.findAll());

        model.addAttribute("divisions",
                this.iDivisionService.findAll());

        model.addAttribute("name", name);

        model.addAttribute("employeeDto", new EmployeeDto());

        return "employee/employee-list";
    }

//    @GetMapping("/create")
//    public String goCreateForm(Model model) {
//
//        model.addAttribute("employeeDto", new EmployeeDto());
//
//        model.addAttribute("division",
//                this.iDivisionService.findAll());
//        model.addAttribute("educationDegrees",
//                this.iEducationDegreeService.findAll());
//        model.addAttribute("position",
//                this.iPositionService.findAll());
//
//        return "/employee/employee-list";
//    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute EmployeeDto employeeDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Model model){
        new EmployeeDto().validate(employeeDto , bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("educationDegrees",
                    this.iEducationDegreeService.findAll());

            model.addAttribute("positions",
                    this.iPositionService.findAll());

            model.addAttribute("divisions",
                    this.iDivisionService.findAll());
            return "employee/employee-edit";
        }else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);

            this.iEmployeeService.save(employee);

            redirectAttributes.addFlashAttribute("message",
                    "successfully added new");

            return "redirect:/employee/";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,@RequestParam(value = "name",defaultValue = "") String name,
                       @PageableDefault(value = 3)Pageable pageable, Model model){
        model.addAttribute("employees",iEmployeeService.findByName(name,phone,idCard,pageable));
        model.addAttribute("name",name);
        model.addAttribute("phone",phone);
        model.addAttribute("idCard",idCard);
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("createEmployeeDto",new EmployeeDto());
        model.addAttribute("educationDegrees", iEducationDegreeService.findAll());
        model.addAttribute("positions", iPositionService.findAll());
        model.addAttribute("divisions",iDivisionService.findAll());
        model.addAttribute("action","openUpdate");
        Employee employee = iEmployeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);

        Division division = employee.getDivision();
        employeeDto.setDivision(division);

        Position position = employee.getPosition();
        employeeDto.setPosition(position);

        EducationDegree educationDegree = employee.getEducationDegree();
        employeeDto.setEducationDegree(educationDegree);


        model.addAttribute("updateEmployeeDto",employeeDto);
        return "redirect:/employee/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute EmployeeDto employeeDto, RedirectAttributes redirectAttributes) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);


        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("messUpdate", "Update Success!");
        return "redirect:/employee";
    }



    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam(value = "deleteId")int id){
        this.iEmployeeService.deleteById(id);
        return "redirect:/employee/";
    }
}
