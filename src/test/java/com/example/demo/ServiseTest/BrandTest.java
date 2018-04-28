package com.example.demo.ServiseTest;

import com.example.demo.Entity.Brand;
import com.example.demo.Repository.Brand_Repository;
import com.example.demo.Service.Brand_Service;


import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.mockito.Mockito;
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
    public void testWith_TestNG() {

        
        Brand brand= new Brand("tv","toshiba ","sdfgh");
        Mockito.when(brand_repository.existsById(brand.getName())).thenReturn(false);
      //  Mockito.when(brand_service.AddBrand(brand)).thenReturn(expected);
        assertEquals( brand_service.AddBrand(brand),"sdfgh");
    }


}