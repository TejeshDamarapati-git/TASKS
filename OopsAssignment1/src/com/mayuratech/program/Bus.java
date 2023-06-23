package com.mayuratech.program;

public class Bus extends Vehicle {

	public Bus(String color, int wheels) {
		super(color, wheels);
	}

	@Override
	public void runBy() {
		System.out.println("Bus is runBy Diesel");
	}

	@Override
	public void engine() {
		System.out.println("Bus contains Diesel Engine");
	}


}
