package com.example.demo.ServiseTest;

import com.example.demo.Entity.Brand;
import com.example.demo.Entity.Platform;
import com.example.demo.Entity.Product;
import com.example.demo.Repository.PlatformRepritory;
import com.example.demo.Service.Platform_Service;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;

import static org.testng.Assert.assertEquals;

public class platformTest {

    @Mock
    private Model model;
    @Mock
    private PlatformRepritory platformRepritory;

    @Mock
    private HttpServletRequest request;

    @InjectMocks
    private Platform_Service platform_service;
    @BeforeTest
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void wrongAdd() {

        Platform platform= new Platform("product_name","product_brand", 3,  "product_category",5);
        //System.out.println( platform_service.AddProduct( model, platform));
        assertEquals( platform_service.AddProduct( model, platform,request),"addproduct");
    }
    @Test
    public void rightAdd() {


        Platform platform= new Platform("product_name","product_brand", 3,  "product_category",5);
        assertEquals( platform_service.AddProduct(model,platform,request),"admin_face");
    }
    @Test
    public void foundinDB() {


        Platform platform= new Platform("product_name","product_brand", 3,  "product_category",5);
        assertEquals(platformRepritory.existsById(platform.getProduct_name()),true);
    }
}
/*
import org.junit.runner.RunWith;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.Mockito;
        import org.mockito.MockitoAnnotations;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.ModelAttribute;
        import org.testng.Assert;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;
        import com.SWEProject.Entities.Brand;
        import com.SWEProject.Repositories.BrandRepository;
        import com.SWEProject.controller.BrandController;
        import com.SWEProject.controller.UserController;
        import static org.mockito.Mockito.*;

public class TC1_Valid_AddBrandTest {*/
 /*   @Mock
    Model model;
    @Mock
    BrandRepository brepo;
    @InjectMocks
    public BrandController b;
    @BeforeClass
    public void beforeTest()
    {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void openApp()
    {*/
     /*   Brand br = new Brand();
        br.setName("Zara");
        br.setCategory("clothes");
        Mockito.when(brepo.exists(br.getName())).thenReturn(false);
//	  Mockito.when(brepo.save(br)).thenReturn(br);
        Assert.assertEquals(b.addBrandP(model, br),"Admin");
    }
}
*/