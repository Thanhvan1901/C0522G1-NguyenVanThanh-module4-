package codegym.controller;

import codegym.dto.employee.EmployeeDto;
import codegym.model.employee.Division;
import codegym.model.employee.EducationDegree;
import codegym.model.employee.Employee;
import codegym.model.employee.Position;
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
                         @RequestParam Optional<String> keySearch,
                         Model model){
        String keyVal = keySearch.orElse("");

        model.addAttribute("employeeAdd", new EmployeeDto());

        model.addAttribute("employees",
                this.iEmployeeService.findAllByNameContaining(keyVal, pageable));

        model.addAttribute("educationDegrees",
                this.iEducationDegreeService.findAll());

        model.addAttribute("positions",
                this.iPositionService.findAll());

        model.addAttribute("divisions",
                this.iDivisionService.findAll());

        model.addAttribute("keySearch", keyVal);

        return "employee/employee-list";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute EmployeeDto employeeDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Model model){

        new EmployeeDto().validate(employeeDto, bindingResult);

        if (bindingResult.hasErrors()){
            model.addAttribute("educationDegrees",
                    this.iEducationDegreeService.findAll());

            model.addAttribute("positions",
                    this.iPositionService.findAll());

            model.addAttribute("divisions",
                    this.iDivisionService.findAll());
            return "employee/employee-list";
        }

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);

        EducationDegree educationDegree = new EducationDegree();
        educationDegree.setId(employeeDto.getEducationDegree().getId());
        employee.setEducationDegree(educationDegree);

        Position position = new Position();
        position.setId(employeeDto.getPosition().getId());
        employee.setPosition(position);

        Division division = new Division();
        division.setId(employeeDto.getDivision().getId());
        employee.setDivision(division);

        this.iEmployeeService.save(employee);

        redirectAttributes.addFlashAttribute("message",
                "successfully added new");

        return "redirect:/employee/";
    }
}
