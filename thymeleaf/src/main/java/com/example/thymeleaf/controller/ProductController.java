package com.example.thymeleaf.controller;

import com.example.thymeleaf.pojo.Product;
import com.example.thymeleaf.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

//    @RequestMapping("/index")
//    public String index(Model model){
//         //model.addAttribute("products", productService.ShowAll());
//        return "index";
//    }
    
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

    //分页功能
    @RequestMapping("/page")
    public String page(Model model,
                       @RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "2") Integer pageSize)
    {
        //引入分页查询，使用PageHelper分页功能在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pageNum, pageSize);
        //startPage后紧跟的这个查询就是分页查询
        List<Product> products=productService.ShowAll();
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<Product>(products, 2);

        model.addAttribute("pageInfo", pageInfo);

        //获得当前页
        model.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());

        model.addAttribute("products", pageInfo.getList());
        System.out.println(pageInfo.getList()+"");

        return "index";
    }

}
