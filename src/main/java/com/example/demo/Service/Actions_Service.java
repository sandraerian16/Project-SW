package com.example.demo.Service;

import com.example.demo.Entity.Actions;
import com.example.demo.Entity.Store;
import com.example.demo.Repository.ActionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Service
public class Actions_Service {
    @Autowired
    private ActionsRepository Actions_RB;

    public ModelAndView storeActions(Model model, @ModelAttribute Store storeName) {
        ArrayList<Actions> st = new ArrayList<>();
        Iterable<Actions> s = Actions_RB.findAll();
        ModelAndView mv = null;

        System.out.println("fdgdfs : " + storeName.getStore_name());
        for (Actions t : s) {
            if (t.getStoreID().equals(storeName.getStore_name())) {
                st.add(t);
            }
            // st.add(t);
        }
        mv = new ModelAndView();
        mv.addObject("st", st);
        mv.setViewName("viewActions");
        return mv;
    }
}
