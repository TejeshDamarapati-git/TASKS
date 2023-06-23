package com.mayuratech.program;

public class Bicycle extends Vehicle {
	
	public Bicycle(String color, int wheels) {
		super(color, wheels);
	}

	@Override
	public void runBy() {
		System.out.println("Bicycle doesnt require fuel");
	}

	@Override
	public void engine() {
		System.out.println("Bicycle runs human force by pendling ..");
	}

	

}
