package com.example.demo.Controllers;
import com.example.demo.Entity.Actions;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.Store;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ActionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class ActionsController {
    @Autowired
    private ActionsRepository Actions_RB;
    String namee;

    @GetMapping("/viewActionsST")
    public java.lang.String DeleteProduct_ToStore(Model model) {
        model.addAttribute("storeName", new Store());


        return "viewActionsST";
    }
    @PostMapping("/viewActionsST")
    public ModelAndView SearchProduct(Model model , @ModelAttribute Store storeName ) {
        ArrayList<Actions> st = new ArrayList<>();
        Iterable<Actions> s = Actions_RB.findAll();
        ModelAndView mv = null;

        System.out.println("fdgdfs : " + storeName.getStore_name());
        for(Actions t : s)
        {
            if(t.getStoreID().equals(storeName.getStore_name())){st.add(t);}
            // st.add(t);
        }
         mv = new ModelAndView();
        mv.addObject("st", st);
        mv.setViewName("viewActions");
        return mv;
    }

    /*@GetMapping("/viewActions")
    public ModelAndView SearchProduct(Model model , HttpServletRequest request ) {
        ArrayList<Actions> st = new ArrayList<>();
        Iterable<Actions> s = Actions_RB.findAll();
        ModelAndView mv = null;
        HttpSession session = request.getSession();
        String namenow = (String) session.getAttribute("storeName");
        System.out.println("fdgdfs : " + namenow);
        for(Actions t : s)
        {
            if(t.getStoreID().equals("store1")){st.add(t);}
           // st.add(t);
        }
            mv = new ModelAndView();
        mv.addObject("st", st);
        mv.setViewName("viewActions");
        return mv;
    }
*/


}
