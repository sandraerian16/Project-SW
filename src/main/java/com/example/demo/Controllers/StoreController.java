package com.example.demo.Controllers;

import com.example.demo.Controllers.Entity.Product;
import com.example.demo.Controllers.Entity.Store;
import com.example.demo.Controllers.reprositery.StoreReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class StoreController {
    @Autowired
    private StoreReprository storer;

    @GetMapping("/Addstore1")
    public String index(Model model) {
        model.addAttribute("store", new Store());
        return "AddStore";
    }
    @PostMapping("/Addstore1")
    public String submit(Model model, @ModelAttribute Store store) {
        model.addAttribute("store", new Store());
        if (store.getStore_name().equals("") || store.getStore_telephone().equals("") || store.getType().equals("") || store.getLocation().equals("")) {
            return "AddStore";
        }
        storer.save(store);

        return "AddStore";
    }
    @GetMapping("/Showstores")
    public ModelAndView show1(Model model ) {
        Store  f=new Store();
        ArrayList<Store> st = new ArrayList<>();
        Iterable<Store> s =storer.findAll();
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
    public String jojo(Model model) {
        model.addAttribute("f", new Store());
        return "to_approve";
    }
    @PostMapping("/approve")
    public String show2(Model model, @ModelAttribute Store store) {

        model.addAttribute(store);

        Optional<Store> stor = storer.findById(store.getStore_name());
        if (stor.isPresent()) {
            Store s = stor.get();
            s.setApproved(true);
            storer.delete(s);
            storer.save(s);
            System.out.println("done");
        }
        return "admin_face";

    }



















}
