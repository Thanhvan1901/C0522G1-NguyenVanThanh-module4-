package translate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import translate.model.Translate;
import translate.service.ITranslateService;

import javax.xml.ws.Service;
import java.util.List;

@Controller
public class TranslateContrller {
    @Autowired
    private ITranslateService iTranslateService ;
    @GetMapping("")
    public String index(){
        return "index" ;
    }
    @PostMapping("/result")
    public ModelAndView result(@RequestParam String english, String vietnam){
        return new ModelAndView("/result","result",iTranslateService.findByWord(english, vietnam));
    }
}
