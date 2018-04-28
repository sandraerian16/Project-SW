package com.example.demo.Service;

import com.example.demo.Entity.Brand;
import com.example.demo.Repository.Brand_Repository;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.testng.annotations.BeforeMethod;

import javax.inject.Inject;



@Service
public  class  Brand_Service {
    @Autowired
    private Brand_Repository B_R;

    public Brand_Service() {
    }
    @BeforeMethod
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    public String AddBrand( @ModelAttribute Brand pro) {


        if (B_R.existsById(pro.getName())) {
            return "Add_Brand";
        }
        B_R.save(pro);
        return "admin_face";
    }

}
