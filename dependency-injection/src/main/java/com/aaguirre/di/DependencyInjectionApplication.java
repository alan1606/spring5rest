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
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.aaguirre.di.autowire.AreaCalculatorService;



@SpringBootApplication
public class DependencyInjectionApplication {

	
	private static final Logger log = LoggerFactory.getLogger(DependencyInjectionApplication.class);

	@Bean
	public String getApplicationName() {
		return "My app";
	}
	
	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("10 + 20");
		log.info("Result {}", expression.getValue());
	}

}
