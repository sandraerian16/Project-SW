package com.example.demo;

import com.example.demo.Controllers.Entity.Product;
import com.example.demo.Controllers.reprositery.prroductRepristory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	/*@Bean
	CommandLineRunner runner(prroductRepristory reprositery){
		return args -> {
			reprositery.save(new Product("jack", (float) 12.5, "htc", "jkdfhkjbdsf", 10, "jjsdvhg"));

		};
	}*/

}
