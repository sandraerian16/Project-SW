package com.example.demo.Service;

import com.example.demo.Entity.Actions;
import com.example.demo.Entity.Store;
import com.example.demo.Repository.ActionsRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import static org.testng.Assert.*;

public class Actions_ServiceTest {

    @Mock
    private ActionsRepository repository;
    @Mock
    private Model model;
    @InjectMocks
    private  Actions_Service service;

    @BeforeTest
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testStoreActions_succ() throws Exception {
        Actions actions1=new Actions("type1","name1","id","p_type1",10,2);
        Actions actions2=new Actions("type2","name2","id","p_type2",20,3);
       Store store=new Store("id","sdfg","dg","gsd","","dfgs");
        ArrayList<Actions>s = new ArrayList<>();
        s.add(actions1); s.add(actions2);
        Mockito.when(repository.findAll()).thenReturn(s);
        assertEquals( service.storeActions(model,store),"viewActions");
    }
}