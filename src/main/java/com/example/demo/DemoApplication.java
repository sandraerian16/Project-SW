package com.example.demo;

import com.example.demo.Entity.Platform;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.Store;
import com.example.demo.Entity.User;
import com.example.demo.Repository.PlatformRepritory;
import com.example.demo.Repository.ProductReprository;
import com.example.demo.Repository.StoreReprository;
import com.example.demo.Repository.UserReprository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserReprository user, StoreReprository store, PlatformRepritory platform,ProductReprository product){
		return args -> {
			user.save(new User("sandra","123"
					,"sandra","sadndra"
					,"sa","Administrator",0));
			user.save(new User("jan","1234"
					,"jan","sad","maadi"
					,"StoreOwner",1000));

			user.save(new User("elain","12345"
					,"elain","sads","maadi"
					,"NormalUser",1500));

			Store s = new Store("store1","fs","dasd","dfs","","jan");
			s.setApproved(true);
			store.save(s);
			platform.save(new Platform("p1","f",2,"h",10));
			platform.save(new Platform("p2","f",1,"h",15));

			product.save(new Product("p1","store1","hj",5,2,0,0));
			platform.save(new Platform("p5","brada",50,"bag",120));
		//	product.save(new Product("p5","store1","bag",10,100,0,0));
		};
	}


}
