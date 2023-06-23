package com.mayuratech.execute;

import com.mayuratech.program.Bicycle;
import com.mayuratech.program.Bus;
import com.mayuratech.program.Car;
import com.mayuratech.program.Vehicle;

public class Test {

	public static void main(String[] args) {

		Vehicle vehicle1 = new Car("Black", 4);
		vehicle1.engine();
		vehicle1.runBy();
		System.out.println("Car color : "+vehicle1.color);
		System.out.println("No of wheels : "+vehicle1.wheels);
		
		System.out.println("************************");
		
		Vehicle vehicle2  = new Bus("Yellow color", 6);
		vehicle2.engine();
		vehicle2.runBy();
		System.out.println("Bus color : "+vehicle2.color);
		System.out.println("No of wheels : "+vehicle2.wheels);
		
		System.out.println("************************");
		
		Vehicle vehicle3 = new Bicycle("Red", 2);
		vehicle3.engine();
		vehicle3.runBy();	
		System.out.println("Bicycle color : "+vehicle3.color);
		System.out.println("No of wheels : "+vehicle3.wheels);
	
	}

}
