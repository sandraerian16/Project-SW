package com.example.demo.Controllers;
import com.example.demo.Entity.Platform;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.Statistics;
import com.example.demo.Repository.*;
import com.example.demo.Service.Statistics_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StatisticsController {
    @Autowired
    Statistics_Service service;
    @Autowired
    Statistics_Repository Srip;
    @Autowired
    Brand_Repository Brip;
    @Autowired
    UserReprository Urip;
    @Autowired
    ProductReprository Prip;
    @Autowired
    PlatformRepritory Plrip;

    @GetMapping("/AddStat")
    public String index(Model model) {
        model.addAttribute("stat", new Statistics());
        return "AddStatistics";
    }

    @PostMapping("/AddStat")
    public String submit(Model model, @ModelAttribute Statistics stat) {
        return service.AddStat(model,stat);
    }

    @GetMapping("/num_brands")
    public String BrandStat() {
        long num = service.BrandStat();
        Statistics brand = new Statistics();
        brand.setFunction("sum");
        brand.setValue(num);
        if (Srip.existsById(brand.getFunction())) {
            Srip.delete(brand);
            Srip.save(brand);
        } else {
            brand.setEntity("Brand");
            Srip.save(brand);
        }
        return "admin_face";
    }

    @GetMapping("/specificBrand")
    public String brandStat(Model model) {
        model.addAttribute("stat", new Statistics());
        return "spbrand";

    }

    @PostMapping("/specificBrand")
    public String brand_product(Model model, @ModelAttribute Statistics brand) {
        String name = brand.getEntity();
        brand.setEntity("Brand");
        brand.setFunction("Number of products with specific brand(" + name + ")");
        Iterable<Platform> arr = service.brand_product(model,brand);
        long num = 0;
        for (Platform p : arr) {
            if (p.getProduct_brand().equals(name)) {
                num++;
            }
        }
        brand.setValue(num);
        if (Srip.existsById(brand.getFunction())) {
            Srip.delete(brand);
            Srip.save(brand);
        } else {
            Srip.save(brand);
        }
        return "admin_face";
    }

    @GetMapping("/maxP")
    public String productstat() {
        Iterable<Product> arr = service.Max();
        long Max=0;
        String name="";
        for (Product p : arr)
        {
            if(p.getNum_buy()>Max)
            {
                Max = p.getNum_buy();
                name=p.getName();

            }
        }
        Statistics stat = new Statistics("Product ("+name+")","Max",Max);
        if(Srip.existsById(stat.getFunction())){
            Srip.delete(stat);
            Srip.save(stat);
        }
        Srip.save(stat);
        return "admin_face";
    }

    @GetMapping("/minP")
    public String productstat2() {
        Iterable<Product> arr = service.Min();
        long Min=1000000;
        String name="";
        for (Product p : arr)
        {
            if(p.getNum_buy()<Min)
            {
                Min = p.getNum_buy();
                name=p.getName();
            }
        }
        Statistics stat = new Statistics("Product ("+name+")","Min",Min);
        if(Srip.existsById(stat.getFunction())){
            Srip.delete(stat);
            Srip.save(stat);
        }
        Srip.save(stat);
        return "admin_face";
    }

    @GetMapping("/ViewStat")
    public ModelAndView viewStat(Model model)
    {
        Statistics  stat=new Statistics();
        //   ArrayList<Statistics> st = new ArrayList<>();
        Iterable<Statistics> s =Srip.findAll();

        ModelAndView mv = new ModelAndView();
        mv.addObject("s", s);

        mv.setViewName("ViewStat");
        return mv;

    }



}
