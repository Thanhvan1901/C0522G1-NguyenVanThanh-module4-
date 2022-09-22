package codegym.controller;

import codegym.model.Book;
import codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

    @Autowired
    private IBookService iBookService ;

    @GetMapping("")
    public String showListBook(@PageableDefault (value = 3)Pageable pageable , Model model){
        model.addAttribute("bookList" , iBookService.findAll(pageable));
        return "/index";
    }

    @GetMapping("/{id}/borrow")
    public String borrowBook(@PathVariable int id, Model model) throws Exception{
        Book book = iBookService.findById(id) ;
        if(book.getAmountBook() == 0){
            throw new Exception() ;
        }
            model.addAttribute("books" , iBookService.findById(id));
            return "/borrow";
        }

    @PostMapping("/check")
    public String checkBook(Book book , RedirectAttributes redirectAttributes){
            book.setAmountBook(book.getAmountBook() - 1);
            iBookService.save(book);
            redirectAttributes.addFlashAttribute("success" , "Borrowing books successfully");
            return "redirect:/";
    }

    @GetMapping("/{id}/pay")
    public String showPay(@PathVariable int id, Model model) throws Exception {
        Book book = iBookService.findById(id) ;
        if(book.getAmountBook() >= book.getSumBook()){
            throw new Exception() ;
        }else {
            model.addAttribute("books" , iBookService.findById(id));
            return "/give";
        }
    }
    @PostMapping("/savePay")
    public String payBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) throws Exception {
        book.setAmountBook(book.getAmountBook() + 1);
        iBookService.save(book);
        redirectAttributes.addFlashAttribute("success" , "Successfully returned the book");
        return "redirect:/";
    }

//    @GetMapping("/{id}/pay")
//    public String showPay(@PathVariable int id, Model model) {
//        model.addAttribute("book", iBookService.findById(id));
//        return "/give";
//    }
//    @PostMapping("/savePay")
//    public String payBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) throws Exception {
//
//        if(book.getAmountBook() == book.getSumBook()){
//            throw new Exception();
//        }else {
//            book.setAmountBook(book.getAmountBook() + 1);
//            iBookService.save(book);
//            redirectAttributes.addFlashAttribute("success", "Successfully returned the book!!");
//            return "redirect:/";
//        }
//    }


//    @GetMapping("/{id}/pay")
//    public String showPay(@PathVariable int id, Model model) {
//        model.addAttribute("book", iBookService.findById(id));
//        return "/give";
//    }
//    @PostMapping("/savePay")
//    public String payBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
//        if(book.getAmountBook() == book.getSumBook()){
//            redirectAttributes.addFlashAttribute("success", "Book Is FULL");
//            return "redirect:/";
//        }else {
//            book.setAmountBook(book.getAmountBook() +1);
//            iBookService.save(book);
//            redirectAttributes.addFlashAttribute("success", "Successfull!!");
//            return "redirect:/";
//        }
//    }

}
