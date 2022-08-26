package com.aaguirre.di.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car3 {

	private String brand;

	private Integer model;

	private Engine3 engine;

	public Car3() {
	}


	public String getBrand() {
		return brand;
	}

	@Value("VW")
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getModel() {
		return model;
	}

	@Value("1981")
	public void setModel(Integer model) {
		this.model = model;
	}

	public Engine3 getEngine() {
		return engine;
	}

	@Autowired
	public void setEngine(Engine3 engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", model=" + model + ", engine=" + engine + "]";
	}

}
