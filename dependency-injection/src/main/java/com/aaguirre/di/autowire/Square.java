package com.aaguirre.di.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Square implements Figure{

	@Value("${circle.radius:1}")
	private Double side;
	
	@Override
	public double calculateArea() {
		return side * side;
	}

}
