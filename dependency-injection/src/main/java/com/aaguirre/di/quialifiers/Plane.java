package com.aaguirre.di.quialifiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Plane implements Flying {

	private static final Logger log = LoggerFactory.getLogger(Plane.class);

	@Override
	public void fly() {
		log.info("I am a plane and i am flying");
	}

}
