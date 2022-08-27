package com.aaguirre.di.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Figure {

	@Value("${square.side}")
	private Double radious;

	@Override
	public double calculateArea() {
		return Math.PI * Math.pow(radious, 2);
	}

}
