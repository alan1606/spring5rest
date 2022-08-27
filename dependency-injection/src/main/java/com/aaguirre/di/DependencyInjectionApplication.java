package com.aaguirre.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.aaguirre.di.autowire.AreaCalculatorService;



@SpringBootApplication
public class DependencyInjectionApplication {

	
	private static final Logger log = LoggerFactory.getLogger(DependencyInjectionApplication.class);

	@Bean
	public String getApplicationName() {
		return "My app";
	}
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);
		AreaCalculatorService calculator = context.getBean(AreaCalculatorService.class);

		log.info("Total area = {}", calculator.calcAreas());

	}

}
