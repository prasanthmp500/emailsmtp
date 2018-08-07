package com.example.javamail.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner  {

	
	 @Autowired
     private ApplicationContext appContext;
	  
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	
	@Override
	public void run(String... args) throws Exception {
 
	EmailSender emailsender =	appContext.getBean(EmailSender.class);
	emailsender.sendEmail();
	}


}
