package com.example.demo.Controllers;


import com.example.demo.Controllers.Entity.Platform;
import com.example.demo.Controllers.Entity.Product;
import com.example.demo.Controllers.Entity.Store;
import com.example.demo.Controllers.reprositery.PlatformRepritory;
import com.example.demo.Controllers.reprositery.ProductReprository;
import com.example.demo.Controllers.reprositery.StoreReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.Configuration;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ProductController {



    @Autowired
    private ProductReprository repristory;
    @Autowired
    private PlatformRepritory plat;
    @Autowired
    private StoreReprository store;
    @GetMapping("/AddProducttostore")
    public String index(Model model) {
        model.addAttribute("prod", new Product());
        return "storeAddProduct";
    }

    @PostMapping("/AddProducttostore")
    public String submit(Model model, @ModelAttribute Product prod) {
        model.addAttribute("prod", new Product());

        if (prod.getName().equals("") || prod.getProduct_type().equals("") ||prod.getStore_ID().equals("")||prod.getPrice()==0) {
            return "storeAddProduct";
        }
        Optional<Platform> optionalProduct =plat.findById(prod.getName());

         if (optionalProduct.isPresent()) {

             Platform temp_plat = optionalProduct.get();
            if (store.existsById(prod.getStore_ID()) && temp_plat.getPrice_start()<=prod.getPrice()&& temp_plat.getPrice_end()>=prod.getPrice()) {
                repristory.save(prod);
                return "storeOwner_page";
            }
            return "storeAddProduct";
        }
        return "storeAddProduct";

    }
    @GetMapping("/searchproduct")
    public ModelAndView show1(Model model ) {
        ArrayList<Product> st = new ArrayList<>();
        Iterable<Product> s =repristory.findAll();
        for(Product t : s)
        {

            st.add(t);
            t.setNum_view(t.getNum_view()+1);
            repristory.delete(t);
            repristory.save(t);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("st", st);
        mv.setViewName("productDesciption");
        return mv;


    }

    @GetMapping("/viewstatistics")
    public ModelAndView show55(Model model ) {
        ArrayList<Product> sf = new ArrayList<>();
        Iterable<Product> f =repristory.findAll();
        for(Product h : f)
        {

            sf.add(h);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("sf", sf);
        mv.setViewName("statistics");
        return mv;


    }


    @GetMapping("/Buy")
    public String jojo(Model model) {
        model.addAttribute("f", new Product());
        return "buy";
    }
    @PostMapping("/Buy")
    public String show2(Model model, @ModelAttribute Product product) {

        model.addAttribute(product);

        Optional<Product> stor = repristory.findById(product.getName());
        if (stor.isPresent()) {
            Product s = stor.get();

            System.out.println("done");
            s.setNum_buy(s.getNum_buy()+1);
            repristory.delete(s);
            repristory.save(s);

        }
        return "NormalUserPage";
    }

  /*  @GetMapping("/viewProduct")
    public String index1(Model model) {
        model.addAttribute("prod", new Product());
        return "storeAddProduct";
    }

    @PostMapping("/viewProduct")
    public String submit(Model model, @ModelAttribute Product prod) {
        model.addAttribute("prod", new Product());

        repristory.save(prod);
        return "storeAddProduct";
    }
@GetMapping("/searchproduct")
public  String index3(Model model)
{
    return "productDesciption";
}

    @GetMapping("/Show")
    public String  CreateQuestion(Model model){
        model.addAttribute("s", new Product());
        System.out.println();
        return "productDesciption";
    }
    @PostMapping("/Show")
    public ModelAndView show2( @ModelAttribute Product f) {

        ModelAndView mv=new ModelAndView();
        Optional<Product> stor = repristory.findById(f.getName());
        if (stor.isPresent()) {
            f = stor.get();
            mv.addObject("f",f);
        }
        mv.setViewName("productDesciption");
        return mv;
    }*/

}
