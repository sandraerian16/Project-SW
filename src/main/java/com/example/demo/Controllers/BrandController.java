package com.example.demo.Controllers;
import com.example.demo.Entity.Brand;
import com.example.demo.Repository.Brand_Repository;
import com.example.demo.Service.Brand_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Service.Brand_Service;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BrandController {

    @Autowired
    Brand_Service service;

    @GetMapping("/AddBrand")
    public String Addbrand(Model model) {
        model.addAttribute("pro", new Brand());
        return "Add_Brand";
    }

    @PostMapping("/AddBrand")
    public String AddBrand_info(Model model, @ModelAttribute Brand pro, HttpServletRequest request) {
        return service.AddBrand(model, pro,request);

    }

}
