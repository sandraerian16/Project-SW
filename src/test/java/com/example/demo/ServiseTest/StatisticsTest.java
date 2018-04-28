package com.example.demo.ServiseTest;


import com.example.demo.Entity.Platform;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.Statistics;
import com.example.demo.Repository.*;
import com.example.demo.Service.Statistics_Service;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.testng.Assert.assertEquals;

public class StatisticsTest {

    @Mock
    private Model model;
    @Mock
    private Brand_Repository Brip;
    @Mock
    private UserReprository Urip;
    @Mock
    private ProductReprository Prip;
    @Mock
    private PlatformRepritory Plrip;
    @Mock
    private Statistics_Repository statistics_repository;
    @InjectMocks
    private Statistics_Service statistics_service;
    @BeforeTest
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void wrongAddStatics() {
        Statistics statistics=new Statistics("entity", "function", 0);
        assertEquals(statistics_service.AddStat(model,statistics),"admin_face");
    }

    @Test
    public void BrandAddStatics() {
        Statistics statistics=new Statistics("Brands", "function", 0);
        assertEquals(statistics_service.AddStat(model,statistics),"brand_stat");
    }
    @Test
    public void ProductAddStatics() {
        Statistics statistics=new Statistics("Products", "function", 0);
        assertEquals(statistics_service.AddStat(model,statistics),"product_stat");
    }
    @Test
    public void BRAND_PRODUCT_TEST() throws Exception {
        Statistics statistics=new Statistics("Brands", "function", 0);

        Platform p=new Platform("product_name","product_brand", 3,  "product_category",5);
        ArrayList <Platform> s=new ArrayList<>();
       //s.a;
       //  s.add(p);
        Mockito.when(Plrip.findAll()).thenReturn(s);
        assertEquals( statistics_service.brand_product(model,statistics),s);

    }
    @Test
    public void MaxTEST() throws Exception {
        ArrayList <Product> s=new ArrayList<>();
        Mockito.when(Prip.findAll()).thenReturn(s);
        assertEquals( statistics_service.Max(),s);

    }
    @Test
    public void MinTEST() throws Exception {
        // hna lw fe haga f al DB hn3ml add leh f al arraylist deh

        ArrayList <Product> s=new ArrayList<>();
        Mockito.when(Prip.findAll()).thenReturn(s);
        assertEquals( statistics_service.Min(),s);

    }
}
