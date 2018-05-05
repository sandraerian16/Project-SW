package com.example.demo.Controllers;

import com.example.demo.Entity.Collaborators_Class;
import com.example.demo.Entity.Store;
import com.example.demo.Entity.User;
import com.example.demo.Repository.Collaborators_Class_Repository;
import com.example.demo.Repository.StoreReprository;
import com.example.demo.Service.Store_Service;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StoreController {
    @Autowired
    Store_Service service;
    @Autowired
    private StoreReprository store_RB;
    @Autowired
    private Collaborators_Class_Repository Colla_RB;

    @GetMapping("/Addstore1")
    public String AddStore(Model model) {
        model.addAttribute("store", new Store());
        return "AddStore";
    }

    @PostMapping("/Addstore1")
    public String AddStore_Info(Model model, @ModelAttribute Store store, HttpServletRequest request) {
        return service.AddStore(model, store, request);
    }

    @GetMapping("/Showstores")
    public ModelAndView Show_Stores(Model model) {
        Store f = new Store();
        ArrayList<Store> st = new ArrayList<>();
        Iterable<Store> s = store_RB.findAll();
        for (Store t : s) {
            if (!t.getApproved()) {
                st.add(t);
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("st", st);
        mv.addObject("f", f);
        mv.setViewName("StoreList");
        return mv;
    }

    @GetMapping("/approve")
    public String Approve(Model model) {
        model.addAttribute("f", new Store());
        return "to_approve";
    }

    @PostMapping("/approve")
    public String Check_Approve(Model model, @ModelAttribute Store store) {

        return service.Check_Approve(model, store);
    }

    @GetMapping("/Add_Colla")
    public String Add_Colla(Model model) {
        model.addAttribute("Sub", new User());
        return "Add_Collaborators";
    }

    @PostMapping("/Add_Colla")
    public String Add_Colla_Info(Model model, @ModelAttribute User Sub, @ModelAttribute Store store, HttpServletRequest request) {
        return service.Add_Colla(model, Sub, request);
    }


    @GetMapping("/Add_Col")
    public String Add_Col(Model model) {
        model.addAttribute("f", new Store());
        return "Add_Col";
    }

    @PostMapping("/Add_Col")
    public String Check_Add_Col(Model model, @ModelAttribute User Sub, @ModelAttribute Store store, HttpServletRequest request) {

        return service.Check(model, Sub, store, request);
    }

}