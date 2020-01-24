package com.example.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController  {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

@RequestMapping("/mypage")
    public String my(){
        return "mypage";
}
@RequestMapping("/admin")
 public String a(){
        return "admin";
}

    @RequestMapping("/logout")
    public String logoutpage(HttpServletRequest request, HttpServletResponse response){
        //Authentication 是一个接口，用来表示用户认证信息
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        if (auth!=null){
            new SecurityContextLogoutHandler().logout(request,response,auth);
        }

        //重定向到 login
        return "redirect:/login?logout";

    }

}
