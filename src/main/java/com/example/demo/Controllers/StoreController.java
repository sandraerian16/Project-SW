package com.example.demo.Controllers;

import com.example.demo.Entity.Store;
import com.example.demo.Repository.StoreReprository;
import com.example.demo.Service.Store_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class StoreController {
    @Autowired
    Store_Service service;
    @Autowired
    private StoreReprository store_RB;

    @GetMapping("/Addstore1")
    public String AddStore(Model model) {
        model.addAttribute("store", new Store());
        return "AddStore";
    }
    @PostMapping("/Addstore1")
    public String AddStore_Info(Model model, @ModelAttribute Store store, HttpServletRequest request) {
       return  service.AddStore(model, store,request) ;
    }

    @GetMapping("/Showstores")
    public ModelAndView Show_Stores(Model model ) {
        Store  f=new Store();
        ArrayList<Store> st = new ArrayList<>();
        Iterable<Store> s =store_RB.findAll();
        for(Store t : s)
        {
            if(!t.getApproved())
            {
                st.add(t);
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("st", st);
        mv.addObject("f",f);
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

       return  service.Check_Approve(model, store);

    }



















}
