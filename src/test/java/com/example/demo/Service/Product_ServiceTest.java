package com.example.demo.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductReprository;
import com.example.demo.Repository.StoreReprository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Product_ServiceTest {
    @Mock
    private ProductReprository reprository;

    @Mock
    private StoreReprository store;


    @InjectMocks
    private  Product_Service service;

    @BeforeTest
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testAddProduct_ToStore_emptyinput() throws Exception {
        Product p = new Product("","","",0,0,0,0);
        assertEquals(service.AddProduct_ToStore(p),"storeAddProduct");
    }
    @Test
    public void testAddProduct_ToStore_notexistigProduct() throws Exception {
        Product p = new Product("p","id","type",2,2,0,0);
        java.util.Optional<Product>op = java.util.Optional.of(p);

        Mockito.when(reprository.findById(p.getStore_ID())).thenReturn(op);
        Mockito.when(op.isPresent()).thenReturn(true);
        Mockito.when(store.existsById(p.getStore_ID())).thenReturn(true);
        Mockito.when(reprository.save(p)).thenReturn(p);
        assertEquals(service.AddProduct_ToStore(p),"storeOwner_page");
    }


    @Test
    public void testEditProduct_ToStore_empty() throws Exception {
        Product p = new Product("","","",0,0,0,0);
        assertEquals(service.EditProduct_ToStore(p),"storeEditProduct");
    }
    @Test
    public void testEditProduct_ToStore() throws Exception {
        Product p = new Product("p","store","type",10,5,0,0);

        Mockito.when(reprository.save(p)).thenReturn(p);
        assertEquals(service.EditProduct_ToStore(p),"storeEditProduct");
    }
    @Test
    public void testDeleteProduct_ToStore() throws Exception {
        Product p = new Product("","store","type",10,5,0,0);
        assertEquals(service.DeleteProduct_ToStore(p),"storeDeleteProduct");
    }

  /*  @Test
    public void testBuy_Product() throws Exception {
    }

    @Test
    public void testViewStatistic() throws Exception {
    }

    @Test
    public void testUndoAction2() throws Exception {
    }*/
}