package com.example.demo.Service;

import com.example.demo.Entity.Platform;
import com.example.demo.Repository.PlatformRepritory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class Platform_Service {

    @Autowired
    private PlatformRepritory platform;

    public Platform_Service() {
    }

    public String Gone(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        String type=(String)session.getAttribute("type");
        if(type.equals("Administrator"))
        {
            return "admin_face";
        }
        else if(type.equals("StoreOwner"))
        {
            return "storeOwner_page";
        }
        else if(type.equals("Collaborators"))
        {
            return "collaborators_Page";
        }
        else if(type.equals("NormalUser"))
        {
            return "NormalUserPage";
        }
        return "login";

    }
    public String AddProduct(Model model, @ModelAttribute Platform pro, HttpServletRequest request) {
        model.addAttribute("pro", new Platform());
        if (platform.existsById(pro.getProduct_name()))
        {
            return "addproduct";
        }
        platform.save(pro);
        return Gone(request);
    }

}
