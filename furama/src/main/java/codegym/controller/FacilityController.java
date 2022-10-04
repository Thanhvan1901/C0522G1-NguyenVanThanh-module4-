package codegym.controller;

import codegym.dto.FacilityDto.FacilityDto;
import codegym.service.IFacilityService;
import codegym.service.IFacilityTypeService;
import codegym.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private  IFacilityTypeService iFacilityTypeService;

    @Autowired
    private IRentTypeService rentTypeService ;


    @GetMapping("/")
    public String showList(@RequestParam Optional<String> keySearch , @PageableDefault(value = 3)Pageable pageable , Model model){

        String keyVal = keySearch.orElse("");

        model.addAttribute("facility" , this.facilityService.findAllByNameContaining(keyVal,pageable));

        model.addAttribute("facilityType" ,this.iFacilityTypeService.findAll());

        model.addAttribute("renType" , this.rentTypeService.findAll());

        model.addAttribute("keyVal", keyVal);

        return "facility/facility-list" ;
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("facilityDto" , new FacilityDto()) ;
        model.addAttribute("facilityType" , this.iFacilityTypeService.findAll());
        model.addAttribute("rentType", this.rentTypeService.findAll());
        return "facility/facility-create" ;
     }




}
