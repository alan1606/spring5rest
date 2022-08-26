package com.aaguirre.di.setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Engine3 {

	private String brand;

	private Integer modelo;

	public Engine3() {
	}

	public String getBrand() {
		return brand;
	}

	@Value("XL2")
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getModelo() {
		return modelo;
	}

	@Value("1982")
	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Engine [brand=" + brand + ", modelo=" + modelo + "]";
	}

}
