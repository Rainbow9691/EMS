package com.dcl.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
//		1. it creates the spring bean container and keeps it ready for the use.
//		2. it propogates the control to the Application class considering it as
//		   the configuration class 
//		3. it also reads all the configuration details from the config file.
		
		
	}

}
