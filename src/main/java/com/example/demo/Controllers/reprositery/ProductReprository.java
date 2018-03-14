package com.example.demo.Controllers.reprositery;

import com.example.demo.Controllers.Entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductReprository extends CrudRepository<Product,String>{
}
