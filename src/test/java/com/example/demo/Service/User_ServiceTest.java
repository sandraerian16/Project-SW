package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserReprository;
import javafx.beans.binding.When;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Optional;

import static org.testng.Assert.*;


public class User_ServiceTest {
    @Mock
    private UserReprository reprository;
    @Mock
    private Model model;
    @Mock
    private HttpServletRequest request;

    @InjectMocks
    private  User_Service service;

    @BeforeTest
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testRegister_emptyinput() throws Exception {
        //User user = new User("name","pass","email","sd","asd","NormalUser",100);
        User user = new User("","","email","sd","asd","NormalUser",100);
        assertEquals(service.Register(model,user),"register");
    }
    @Test
    public void testRegister_newinput() throws Exception {
        User user = new User("name","pass","email","sd","asd","NormalUser",100);
        Mockito.when(reprository.existsById(user.getUser_name())).thenReturn(false);
        assertEquals(service.Register(model,user),"register");
    }
    @Test
    public void testRegister_existinginput() throws Exception {
        User user = new User("name","pass","email","sd","asd","NormalUser",100);
        Mockito.when(reprository.existsById(user.getUser_name())).thenReturn(true);
        assertEquals(service.Register(model,user),"register");
    }
    @Test
    public void testLogin_emptyinput() throws Exception {
        User user = new User("","","email","sd","asd","NormalUser",100);

        assertEquals(service.Login(model,user,request),"login");
    }

    @Test
    public void testLogout() throws Exception {
        service.logout(request);

    }
}