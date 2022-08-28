package com.aaguirre.di.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(true) //If lazy only initalize at use
				//Default singleton is eager, prototype is lazy
public class LifeCycleBean implements BeanNameAware, InitializingBean, DisposableBean{

	
	private static final Logger log = LoggerFactory.getLogger(LifeCycleBean.class);

	
	//On bean construcion
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
	public void destroyBean() {
		log.info("Pre destroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("After properties set method");
	}

	@Override
	public void destroy() throws Exception {
		log.info("Destroy method");
	}

}
