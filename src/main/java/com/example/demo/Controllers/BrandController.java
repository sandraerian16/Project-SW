package com.example.demo.Controllers;
import com.example.demo.Controllers.Entity.Brand;
import com.example.demo.Controllers.reprositery.Brand_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BrandController {
    @Autowired
    private Brand_Repository B_R;

    @GetMapping("/AddBrand")
    public String index(Model model) {
        model.addAttribute("pro", new Brand());
        return "Add_Brand";
    }

    @PostMapping("/AddBrand")
    public String submit(Model model, @ModelAttribute Brand pro) {
        model.addAttribute("pro", new Brand());
        if (B_R.existsById(pro.getName())) {
            return "Add_Brand";
        }

        B_R.save(pro);
        return "Add_Brand";
    }

}
