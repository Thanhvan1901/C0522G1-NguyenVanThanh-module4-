package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.CartServiceImpl;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private CartServiceImpl cartService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showshop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action, Model model) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cartService.addProduct(productOptional.get(),cart);
            cartService.updateCart(cart);
            return "redirect:/shopping-cart";
        }
        if (action.equals("reduce")) {
            cartService.reduceProduct(productOptional.get(),cart);
            cartService.updateCart(cart);
            return "redirect:/shopping-cart";
        }
        if (action.equals("detail")) {
            model.addAttribute("product", productOptional.get());
            cartService.addProduct(productOptional.get(),cart);
            return "redirect:/detail/{id}";
        }
        cartService.addProduct(productOptional.get(),cart);
        cartService.updateCart(cart);
        return "redirect:/shop";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable Long id) {
        return new ModelAndView("/detail", "product", productService.findById(id).get());
    }

    @GetMapping("/remove/{id}")
    public String removeProduct(@PathVariable Long id, @ModelAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        cartService.removeProduct(productOptional.get(),cart);
        cartService.updateCart(cart);
        return "redirect:/shopping-cart";
    }

    @GetMapping("/payment")
    public String payment (@SessionAttribute("cart") Cart cart){
        cartService.clearCart(cart);
        cartService.updateCart(cart);
        return "redirect:/shop";
    }
}