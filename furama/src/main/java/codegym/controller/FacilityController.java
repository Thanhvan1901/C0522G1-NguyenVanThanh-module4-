package codegym.controller;


import codegym.dto.FacilityDto.FacilityDto;
import codegym.model.facility.Facility;
import codegym.service.IFacilityService;
import codegym.service.IFacilityTypeService;
import codegym.service.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IRentTypeService iRentTypeService;

    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @GetMapping(value = {"/home",""})
    public String goFacilityList(@PageableDefault(value = 3)Pageable pageable,
                                 @RequestParam (value = "name" , defaultValue = "") String name,
                                 Model model){

        model.addAttribute("facilityList",
                this.iFacilityService.findAllByNameContaining(name, pageable));

        model.addAttribute("name", name);

        return "facility/facility-list";
    }

    @GetMapping("/create")
    public String goCreateForm(Model model){

        model.addAttribute("facilityDto", new FacilityDto());

        model.addAttribute("facilityTypeList",
                this.iFacilityTypeService.findAll());

        model.addAttribute("rentTypeList",
                this.iRentTypeService.findAll());

        return "facility/facility-create";
    }

    @PostMapping("/save")
    public String saveFacility(@ModelAttribute @Valid FacilityDto facilityDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        //  villa
        if(facilityDto.getFacilityType().getId() == 1){
            new FacilityDto().validate(facilityDto, bindingResult);
            if (bindingResult.hasFieldErrors()){
                model.addAttribute("facilityTypeList",
                        this.iFacilityTypeService.findAll());

                model.addAttribute("rentTypeList",
                        this.iRentTypeService.findAll());

                return "facility/facility-create";
            }
//            House
        } else if(facilityDto.getFacilityType().getId()== 2){
            if (bindingResult.hasFieldErrors("facilityType")
                    ||bindingResult.hasFieldErrors("name")
                    || bindingResult.hasFieldErrors("area")
                    || bindingResult.hasFieldErrors("cost")
                    || bindingResult.hasFieldErrors("maxPeople")
                    || bindingResult.hasFieldErrors("rentType")){
                model.addAttribute("facilityTypeList",
                        this.iFacilityTypeService.findAll());

                model.addAttribute("rentTypeList",
                        this.iRentTypeService.findAll());

                return "facility/facility-create";
            }
        } else if(facilityDto.getFacilityType().getId()== 3){
            new FacilityDto().validate(facilityDto, bindingResult);
            if (bindingResult.hasFieldErrors("facilityType")
                    ||bindingResult.hasFieldErrors("name")
                    || bindingResult.hasFieldErrors("area")
                    || bindingResult.hasFieldErrors("cost")
                    || bindingResult.hasFieldErrors("maxPeople")
                    || bindingResult.hasFieldErrors("descriptionOtherConvenience")
                    || bindingResult.hasFieldErrors("rentType")
                    || bindingResult.hasFieldErrors("poolArea")
                    || bindingResult.hasFieldErrors("standardRoom")){
                model.addAttribute("facilityTypeList",
                        this.iFacilityTypeService.findAll());

                model.addAttribute("rentTypeList",
                        this.iRentTypeService.findAll());

                return "facility/facility-create";
            }
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        this.iFacilityService.save(facility);

        redirectAttributes.addFlashAttribute("message",
                "successfully update");

        return "redirect:/facility/";
    }

    @GetMapping("/edit")
    public String goEditForm(@RequestParam int id, Model model){

        model.addAttribute("facility",
                this.iFacilityService.findById(id));

        model.addAttribute("facilityTypeList",
                this.iFacilityTypeService.findAll());

        model.addAttribute("rentTypeList",
                this.iRentTypeService.findAll());

        return "facility/facility-edit";
    }

    @PostMapping("/update")
    public String updateFacility(@ModelAttribute Facility facility,BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes , Model model , FacilityDto facilityDto){

        new FacilityDto().validate(facilityDto , bindingResult);

        if(bindingResult.hasFieldErrors()){
            model.addAttribute("facilityTypeList",
                    this.iFacilityTypeService.findAll());

            model.addAttribute("rentTypeList",
                    this.iRentTypeService.findAll());

            return "facility/facility-edit";
        }

        Facility facility1 = new Facility();
        BeanUtils.copyProperties(facilityDto,facility1);
        this.iFacilityService.save(facility1);

        redirectAttributes.addFlashAttribute("message",
                "successfully update");

        return "redirect:/facility/";
    }

    @PostMapping("/delete")
    public String deleteFacility(@RequestParam(value = "deleteId") int facilityId){

        this.iFacilityService.deleteById(facilityId);

        return "redirect:/facility/";
    }
}
