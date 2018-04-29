package com.example.demo.Controllers;

import com.example.demo.Entity.Actions;
import com.example.demo.Service.*;
import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductReprository;
import com.example.demo.Service.Product_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ProductController {


    @Autowired
    Product_Service service;

    @Autowired
    ProductReprository Product_RB;

    @GetMapping("/AddProducttostore")
    public String AddProduct_ToStore(Model model) {
        model.addAttribute("prod", new Product());
        return "storeAddProduct";
    }

    @PostMapping("/AddProducttostore")
    public String AddProduct_ToStore_info( Model model,@ModelAttribute Product prod) {
        return  service.AddProduct_ToStore( model,prod);
    }

    @GetMapping("/editProductStore")
    public String EditProduct_ToStore(Model model) {
        model.addAttribute("prod1", new Product());
        return "storeEditProduct";
    }

    @PostMapping("/editProductStore")
    public String EditProduct_ToStore_info(Model model, @ModelAttribute Product prod1) {
        return  service.EditProduct_ToStore( model,prod1);
    }

    @GetMapping("/deleteProductStore")
    public String DeleteProduct_ToStore(Model model) {
        model.addAttribute("prod2", new Product());
        return "storeDeleteProduct";
    }

    @PostMapping("/deleteProductStore")
    public String DeleteProduct_ToStore_info( Model model,@ModelAttribute Product prod2) {
        return  service.DeleteProduct_ToStore(model, prod2);
    }

    @GetMapping("/searchproduct")
    public ModelAndView SearchProduct(Model model ) {
        ArrayList<Product> st = new ArrayList<>();
        Iterable<Product> s =Product_RB.findAll();
        for(Product t : s)
        {

            st.add(t);
            t.setNum_view(t.getNum_view()+1);
            Product_RB.delete(t);
            Product_RB.save(t);/////
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("st", st);
        mv.setViewName("productDesciption");
        return mv;
    }

    @GetMapping("/viewstatistics")
    public ModelAndView ShowStatistics(Model model ,HttpServletRequest request) {

      ArrayList<Product>sf = service.viewStatistic(request);
        ModelAndView mv = new ModelAndView();
        mv.addObject("sf", sf);
        mv.setViewName("statistics");
        return mv;

    }

    @GetMapping("/Buy")
    public String Buy_Product(Model model) {
        model.addAttribute("struct",new temp());
        return "buy";
    }
    @PostMapping("/Buy")
    public String Buy_Product_info(Model model,@ModelAttribute temp temp, HttpServletRequest request) throws Exception {

       return service.Buy_Product(model,temp,request);
    }
    @GetMapping("/Undo")
    public String UndoAction(Model model) {
        model.addAttribute("Action", new Actions());
        return "UndoAction";
    }

    @PostMapping("/Undo")
    public String UndoAction2(Model model,@ModelAttribute Actions Action) {
        return service.UndoAction2( model,Action);


    }
}
