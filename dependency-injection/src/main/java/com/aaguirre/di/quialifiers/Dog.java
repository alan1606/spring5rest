package com.aaguirre.di.quialifiers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dog extends Animal{

	public Dog(@Value("Rocky") String name, @Value("1") Integer age) {
		super(name, age);
	}

	

}
