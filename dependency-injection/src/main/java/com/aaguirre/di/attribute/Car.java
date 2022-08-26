package com.aaguirre.di.attribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {

	@Value("VW")
	private String brand;
	
	@Value("1981")
	private Integer model;
	
	@Autowired
	private Engine engine;
	
	public Car() {}
	
	public Car(String brand, Integer model, Engine engine) {
 		this.brand = brand;
		this.model = model;
		this.engine = engine;
	}

	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public Integer getModel() {
		return model;
	}
	
	public void setModel(Integer model) {
		this.model = model;
	}
	
	public Engine getEngine() {
		return engine;
	}
	
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", model=" + model + ", engine=" + engine + "]";
	}
	
	
}
