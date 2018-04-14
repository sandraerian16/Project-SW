package com.example.demo.Service;


import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class Product_Service {
    @Autowired
    ProductReprository Product_RB;
    @Autowired
    private PlatformRepritory plat;
    @Autowired
    private StoreReprository store;
    @Autowired
    private UserReprository use;
    @Autowired
    ActionsRepository Actions_RB;

    public Product_Service() {
    }

    public String AddProduct_ToStore(Model model, @ModelAttribute Product prod) {
        model.addAttribute("prod", new Product());

        if (prod.getName().equals("") || prod.getProduct_type().equals("") || prod.getStore_ID().equals("") || prod.getPrice() == 0) {
            return "storeAddProduct";
        }
        System.out.println(prod.getQuntity());
        Optional<Platform> optionalProduct = plat.findById(prod.getName());

        if (optionalProduct.isPresent()) {

            Platform temp_plat = optionalProduct.get();
            if (store.existsById(prod.getStore_ID()) && temp_plat.getPrice_start() <= prod.getPrice() && temp_plat.getPrice_end() >= prod.getPrice()) {
                Product_RB.save(prod);
                Actions A1 = new Actions();
                A1.setProductName(prod.getName());
                A1.setStoreID(prod.getStore_ID());
                A1.setType("ADD");
                Actions_RB.save(A1);
                return "storeOwner_page";
            }
            return "storeAddProduct";
        }
        return "storeAddProduct";

    }

    public String EditProduct_ToStore(Model model, @ModelAttribute Product prod1) {
        model.addAttribute("prod1", new Product());

        if (prod1.getName().equals("") || prod1.getProduct_type().equals("") || prod1.getPrice() == 0) {
            return "storeEditProduct";
        }
        System.out.println(prod1.getQuntity());
        Optional<Platform> optionalProduct = plat.findById(prod1.getName());
        Optional<Product> optionalProduct1 = Product_RB.findById(prod1.getName());


        if (optionalProduct.isPresent()&&optionalProduct1.isPresent()) {

            Platform temp_plat = optionalProduct.get();
            Product temp_prod = optionalProduct1.get();

            if ( temp_plat.getPrice_start() <= prod1.getPrice() && temp_plat.getPrice_end() >= prod1.getPrice()) {
                prod1.setNum_buy(temp_prod.getNum_buy());
                prod1.setNum_view(temp_prod.getNum_view());
                prod1.setStore_ID(temp_prod.getStore_ID());
                Product_RB.deleteById(prod1.getName());
                Product_RB.save(prod1);
                Actions A1 = new Actions();
                A1.setProductName(prod1.getName());
                A1.setStoreID(prod1.getStore_ID());
                A1.setType("EDIT");
                Actions_RB.save(A1);
                return "storeOwner_page";
            }
            return "storeEditProduct";
        }
        return "storeEditProduct";

    }

    public String DeleteProduct_ToStore(Model model, @ModelAttribute Product prod2) {
        model.addAttribute("prod2", new Product());

        if (prod2.getName().equals("") ) {
            return "storeDeleteProduct";
        }
        System.out.println(prod2.getQuntity());
        Optional<Product> optionalProduct1 = Product_RB.findById(prod2.getName());
        if (optionalProduct1.isPresent()) {

            Product temp_prod = optionalProduct1.get();

            if (Product_RB.existsById(prod2.getName())) {
                Actions A1 = new Actions();
                A1.setProductName(prod2.getName());
                A1.setStoreID(temp_prod.getStore_ID());
                A1.setType("DELETE");
                Actions_RB.save(A1);
                Product_RB.deleteById(prod2.getName());

                return "storeOwner_page";
            }
            return "storeDeleteProduct";}

        return "storeDeleteProduct";

    }



    public String Buy_Product(Model model, @ModelAttribute temp temp, HttpServletRequest request) {

        model.addAttribute(temp);
        HttpSession session = request.getSession();
        Optional<Product> product = Product_RB.findById(temp.getName());
        Optional<User> user = use.findById((String) session.getAttribute("username"));
        User user1;
        if (user.isPresent() && product.isPresent()) {
            System.out.println("true");
            user1 = user.get();
            Product s = product.get();
            if (user1.getAddress().equals(temp.address) && temp.agree && s.getQuntity() >= temp.num) {
                double price = temp.num * s.getPrice();
                double discount=0;
                System.out.println(price);
                if (user1.getType().equals("StoreOwner")) {
                    discount+=  0.15;
                }
                if (temp.num >= 2) {
                    discount += 0.1;
                }
                if (user1.getBought() == 0) {
                    discount+= 0.05;
                }
                System.out.println(discount);
                price = price - (price*discount);
                System.out.println(user1.getbalance() - price);
                user1.setbalance(user1.getbalance() - price);
                user1.setBought(user1.getBought() + 1);
                use.delete(user1);
                use.save(user1);

                s.setNum_buy(s.getNum_buy() + temp.num);
                s.setQuntity(s.getQuntity() - temp.num);
                Product_RB.delete(s);
                Product_RB.save(s);
            }
        }
        String t = (String) session.getAttribute("type");
        if (t.equals("StoreOwner")) {
            return "storeOwner_page";
        }
        return "NormalUserPage";

    }

    public ArrayList<Product> viewStatistic(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("username");
        Optional<User> opuser = use.findById(name);
        User Store_owner = new User();
        if (opuser.isPresent()) {
            Store_owner = opuser.get();
        }
        Iterable<Store> arr = store.findAll();   // all the stores in the system
        ArrayList<String> list = new ArrayList<>(); // all the stores that is owned by the logged in storeowner
        for (Store s : arr) {
            if (s.getApproved() && s.getOwner().equals(Store_owner.getUser_name())) {
                list.add(s.getStore_name());
            }
        }
        ArrayList<Product> sf = new ArrayList<>();
        Iterable<Product> f = Product_RB.findAll();
        for (Product h : f) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(h.getStore_ID())) {
                    sf.add(h);
                }
            }
        }
        return sf;
    }


}
