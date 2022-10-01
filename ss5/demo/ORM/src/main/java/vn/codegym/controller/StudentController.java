package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Student;
import vn.codegym.service.IStudentService;

@Controller
@RequestMapping({"/student","/home"})
public class StudentController {

    @Qualifier("studentServiceImpl")
    @Autowired
    private IStudentService studentService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView showStudentList(){
        return new ModelAndView("student",
                "studentList", studentService.findAll());
    }

    @PostMapping("/list")
    public ModelAndView showStudentList1(){
        return new ModelAndView("student",
                "studentList", studentService.findAll());
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student,
                                RedirectAttributes redirectAttributes){

        studentService.save(student);
        redirectAttributes.addFlashAttribute("message",
                "Create student: " + student.getName() + " OK!");
//        return "forward:/student/list";
        return "redirect:/student/list";
    }
}
