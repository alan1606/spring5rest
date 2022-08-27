package com.aaguirre.di.quialifiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myBird")
public class Bird extends Animal implements Flying {

	private static final Logger log = LoggerFactory.getLogger(Bird.class);

	public Bird(@Value("Crazy") String name, @Value("1") Integer age) {
		super(name, age);
	}

	@Override
	public void fly() {
		log.info("I am a bird and iam flying");
	}

}
