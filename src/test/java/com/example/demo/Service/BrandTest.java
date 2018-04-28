package com.example.demo.Service;

import com.example.demo.Entity.Brand;
import com.example.demo.Repository.Brand_Repository;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

public class BrandTest {


    @Mock
    private Brand_Repository brand_repository;
    @Mock
    private Model model;
    @InjectMocks
    private  Brand_Service brand_service;

    @BeforeTest
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void wrongAdd() {


        Brand brand= new Brand("tv","toshiba ","sdfgh");
        assertEquals( brand_service.AddBrand(model,brand),"Add_Brand");
    }
    @Test
    public void rightAdd() {


        Brand brand= new Brand("tv","toshiba ","sdfgh");
        assertEquals( brand_service.AddBrand(model,brand),"admin_face");
    }
    @Test
    public void foundinDB() {


        Brand brand= new Brand("tv","toshiba ","sdfgh");
        assertEquals(brand_repository.existsById(brand.getName()),true);
    }
}