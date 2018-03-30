package com.example.demo.Service;

import com.example.demo.Entity.Brand;
import com.example.demo.Repository.Brand_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public  class  Brand_Service {
    @Autowired
    private Brand_Repository B_R;

    public Brand_Service() {
    }
    public String AddBrand(Model model,  @ModelAttribute Brand pro) {


        model.addAttribute("pro", new Brand());
        if (B_R.existsById(pro.getName())) {
            return "Add_Brand";
        }
        B_R.save(pro);
        return "Add_Brand";
    }

}
