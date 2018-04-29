package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class User_Service {

    @Autowired
    private UserReprository User_RB;

    public User_Service() {
    }

    public String Register(Model model, @ModelAttribute User sub) {
        model.addAttribute("sub", new User());

        if (sub.getEmail().equals("") || sub.getPassword().equals("") || sub.getUser_name().equals("")) {
            return "register";
        }

        else if (User_RB.existsById(sub.getUser_name())) {
            return "register";
        }

        User_RB.save(sub);
        return "register";
    }


    public String Login(Model model, @ModelAttribute User sub, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("sub", new User());

        if (sub.getPassword().equals("") || sub.getUser_name().equals("")) {
            return "login";
        }

        else {
            Optional<User> optionalUser = User_RB.findById(sub.getUser_name());
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                if (user.getPassword().equals(sub.getPassword())) {

                    response.setContentType("text/html");
                    HttpSession session = request.getSession();
                    //session.invalidate();
                    session=request.getSession();
                    try {
                        session.setAttribute("username", user.getUser_name());
                        session.setAttribute("Address", user.getAddress());
                        session.setAttribute("type", user.getType());
                        System.out.println(session.getId());
                    }catch(Exception e){
                        System.out.println(e);
                    }




                    if (user.getType().equals("Administrator")) {
                        return "admin_face";
                    }
                    else if (user.getType().equals("StoreOwner")){
                        return "storeOwner_page";
                    }
                    else if (user.getType().equals("NormalUser")){
                        return"NormalUserPage";
                    }
                    else if (user.getType().equals("Collaborators")){
                        return"collaborators_Page";
                    }
                }
            } else {
                return "login";
            }
        }
        return "register";
    }

    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
    }


}
