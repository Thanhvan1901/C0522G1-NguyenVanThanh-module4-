package codegym.controller;

import codegym.model.MedicalDeclaration;
import codegym.service.IMedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalDeclarationController {

    @Autowired
    private IMedicalDeclarationService medicalDeclaration;

    @GetMapping("/")
    public String goMedicalDeclarationList(Model model) {
        model.addAttribute("list", medicalDeclaration.listOfMedicalDeclaration());
        return "list";
    }

    @GetMapping("/add")
    public String goMedicalDeclarationAddPage(Model model) {
        model.addAttribute("years", this.medicalDeclaration.getYears());
        model.addAttribute("months", this.medicalDeclaration.getMonths());
        model.addAttribute("days", this.medicalDeclaration.getDays());
        model.addAttribute("genders", this.medicalDeclaration.getGender());
        model.addAttribute("nationalities", this.medicalDeclaration.getNationalities());
        model.addAttribute("transports", this.medicalDeclaration.getTransports());
        model.addAttribute("medicalDeclaration", new MedicalDeclaration());
        return "add";
    }

    @PostMapping("/save")
    public String SaveMedicalDeclaration(@ModelAttribute MedicalDeclaration medicalDeclaration) {
        this.medicalDeclaration.add(medicalDeclaration);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String goMedicalDeclarationUpdatePage(@PathVariable int id, Model model) {
        model.addAttribute("medicalDeclaration", this.medicalDeclaration.findById(id));
        model.addAttribute("years", this.medicalDeclaration.getYears());
        model.addAttribute("months", this.medicalDeclaration.getMonths());
        model.addAttribute("days", this.medicalDeclaration.getDays());
        model.addAttribute("genders", this.medicalDeclaration.getGender());
        model.addAttribute("nationalities", this.medicalDeclaration.getNationalities());
        model.addAttribute("transports", this.medicalDeclaration.getTransports());
        return "update";
    }

    @PostMapping("/save_update/{id}")
    public String saveUpdateMedicalDeclaration(@ModelAttribute MedicalDeclaration medicalDeclaration,
                                               @PathVariable int id) {
        this.medicalDeclaration.update(id, medicalDeclaration);
        return "redirect:/";
    }
}
