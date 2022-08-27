package com.aaguirre.di.quialifiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Nest {

	
	private static final Logger log = LoggerFactory.getLogger(Nest.class);

	
	@Autowired
	private Animal animal;
	
	public void print() {
		log.info("Nest has animal " + animal.getName());
	}
}
