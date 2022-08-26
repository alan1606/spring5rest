package com.aaguirre.di.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car2 {

	private String brand;

	private Integer model;

	private Engine2 engine;

	@Autowired
	public Car2(@Value("VW") String brand, @Value("1981") Integer model, Engine2 engine) {
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

	public Engine2 getEngine() {
		return engine;
	}

	public void setEngine(Engine2 engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", model=" + model + ", engine=" + engine + "]";
	}

}
