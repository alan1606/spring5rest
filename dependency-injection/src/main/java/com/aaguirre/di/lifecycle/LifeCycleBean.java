package com.aaguirre.di.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleBean implements BeanNameAware{

	
	private static final Logger log = LoggerFactory.getLogger(LifeCycleBean.class);

	
	@Override
	public void setBeanName(String name) {
		log.info("Bean name {}", name);
	}
	
	@PostConstruct
	//Cannot receive arguments
	//Executes after di
	public void init() {
		log.info("Post construct");
	}
	
	@PreDestroy
	//No execution at prototype
	public void destroy() {
		log.info("Pre destroy");
	}

}
