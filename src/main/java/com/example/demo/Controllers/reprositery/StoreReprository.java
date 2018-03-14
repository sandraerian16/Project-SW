package com.example.demo.Controllers.reprositery;

import com.example.demo.Controllers.Entity.Store;
import org.springframework.data.repository.CrudRepository;

public interface StoreReprository extends CrudRepository<Store,String> {
}
