package com.example.demo.Controllers;

import com.example.demo.Controllers.Entity.Platform;
import com.example.demo.Controllers.Entity.Product;
import com.example.demo.Controllers.reprositery.PlatformRepritory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class platformController {
    @Autowired
    private PlatformRepritory platform;
    @GetMapping("/AddProduct")
    public String index(Model model) {
        model.addAttribute("pro", new Platform());
        return "addproduct";
    }

    @PostMapping("/AddProduct")
    public String submit(Model model, @ModelAttribute Platform pro) {
        model.addAttribute("pro", new Platform());
        if (platform.existsById(pro.getProduct_name())) {
            return "addproduct";
        }
        platform.save(pro);
        return "addproduct";
    }
}
