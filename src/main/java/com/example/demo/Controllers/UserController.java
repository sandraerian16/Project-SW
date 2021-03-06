package com.example.demo.Controllers;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserReprository;
import com.example.demo.Service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;
@SessionAttributes("User")
@Controller
public class UserController {

    @Autowired
    private User_Service service;
    @Autowired UserReprository use;


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

        return service.Login(model, sub,  request);
    }
    @GetMapping("/showbalance")
    public ModelAndView show_balance(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        Optional<User> user = use.findById((String) session.getAttribute("username"));
        User user1 = new User();
        ModelAndView mv = new ModelAndView();

        if(user.isPresent()){user1=user.get();
            mv.addObject("balance", user1.getbalance());
        }
        mv.setViewName("ViewBalance");
        return mv;
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request,Model model)
    {
        service.logout(request);
        return Login(model);
    }
    @GetMapping("/Back")
    public String Back(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        String type=(String)session.getAttribute("type");
        if(type.equals("Administrator"))
        {
            return "admin_face";
        }
        else if(type.equals("StoreOwner"))
        {
            return "storeOwner_page";
        }
        else if(type.equals("Collaborators"))
        {
            return "collaborators_Page";
        }
        else if(type.equals("NormalUser"))
        {
            return "NormalUserPage";
        }
        return "login";

    }
}
