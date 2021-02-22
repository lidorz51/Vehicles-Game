package Vehicles;

import graphics.CityPanel;

public abstract class HasEngine extends Vehicle {
	private Engine engine;
	private int fuel;
	

	public HasEngine( CarColor color,int numOfPassengers,CityPanel pan) {		
		super(numOfPassengers,color, pan);
	}
	

	/**
	 * getEngine function.
	 * @return engine
	 */
	public Engine getEngine() {
		
		
		return engine;
	}

	/**
	 * getFuel function.
	 * @return fuel
	 */
	public int getFuel() {
		
		
		return fuel;
	}


	/**
	 * setEngine function.
	 * @param engine the engine.
	 * @return true
	 */
	protected boolean setEngine(Engine engine) {
		
		
		this.engine = engine;
		return true;
	}

	/**
	 * setFuel function.
	 * @param num number of fuel less.
	 * @return fuel
	 */
	protected boolean setFuel(int num) {
		
		
		
		this.fuel = num;
		return true;
	}



	/**
	 * Refuel function
	 * @return true or false
	 */
	public boolean Refuel() {
		
		
		if (fuel != engine.getCapacity()) {
			fuel = engine.getCapacity();
			return true;
		}
		return false;
	}
}
