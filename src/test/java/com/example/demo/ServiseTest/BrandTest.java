package com.example.demo.ServiseTest;


import com.example.demo.Entity.Brand;
import com.example.demo.Repository.Brand_Repository;
import com.example.demo.Service.Brand_Service;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;


public class BrandTest {


    @Mock
    private Brand_Repository brand_repository;

    @InjectMocks
    private  Brand_Service brand_service;

    @BeforeTest
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void wrongAdd() {

        
        Brand brand= new Brand("tv","toshiba ","sdfgh");
        assertEquals( brand_service.AddBrand(brand),"Add_Brand");
    }
    @Test
    public void rightAdd() {


        Brand brand= new Brand("tv","toshiba ","sdfgh");
        assertEquals( brand_service.AddBrand(brand),"admin_face");
    }
    @Test
    public void foundinDB() {


        Brand brand= new Brand("tv","toshiba ","sdfgh");
        assertEquals(brand_repository.existsById(brand.getName()),true);
    }
}