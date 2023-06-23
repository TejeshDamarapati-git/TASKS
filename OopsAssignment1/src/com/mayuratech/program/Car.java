package com.mayuratech.program;

public class Car extends Vehicle {
	public Car(String color, int wheels) {
		super(color, wheels);
	}

	@Override
	public void runBy() {
		System.out.println("Car is runBy Petrol or Diesel");
	}

	@Override
	public void engine() {
		System.out.println("Car contains Petrol or Diesel Engine");
	}


}
