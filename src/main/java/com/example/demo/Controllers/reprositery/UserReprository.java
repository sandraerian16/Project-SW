package com.example.demo.Controllers.reprositery;

import com.example.demo.Controllers.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserReprository extends CrudRepository<User,String>{
}
