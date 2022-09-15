package codegym.controller;

import codegym.model.Music;
import codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private IMusicService musicService ;

    @GetMapping("")
    public ModelAndView index(){
        return new ModelAndView("/index" ,"musicList", musicService.findAll()) ;
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("music", new Music());
        return "/create";
    }
//
    @PostMapping("/save")
    public String save(Music music){
        music.setId((int) (Math.random() * 10000));
        musicService.save(music);
        return"redirect:/music";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id,Model model){
        model.addAttribute("music" , musicService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Music music){
        musicService.update( music);
        return "redirect:/music" ;
    }

    @GetMapping("/{id}/delete")
    public String delete(Music music , RedirectAttributes redirect){
        musicService.remove(music.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/music";
    }

    @GetMapping("/{id}/view")
    public String view (@PathVariable int id , Model model){
        model.addAttribute("music" , musicService.findById(id));
        return "/view";
    }

}
