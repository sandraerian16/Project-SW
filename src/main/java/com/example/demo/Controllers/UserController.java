package com.example.demo.Controllers;

import com.example.demo.Controllers.Entity.User;
import com.example.demo.Controllers.reprositery.UserReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserReprository rep;

    @GetMapping("/Register")
    public String index(Model model) {
        model.addAttribute("sub", new User());
        return "register";
    }

    @PostMapping("/Register")
    public String submit(Model model, @ModelAttribute User sub) {
        model.addAttribute("sub", new User());

        if (sub.getEmail().equals("") || sub.getPassword().equals("") || sub.getUser_name().equals("")) {
            return "register";
        }
       /* else if (rep.findById(sub.getUser_name())!=null){
            return "register";
        }*/
        else if (rep.existsById(sub.getUser_name())) {
            return "register";
        }

        rep.save(sub);
        return "register";
    }


    @GetMapping("/login")
    public String index1(Model model) {
        model.addAttribute("sub", new User());
        return "login";
    }

    @PostMapping("/login")
    public String submit1(Model model, @ModelAttribute User sub) {
        model.addAttribute("sub", new User());

        if (sub.getPassword().equals("") || sub.getUser_name().equals("")) {
            return "login";
        }
    /*    else if (rep.findById(sub.getUser_name())!=null){
            return "register";
        }*/
        else {
            Optional<User> optionalUser = rep.findById(sub.getUser_name());
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                if (user.getPassword().equals(sub.getPassword())) {
                    if (user.getType().equals("Administrator")) {
                        return "admin_face";
                    }
                    else if (user.getType().equals("StoreOwner")){
                        return "storeOwner_page";
                    }
                    else if (user.getType().equals("NormalUser")){
                        return"NormalUserPage";
                    }
                }
            } else {
                return "login";
            }
        }
        return "register";
    }
}
