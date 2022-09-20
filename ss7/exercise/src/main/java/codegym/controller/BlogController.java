package codegym.controller;

import codegym.model.Blog;
import codegym.service.IBlogService;
import codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {


    @Autowired
    private IBlogService iblogService;
    @Autowired
    private ICategoryService icategoryService;

    @GetMapping("")
    public String search(String name,@PageableDefault(value = 3) Pageable pageable, Model model) {

        model.addAttribute("blogList", iblogService.findAllByBlogNameContaining(name,pageable));
        return "blog/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("categoryList",icategoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        iblogService.save(blog);
        redirectAttributes.addFlashAttribute("masseNew", "successfully added new !!");
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", iblogService.findById(id));
        return "blog/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        iblogService.update(blog);
        redirectAttributes.addFlashAttribute("messa", "edit successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("blog", iblogService.findById(id));
        return "blog/delete";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        iblogService.remove(blog.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blogView", iblogService.findById(id));
        return "blog/view";
    }


}
