package br.com.amadeus.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class OrderApplication {

	public static final Logger LOGGER = LogManager.getLogger(OrderApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

}
