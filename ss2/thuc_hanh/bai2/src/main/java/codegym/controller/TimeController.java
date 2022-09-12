package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("word-clock")
    public String getTimeByTimezone(ModelMap model , @RequestParam (name = "city" , required = false ,defaultValue = "Asia/HO_CHI_MINH")String city){
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city) ;
        Long local_time = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
        date.setTime(local_time);
        model.addAttribute("city" , city);
        model.addAttribute("date",date);
        return "index" ;
    }
}
