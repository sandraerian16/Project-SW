package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserReprository;
import javafx.beans.binding.When;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Optional;

import static org.springframework.test.web.ModelAndViewAssert.assertViewName;
import static org.testng.Assert.*;
import static reactor.core.publisher.Mono.when;


public class User_ServiceTest {
    @Mock
    private UserReprository reprository;
    @Mock
    private Model model;
    @Mock
    private HttpServletRequest request;

    @InjectMocks
    private User_Service service;

    @BeforeTest
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegister_emptyinput() throws Exception {
        User user = new User("", "", "email", "sd", "asd", "NormalUser", 100);
        assertEquals(service.Register(model, user), "register");
    }

    @Test
    public void testRegister_newinput() throws Exception {
        User user = new User("name", "pass", "email", "sd", "asd", "NormalUser", 100);
        Mockito.when(reprository.existsById(user.getUser_name())).thenReturn(false);
        assertEquals(service.Register(model, user), "login");
    }

    @Test
    public void testRegister_existinginput() throws Exception {
        User user = new User("name", "pass", "email", "sd", "asd", "NormalUser", 100);
        Mockito.when(reprository.existsById(user.getUser_name())).thenReturn(true);
        assertEquals(service.Register(model, user), "register");
    }

    @Test
    public void testLogin_emptyinput() throws Exception {
        User user = new User("", "", "email", "sd", "asd", "NormalUser", 100);
        assertViewName(service.Login(model, user, request), "login");

    }

    @Test
    public void testLogin_input_Admin() throws Exception {
        User user = new User("name", "pass", "email", "sd", "asd", "Administrator", 100);
        Mockito.when(reprository.findById("name")).thenReturn(Optional.ofNullable(user));
        assertViewName(service.Login(model, user, request), "admin_face");

    }

    @Test
    public void testLogin_input_NormalUser() throws Exception {
        User user = new User("name", "pass", "email", "sd", "asd", "NormalUser", 100);
        Mockito.when(reprository.findById("name")).thenReturn(Optional.ofNullable(user));
        assertViewName(service.Login(model, user, request), "NormalUserPage");
    }

    @Test
    public void testLogin_input_StoreOwner() throws Exception {
        User user = new User("name", "pass", "email", "sd", "asd", "StoreOwner", 100);
        Mockito.when(reprository.findById("name")).thenReturn(Optional.ofNullable(user));
        assertViewName(service.Login(model, user, request), "storeOwner_page");
    }

    @Test
    public void testLogin_input_Coll() throws Exception {
        User user = new User("name", "pass", "email", "sd", "asd", "Collaborators", 100);
        Mockito.when(reprository.findById("name")).thenReturn(Optional.ofNullable(user));
        assertViewName(service.Login(model, user, request), "collaborators_Page");
    }

    @Test
    public void testLogout() throws Exception {
        assertEquals(service.logout(request), "logged out");

    }

}