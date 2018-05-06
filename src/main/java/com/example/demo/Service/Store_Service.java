package com.example.demo.Service;

import com.example.demo.Entity.Collaborators_Class;
import com.example.demo.Entity.Store;
import com.example.demo.Entity.User;
import com.example.demo.Repository.Collaborators_Class_Repository;
import com.example.demo.Repository.StoreReprository;
import com.example.demo.Repository.UserReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Optional;


@Service
public class Store_Service {
    @Autowired
    private StoreReprository store_RB;

    @Autowired
    private Collaborators_Class_Repository Colla_RB;

    @Autowired
    private UserReprository User_RB;

    @Autowired
    private StoreReprository service;

    public Store_Service() {
    }

    Store t = new Store();

    public String AddStore(Model model, @ModelAttribute Store store, HttpServletRequest request) {
        model.addAttribute("store", new Store());
        if (store.getStore_name().equals("") || store.getStore_telephone().equals("") || store.getType().equals("") || store.getLocation().equals("")) {
            return "AddStore";
        }
        if (store_RB.existsById(store.getStore_name())) {
            return "AddStore";
        }
        HttpSession session = request.getSession();
        store.setOwner((String) session.getAttribute("username"));

        t.setOwner((String) session.getAttribute("username"));
        System.out.println("T.get Owner: " + (String) session.getAttribute("username"));
        store_RB.save(store);
        return "storeOwner_page";
    }

    public String Check_Approve(Model model, @ModelAttribute Store store) {
        model.addAttribute("f", new Store());
        model.addAttribute(store);
        Optional<Store> stor = store_RB.findById(store.getStore_name());
        if (stor.isPresent()&& stor.get().getApproved().equals(false)) {
            Store s = stor.get();
            // t=s;
            s.setApproved(true);
            store_RB.delete(s);
            store_RB.save(s);
            System.out.println("done");
            return "admin_face";
        }
        return "to_approve";
    }

    public String Check(Model model, @ModelAttribute User Sub, @ModelAttribute Store store, HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println("OOO: " + (String) session.getAttribute("username"));

        model.addAttribute(store);
        Optional<Store> stor = store_RB.findById(store.getStore_name());
        if (stor.isPresent()) {
            Store s = stor.get();
            t = stor.get();
            //s.setApproved(true);

            store_RB.delete(s);
            store_RB.save(s);
            t.setOwner("Alaa");
            System.out.println("OWner T: " + t.getOwner());
            System.out.println("done");
            System.out.println("T:>>>>>>>>>: " + t.getStore_name());
        }
        return "CPage";
    }

    public String Add_Colla(Model model, @ModelAttribute User Sub, HttpServletRequest request) {
        System.out.println("T2:>>>>>>>>>>>>: " + t.getStore_name());
        model.addAttribute("Sub", new User());

        if (Sub.getEmail().equals("") || Sub.getPassword().equals("") || Sub.getUser_name().equals("")) {
            return "Add_Collaborators";
        } else if (User_RB.existsById(Sub.getUser_name())) {
            return "Add_Collaborators";
        }
        Optional<Store> stor = store_RB.findById(t.getStore_name());
        System.out.println("Stoppeddddddddd");

        if (stor.isPresent()) {
            System.out.println("CUTTTTTT");
            ArrayList<String> Collaborators = new ArrayList<>();

            Store s = stor.get();
            // s.setOwner("Alaa");
            System.out.println("Found");
            System.out.println("Store Name: " + s.getStore_name());
            System.out.println("Store Owner: " + s.getOwner());
            System.out.println("Store Address: " + s.getStore_address());
            System.out.println("Store Location" + s.getLocation());
            System.out.println("Store Type: " + s.getType());
            System.out.println("Store telephone" + s.getStore_telephone());

            store_RB.delete(s);
            store_RB.save(s);

            Store t = new Store();
            t = stor.get();
            t.setCollab(Sub.getUser_name());
            System.out.println("Collab: " + t.getCollab());
            //t.Add_COLL_STRING(Sub.getUser_name());
            Collaborators = t.getCollaborators();
            Collaborators.add(Sub.getUser_name());
            t.setCollaborators(Collaborators);

            for (int k = 0; k < t.getCollaborators().size(); k++) {
                System.out.println("C: " + t.getCollaborators().get(k));
            }
            //t.setCollaborators(Collaborators);
            // System.out.println(t.getCollaborators().get(0));

            store_RB.delete(t);
            store_RB.save(t);
        }
        User_RB.save(Sub);
        return "storeOwner_page";
    }

    public String Login(Model model, @ModelAttribute User sub, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("sub", new User());

        if (sub.getPassword().equals("") || sub.getUser_name().equals("")) {
            return "Login_Collaborators";
        } else {
            Optional<User> optionalUser = User_RB.findById(sub.getUser_name());
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                if (user.getPassword().equals(sub.getPassword())) {

                    response.setContentType("text/html");
                    HttpSession session = request.getSession();
                    session.invalidate();
                    session = request.getSession();

                    session.setAttribute("username", user.getUser_name());
                    session.setAttribute("Address", user.getAddress());
                    System.out.println(session.getId());


                    if (user.getType().equals("Administrator")) {
                        return "admin_face";
                    } else if (user.getType().equals("StoreOwner")) {
                        return "storeOwner_page";
                    } else if (user.getType().equals("NormalUser")) {
                        return "NormalUserPage";
                    } else if (user.getType().equals("Collaborators")) {
                        return "collaborators_Page";
                    }
                }
            } else {
                return "Login_Collaborators";
            }
        }
        return "Add_Collaborators";
    }



   /* public String Login_Colla(Model model, @ModelAttribute Collaborators_Class sub, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("sub", new Collaborators_Class());
        if (sub.getPassword_ID().equals("") || sub.getName().equals("")) {
            return "Login_Collaborators";
        } else {
            Optional<Collaborators_Class> optionalCollaborator = Colla_RB.findById(sub.getName());
            if (optionalCollaborator.isPresent()) {
                Collaborators_Class C = optionalCollaborator.get();
                if (C.getPassword_ID().equals(sub.getPassword_ID())) {
                    response.setContentType("text/html");
                    HttpSession session = request.getSession();
                    session.invalidate();
                    session = request.getSession();
                    session.setAttribute("name", C.getName());
                    session.setAttribute("Password", C.getPassword_ID());
                    System.out.println(session.getId());

                    return "collaborators_Page";
                }

            } else {
                return "Login_Collaborators";
            }
        }
        return "Add_Collaborators";

    }*/

}



