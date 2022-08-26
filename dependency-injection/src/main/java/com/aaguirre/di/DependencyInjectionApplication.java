package com.aaguirre.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.aaguirre.di.attribute.Car;
import com.aaguirre.di.constructor.Car2;
import com.aaguirre.di.setter.Car3;


@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);
		Car3 car3 = context.getBean(Car3.class);
		
		System.out.println(car3);
	}

}
