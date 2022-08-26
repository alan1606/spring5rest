package com.aaguirre.di.attribute;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Engine {
	
	@Value("XL2")
	private String brand;
	
	@Value("1982")
	private Integer modelo;

	
	public Engine() {}

	
	public Engine(String brand, Integer modelo) {
		this.brand = brand;
		this.modelo = modelo;
	}



	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public Integer getModelo() {
		return modelo;
	}


	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}


	@Override
	public String toString() {
		return "Engine [brand=" + brand + ", modelo=" + modelo + "]";
	}
	
	
	
	
}
