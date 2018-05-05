package com.example.demo.Service;

import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class Product_ServiceTest {
    @Mock
    private ProductReprository reprository;

    @Mock
    private StoreReprository store;

    @Mock
    private ActionsRepository Actions_RB;
    @Mock
    private PlatformRepritory plat;

    @Mock
    private UserReprository use;

    @Mock
    private HttpServletRequest request;

    @Mock
    private Model model;
    @InjectMocks
    private Product_Service service;

    @BeforeTest
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddProduct_ToStore_emptyinput() throws Exception {
        Product p = new Product("", "", "", 0, 0, 0, 0);
        assertEquals(service.AddProduct_ToStore(model, p), "storeAddProduct");
    }

    @Test
    public void testAddProduct_ToStore_existigProduct() throws Exception {
        Platform platform = new Platform("p", "brand", 2, "cat", 10);
        Product p = new Product("p", "id", "type", 2, 5, 0, 0);
        Actions A1 = new Actions("ADD", p.getName(), p.getStore_ID(), p.getProduct_type(), p.getQuntity(), p.getPrice());
        Mockito.when(plat.findById(p.getName())).thenReturn(java.util.Optional.ofNullable(platform));
        Mockito.when(store.existsById(p.getStore_ID())).thenReturn(true);
        Mockito.when(reprository.save(p)).thenReturn(p);
        Mockito.when(Actions_RB.save(A1)).thenReturn(A1);
        assertEquals(service.AddProduct_ToStore(model, p), "storeOwner_page");
    }

    @Test
    public void testAddProduct_ToStore_nonexistigStore() throws Exception {
        Platform platform = new Platform("p", "brand", 2, "cat", 10);
        Product p = new Product("p", "id", "type", 2, 5, 0, 0);
        Actions A1 = new Actions("ADD", p.getName(), p.getStore_ID(), p.getProduct_type(), p.getQuntity(), p.getPrice());
        Mockito.when(plat.findById(p.getName())).thenReturn(java.util.Optional.ofNullable(platform));
        Mockito.when(store.existsById(p.getStore_ID())).thenReturn(false);
        Mockito.when(reprository.save(p)).thenReturn(p);
        Mockito.when(Actions_RB.save(A1)).thenReturn(A1);
        assertEquals(service.AddProduct_ToStore(model, p), "storeAddProduct");
    }

    @Test
    public void testEditProduct_ToStore_empty() throws Exception {
        Product p = new Product("", "", "", 0, 0, 0, 0);
        assertEquals(service.EditProduct_ToStore(model, p), "storeEditProduct");
    }

    @Test
    public void testEditProduct_ToStore() throws Exception {
        Platform platform = new Platform("p", "brand", 2, "cat", 10);
        Product p = new Product("p", "id", "type", 2, 5, 0, 0);
        Actions A1 = new Actions("ADD", p.getName(), p.getStore_ID(), p.getProduct_type(), p.getQuntity(), p.getPrice());
        Mockito.when(plat.findById(p.getName())).thenReturn(java.util.Optional.ofNullable(platform));
        Mockito.when(reprository.findById(p.getName())).thenReturn(java.util.Optional.ofNullable(p));
        Mockito.when(reprository.save(p)).thenReturn(p);
        Mockito.when(Actions_RB.save(A1)).thenReturn(A1);
        assertEquals(service.EditProduct_ToStore(model, p), "storeOwner_page");
    }

    @Test
    public void testEditProduct_ToStore_noproduct() throws Exception {
        Platform platform = new Platform("p", "brand", 2, "cat", 10);
        Product p = new Product("p", "id", "type", 2, 5, 0, 0);
        Actions A1 = new Actions("ADD", p.getName(), p.getStore_ID(), p.getProduct_type(), p.getQuntity(), p.getPrice());
        Mockito.when(reprository.save(p)).thenReturn(p);
        Mockito.when(Actions_RB.save(A1)).thenReturn(A1);
        assertEquals(service.EditProduct_ToStore(model, p), "storeEditProduct");
    }

    @Test
    public void testEditProduct_ToStore_productPrice() throws Exception {
        Platform platform = new Platform("p", "brand", 2, "cat", 10);
        Product p = new Product("p", "id", "type", 2, 40, 0, 0);
        Actions A1 = new Actions("ADD", p.getName(), p.getStore_ID(), p.getProduct_type(), p.getQuntity(), p.getPrice());
        Mockito.when(plat.findById(p.getName())).thenReturn(java.util.Optional.ofNullable(platform));
        Mockito.when(reprository.findById(p.getName())).thenReturn(java.util.Optional.ofNullable(p));
        Mockito.when(reprository.save(p)).thenReturn(p);
        Mockito.when(Actions_RB.save(A1)).thenReturn(A1);
        assertEquals(service.EditProduct_ToStore(model, p), "storeEditProduct");
    }

    @Test
    public void testDeleteProduct_ToStore_empty() throws Exception {
        Product p = new Product("", "store", "type", 10, 5, 0, 0);
        assertEquals(service.DeleteProduct_ToStore(model, p), "storeDeleteProduct");
    }

    @Test
    public void testDeleteProduct_ToStore() throws Exception {
        Product p = new Product("p", "store", "type", 10, 5, 0, 0);
        Actions A1 = new Actions("DELETE", p.getName(), p.getStore_ID(), p.getProduct_type(), p.getQuntity(), p.getPrice());

        Mockito.when(reprository.findById(p.getName())).thenReturn(java.util.Optional.ofNullable(p));
        Mockito.when(reprository.existsById(p.getName())).thenReturn(true);
        Mockito.when(Actions_RB.save(A1)).thenReturn(A1);
        assertEquals(service.DeleteProduct_ToStore(model, p), "storeOwner_page");
    }
   @Test
    public void testBuy_Product() throws Exception {
        temp t = new temp(3,"asd","name",true);
        Product p = new Product("p", "store", "type", 10, 5, 0, 0);
        User user = new User("name","pass","email","sd","asd","NormalUser",100);
        Mockito.when(reprository.findById(t.getName())).thenReturn(java.util.Optional.ofNullable(p));
        Mockito.when(use.findById("name")).thenReturn(java.util.Optional.ofNullable(user));
        Mockito.when(use.save(user)).thenReturn(user);
        Mockito.when( reprository.save(p)).thenReturn(p);
        assertEquals(service.Buy_Product(model,t,request),"NormalUserPage");

    }

    @Test
    public void testViewStatistic() throws Exception {
        User user = new User("name", "pass", "email", "sd", "asd", "StoreOwner", 100);

        Mockito.when(use.existsById("name")).thenReturn(true);
        Mockito.when(use.findById("name")).thenReturn(java.util.Optional.ofNullable(user));
        Store store1 = new Store("store", "store_address", "store_telephone", "type", "location ", "name");
        store1.setApproved(true);
        ArrayList<Store> arr = new ArrayList<>();
        arr.add(store1);
        Mockito.when(store.findAll()).thenReturn(arr);
        Product p1 = new Product("p1", "store", "type", 10, 5, 0, 0);
        Product p2 = new Product("p2", "store", "type", 10, 5, 0, 0);
        ArrayList<Product> sf = new ArrayList<>();
        sf.add(p1);
        sf.add(p2);
        Mockito.when(reprository.findAll()).thenReturn(sf);
        assertEquals(service.viewStatistic(request), sf);

    }

    @Test
    public void testViewStatistic_nostores() throws Exception {
        User user = new User("name", "pass", "email", "sd", "asd", "StoreOwner", 100);
        Mockito.when(use.existsById("name")).thenReturn(true);
        Mockito.when(use.findById("name")).thenReturn(java.util.Optional.ofNullable(user));
        ArrayList<Store> arr = new ArrayList<>();
        Mockito.when(store.findAll()).thenReturn(arr);
        ArrayList<Product> sf = new ArrayList<>();
        Mockito.when(reprository.findAll()).thenReturn(sf);
        assertEquals(service.viewStatistic(request), sf);

    }


    @Test
    public void testUndoAction2_ADD() throws Exception {
        Actions A1 = new Actions("ADD", "name", "store", "type", 10, 5);
        Mockito.when(Actions_RB.findById(A1.getID())).thenReturn(java.util.Optional.ofNullable(A1));
        assertEquals(service.UndoAction2(model, A1), "storeOwner_page");

    }

    @Test
    public void testUndoAction2_Edit() throws Exception {
        Actions action = new Actions("ADD", "EDIT", "store", "type", 10, 5);
        Product product = new Product(action.getProductName(), action.getStoreID(), action.getProduct_type()
                , action.getProduct_quntity(), action.getProduct_price(), 0, 0);
        Mockito.when(reprository.save(product)).thenReturn(product);
        Mockito.when(Actions_RB.findById(action.getID())).thenReturn(java.util.Optional.ofNullable(action));
        assertEquals(service.UndoAction2(model, action), "storeOwner_page");

    }

    @Test
    public void testUndoAction2_Delete() throws Exception {
        Actions action = new Actions("DELETE", "EDIT", "store", "type", 10, 5);
        Product product = new Product(action.getProductName(), action.getStoreID(), action.getProduct_type()
                , action.getProduct_quntity(), action.getProduct_price(), 0, 0);
        Mockito.when(reprository.save(product)).thenReturn(product);
        assertEquals(service.UndoAction2(model, action), "storeOwner_page");

    }

}