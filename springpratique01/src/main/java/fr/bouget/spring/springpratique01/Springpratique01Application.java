package fr.bouget.spring.springpratique01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"fr.bouget.spring.springpratique01"})
public class Springpratique01Application {

	public static void main(String[] args) {
		SpringApplication.run(Springpratique01Application.class, args);
	}

}
