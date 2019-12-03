package fr.bouget.spring.message.springdemo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import fr.bouget.spring.message.springdemo01.bean.MessageBean;

@SpringBootApplication
@ComponentScan(basePackages = {"fr.bouget.spring.message.springdemo01"})
public class Springdemo01Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Springdemo01Application.class, args);
		MessageBean monObjetMessage = (MessageBean) context.getBean("messageBean");
		monObjetMessage.message();
		monObjetMessage.message("C'est facile SpringBoot !");
	}

}
