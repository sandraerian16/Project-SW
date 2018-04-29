package com.example.demo.Controllers;

import com.example.demo.Entity.Platform;
import com.example.demo.Repository.PlatformRepritory;
import com.example.demo.Service.Platform_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class platformController {

    @Autowired
    Platform_Service service;

    @GetMapping("/AddProduct")
    public String AddProduct(Model model) {
        model.addAttribute("pro", new Platform());
        return "addproduct";
    }

    @PostMapping("/AddProduct")
    public String AddProduct_info(Model model, @ModelAttribute Platform pro, HttpServletRequest request) {
        return service.AddProduct(model, pro,request);
    }
}
