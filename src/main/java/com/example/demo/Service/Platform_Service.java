package com.example.demo.Service;

import com.example.demo.Entity.Platform;
import com.example.demo.Repository.PlatformRepritory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
@Service
public class Platform_Service {

    @Autowired
    private PlatformRepritory platform;

    public Platform_Service() {
    }

    public String AddProduct(Model model, @ModelAttribute Platform pro) {
        model.addAttribute("pro", new Platform());
        if (platform.existsById(pro.getProduct_name())) {
            return "addproduct";
        }
        platform.save(pro);
        return "addproduct";
    }

}
