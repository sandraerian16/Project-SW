package com.example.demo.Controllers;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserReprository;
import com.example.demo.Service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@SessionAttributes("User")
@Controller
public class UserController {

    @Autowired
    private User_Service service;


    @GetMapping("/Register")
    public String Register(Model model) {
        model.addAttribute("sub", new User());
        return "register";
    }

    @PostMapping("/Register")
    public String Register_info(Model model, @ModelAttribute User sub) {
       return service.Register(model, sub);
    }

    @GetMapping("/login")
    public String Login(Model model) {
        model.addAttribute("sub", new User());
        return "login";
    }

    @PostMapping("/login")
    public String Login_Info(Model model, @ModelAttribute User sub,HttpServletRequest request,HttpServletResponse response) {

        return service.Login(model, sub,  request,  response);
    }
}
