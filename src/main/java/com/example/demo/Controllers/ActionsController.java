package com.example.demo.Controllers;

import com.example.demo.Entity.Actions;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.Store;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ActionsRepository;
import com.example.demo.Repository.ProductReprository;
import com.example.demo.Repository.StoreReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.Service.Actions_Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ActionsController {
    @Autowired
    private ActionsRepository Actions_RB;
    @Autowired
    private ProductReprository product_RB;
    @Autowired
    Actions_Service service;
    @Autowired
    StoreReprository Store_RB;

    @GetMapping("/viewActionsST")
    public java.lang.String DeleteProduct_ToStore(Model model, HttpServletRequest request) {
        model.addAttribute("storeName", new Store());
        HttpSession session = request.getSession();
        ArrayList<Store> st = new ArrayList<>();
        Iterable<Store> s = Store_RB.findAll();

        System.out.println("fdgdfs : " + (String) session.getAttribute("username"));
        for (Store t : s) {
            if (t.getOwner().equals((String) session.getAttribute("username"))) {
                st.add(t);
            }
            // st.add(t);
        }
        model.addAttribute("st", st);

        return "viewActionsST";
    }

    @PostMapping("/viewActionsST")
    public String SearchProduct(Model model, @ModelAttribute Store storeName) {
        return service.storeActions(model, storeName);

    }


}
