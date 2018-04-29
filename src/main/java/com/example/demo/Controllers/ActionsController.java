package com.example.demo.Controllers;
import com.example.demo.Entity.Actions;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.Store;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ActionsRepository;
import com.example.demo.Repository.ProductReprository;
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

    @GetMapping("/viewActionsST")
    public java.lang.String DeleteProduct_ToStore(Model model) {
        model.addAttribute("storeName", new Store());

        return "viewActionsST";
    }

    @PostMapping("/viewActionsST")
    public ModelAndView SearchProduct(Model model, @ModelAttribute Store storeName) {
         ArrayList<Actions> st=service.storeActions(model, storeName);
        ModelAndView mv = new ModelAndView();
        mv = new ModelAndView();
        mv.addObject("st", st);
        mv.setViewName("viewActions");
        return mv;

    }
}

