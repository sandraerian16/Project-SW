package com.example.demo.Service;

import com.example.demo.Entity.Store;
import com.example.demo.Repository.StoreReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class Store_Service {
    @Autowired
    private StoreReprository store_RB;

    public Store_Service() {
    }

    public String AddStore(Model model, @ModelAttribute Store store, HttpServletRequest request) {
        model.addAttribute("store", new Store());
        if (store.getStore_name().equals("") || store.getStore_telephone().equals("") || store.getType().equals("") || store.getLocation().equals("")) {
            return "AddStore";
        }
        HttpSession session = request.getSession();
        store.setOwner((String)session.getAttribute("username"));
        store_RB.save(store);

        return "AddStore";
    }

    public String Check_Approve(Model model, @ModelAttribute Store store) {

        model.addAttribute(store);

        Optional<Store> stor = store_RB.findById(store.getStore_name());
        if (stor.isPresent()) {
            Store s = stor.get();
            s.setApproved(true);
            store_RB.delete(s);
            store_RB.save(s);
            System.out.println("done");
        }
        return "admin_face";

    }







}
