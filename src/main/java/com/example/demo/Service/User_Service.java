package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class User_Service {

    @Autowired
    private UserReprository User_RB;
    @Autowired
    UserReprository use;


    public User_Service() {
    }

    public String Register(Model model, @ModelAttribute User sub) {
        model.addAttribute("sub", new User());

        if (sub.getEmail().equals("") || sub.getPassword().equals("") || sub.getUser_name().equals("")) {
            return "register";
        } else if (User_RB.existsById(sub.getUser_name())) {
            return "register";
        }

        User_RB.save(sub);
        return "login";
    }

    public ModelAndView go_to(String username, String type) {
        if (type.equals("Administrator")) {
            ModelAndView mv = new ModelAndView();
            mv.addObject("name", username);

            mv.setViewName("admin_face");
            return mv;
        } else if (type.equals("StoreOwner")) {
            ModelAndView mv = new ModelAndView();
            mv.addObject("name", username);
            mv.setViewName("storeOwner_page");
            return mv;

        } else if (type.equals("NormalUser")) {
            ModelAndView mv = new ModelAndView();
            mv.addObject("name", username);
            mv.setViewName("NormalUserPage");
            return mv;
        } else {
            ModelAndView mv = new ModelAndView();
            mv.addObject("name", username);
            mv.setViewName("collaborators_Page");
            return mv;
        }

    }

    public ModelAndView Login(Model model, @ModelAttribute User sub, HttpServletRequest request) {
        model.addAttribute("sub", new User());
        ModelAndView mv3 = new ModelAndView();
        mv3.setViewName("login");
        if (sub.getPassword().equals("") || sub.getUser_name().equals("")) {
            return mv3;
        } else {
            Optional<User> optionalUser = User_RB.findById(sub.getUser_name());
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                if (user.getPassword().equals(sub.getPassword())) {


                    HttpSession session;
                    try {
                        session = request.getSession();
                        session.invalidate();
                        session = request.getSession();

                        session.setAttribute("username", user.getUser_name());
                        session.setAttribute("Address", user.getAddress());
                        session.setAttribute("type", user.getType());
                        System.out.println(session.getId());
                    } catch (Exception e) {
                        System.out.println(e);
                    }


                    return go_to(user.getUser_name(), user.getType());

                }
            } else {
                return mv3;
            }
        }
        return mv3;
    }

    public String logout(HttpServletRequest request) {
        HttpSession session;
        try {
            session = request.getSession();
            session.invalidate();
        } catch (Exception e) {
            System.out.println(e);

        }
        return "logged out";

    }


}
