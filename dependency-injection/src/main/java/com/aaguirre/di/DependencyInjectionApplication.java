package com.aaguirre.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.aaguirre.di.profiles.EnvironmentService;
import com.aaguirre.di.quialifiers.Animal;
import com.aaguirre.di.quialifiers.Dog;
import com.aaguirre.di.quialifiers.Nest;
import com.aaguirre.di.scopes.ExampleScopeService;



@SpringBootApplication
public class DependencyInjectionApplication {

	
	private static final Logger log = LoggerFactory.getLogger(DependencyInjectionApplication.class);

	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);
		ExampleScopeService exampleScopeService = context.getBean(ExampleScopeService.class);
		ExampleScopeService exampleScopeService1 = context.getBean(ExampleScopeService.class);

		log.info("Are beans equal {}",exampleScopeService.equals(exampleScopeService1));
		log.info("Are beans == {}",exampleScopeService == exampleScopeService1);

	}

}
