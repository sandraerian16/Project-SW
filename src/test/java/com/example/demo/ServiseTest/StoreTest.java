package com.example.demo.ServiseTest;

import com.example.demo.Controllers.StoreController;
import com.example.demo.Entity.Store;
import com.example.demo.Entity.User;
import com.example.demo.Repository.StoreReprository;
import com.example.demo.Repository.UserReprository;
import com.example.demo.Service.Store_Service;
import org.hibernate.validator.constraints.ModCheck;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;

import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class StoreTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private StoreReprository storeReprository;
    @Mock
    private UserReprository userReprository;
    @Mock
    private Model model;
    @InjectMocks
    private Store_Service store_service;
    @BeforeTest
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

@Test
public void wrongAdd() {

    Store platform= new Store("store_name","store_address","store_telephone", "type", "location ", "Owner");

    assertEquals( store_service.AddStore( model, platform,request),"AddStore");
}
    @Test
    public void RigthAdd() {

        Store platform= new Store("store_name","store_address","store_telephone", "type", "location ", "Owner");

        assertEquals( store_service.AddStore( model, platform,request),"storeOwner_page");
    }
    @Test
    public void findinDB() {

        Store platform= new Store("store_name","store_address","store_telephone", "type", "location ", "Owner");

        assertEquals( storeReprository.existsById( platform.getStore_name()),true);
    }
    @Test
    public void Check_approve_true(){
        Store platform= new Store("store_name","store_address","store_telephone", "type", "location ", "Owner");
        Mockito.when(storeReprository.findById("store_name")).thenReturn(Optional.ofNullable(platform));
        assertEquals(store_service.Check_Approve(model,platform),"admin_face");
    }
    @Test
    public void Check_approve_false(){
        Store platform= new Store("store_name","store_address","store_telephone", "type", "location ", "Owner");
        Mockito.when(storeReprository.findById("store_name")).thenReturn(Optional.ofNullable(platform));
        assertEquals(store_service.Check_Approve(model,platform),"to_approve");
    }
  @Test
    public void addCollDBTest(){
      User user=new User(""," "," "," "," ","",300);
      assertEquals( storeReprository.existsById( user.getUser_name()),true);
  }
    @Test
    public void addCollFailTest(){
        User user=new User(""," "," "," "," ","",300);
        assertEquals( store_service.Add_Colla(model,user,request),"Add_Collaborators");
    }

}
