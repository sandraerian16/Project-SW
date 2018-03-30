package com.example.demo.Repository;

import com.example.demo.Entity.Store;
import org.springframework.data.repository.CrudRepository;

public interface StoreReprository extends CrudRepository<Store,String> {
}
