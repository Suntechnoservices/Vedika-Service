package com.vedika.functionhall;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.vedika.functionhall.controller.OwnerController;


@SpringBootApplication

public class FunctionhallServiceApplication {
	
	 private static Logger logger = LoggerFactory.getLogger(OwnerController.class);

	public static void main(String[] args) {
		SpringApplication.run(FunctionhallServiceApplication.class, args);
		
		
	}

}
