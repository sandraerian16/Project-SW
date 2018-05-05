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


    public ModelAndView Login(Model model, @ModelAttribute User sub, HttpServletRequest request, HttpServletResponse response) {
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

                    response.setContentType("text/html");
                    HttpSession session = request.getSession();
                    session.invalidate();
                    session = request.getSession();

                    session.setAttribute("username", user.getUser_name());
                    session.setAttribute("Address", user.getAddress());
                    session.setAttribute("type", user.getType());
                    System.out.println(session.getId());
                    ModelAndView mv2 = new ModelAndView();
                    mv2.setViewName("login");


                    if (user.getType().equals("Administrator")) {
                        Optional<User> userr = use.findById((String) session.getAttribute("username"));
                        User user1 = new User();
                        ModelAndView mv = new ModelAndView();

                        if (userr.isPresent()) {
                            user1 = userr.get();
                            mv.addObject("name", user1.getUser_name());

                        }
                        mv.setViewName("admin_face");
                        return mv;
                    } else if (user.getType().equals("StoreOwner")) {
                        Optional<User> userr = use.findById((String) session.getAttribute("username"));
                        User user1 = new User();
                        ModelAndView mv = new ModelAndView();

                        if (userr.isPresent()) {
                            user1 = userr.get();
                            mv.addObject("name", user1.getUser_name());
                        }
                        mv.setViewName("storeOwner_page");
                        return mv;

                    } else if (user.getType().equals("NormalUser")) {
                        Optional<User> userr = use.findById((String) session.getAttribute("username"));
                        User user1 = new User();
                        ModelAndView mv = new ModelAndView();

                        if (userr.isPresent()) {
                            user1 = userr.get();
                            mv.addObject("name", user1.getUser_name());

                        }
                        mv.setViewName("NormalUserPage");
                        return mv;
                    } else if (user.getType().equals("Collaborators")) {
                        Optional<User> userr = use.findById((String) session.getAttribute("username"));
                        User user1 = new User();
                        ModelAndView mv = new ModelAndView();

                        if (userr.isPresent()) {
                            user1 = userr.get();
                            mv.addObject("name", user1.getUser_name());

                        }
                        mv.setViewName("collaborators_Page");
                        return mv;
                    }
                }
            } else {
                return mv3;
            }
        }
        return mv3;
    }

    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
    }


}
