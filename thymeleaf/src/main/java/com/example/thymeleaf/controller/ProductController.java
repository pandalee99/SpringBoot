package com.example.thymeleaf.controller;

import com.example.thymeleaf.pojo.Product;
import com.example.thymeleaf.service.ProductService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/index")
    public String index(Model model){
         model.addAttribute("products", productService.ShowAll());
        return "index";
    }
    
    @RequestMapping("/deletelist/{id}")
    public String deletelist(@PathVariable("id") Long id){
        productService.delete(id);
        return "redirect:/index";
    }
    
    @RequestMapping("/add")
    public String add(Model model){
        Product product=new Product();
        model.addAttribute("product",product);
        return "add";
    }
    @RequestMapping("/delete")
    public String delete(Model model){
        Product product=new Product();
        model.addAttribute("product",product);
        return "delete";
    }
    
    @RequestMapping(value = "/deleteproduct",method = RequestMethod.POST)
    public String deletepro(@ModelAttribute Product product){
        productService.delete(product.getId());
        return "redirect:index";
    }
    
    
    @RequestMapping(value = "/addproduct",method = RequestMethod.POST)
    public String addpro(@ModelAttribute Product product){
        productService.add(product);
        return "redirect:/add";
    }

    @RequestMapping("/showpro/{p}")
    public String showpro(@PathVariable("p") String product,Model model){
        model.addAttribute("product",productService.get(product));
        return "show";
    }

}
