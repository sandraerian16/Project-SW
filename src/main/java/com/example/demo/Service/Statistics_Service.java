package com.example.demo.Service;

import com.example.demo.Entity.Brand;
import com.example.demo.Entity.Platform;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.Statistics;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Service
public class Statistics_Service {
    @Autowired
    Statistics_Repository Srip;
    @Autowired
    Brand_Repository Brip;
    @Autowired
    UserReprository Urip;
    @Autowired
    ProductReprository Prip;
    @Autowired
    PlatformRepritory Plrip;


    public String AddStat(Model model, @ModelAttribute Statistics stat) {
        model.addAttribute("stat", new Statistics());
        System.out.println(stat.getEntity());
        if (stat.getEntity().equals("Products")) {
            return "product_stat";
        } else if (stat.getEntity().equals("Brands")) {
            return "brand_stat";
        } else {
            return "admin_face";
        }
    }

    public long BrandStat() {
        long num = Brip.count();

        return num;
    }


    public Iterable<Platform> brand_product(Model model, @ModelAttribute Statistics brand) {

        Iterable<Platform> arr = Plrip.findAll();
        return arr;

    }

    public Iterable<Product> Max() {
        Iterable<Product> arr = Prip.findAll();
        return arr;

    }

    public Iterable<Product> Min() {
        Iterable<Product> arr = Prip.findAll();
        return arr;
    }


}
