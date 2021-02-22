package graphics;

import java.awt.Rectangle;

import javax.swing.text.DefaultEditorKit.CutAction;

import Vehicles.Vehicle;

/**
 * An Threads to run in parallel.
 * 
 * @version 20.05 20 May 2019
 * @author Yoav Yung id:203127329 ,Lidor zaguri id:205622814.
 * @see CityPanel and Vehicle.  
 */
public class ThreadCity extends Thread {
	private Vehicle vehicle = null;
	private boolean running = true;

	ThreadCity(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * 
	 */
	@Override
	public void run() {
		while (running) {
			if (vehicle != null)
				try {
					Thread.sleep(100 / vehicle.getSpeed());
					if (vehicle.energy() == 0)
						Wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					break;
				}
			vehicle.move();
		}
	}

	public synchronized void Wait() throws InterruptedException {
		wait();
	}

	/**
	 * @return object of vehicle. 
	 */

	public Vehicle vehicle() {
		return vehicle;
	}

	/**
	 * Rectangle check the collision between two vehicles.
	 * 
	 * @return the the direction of the vehicles.
	 */
	public Rectangle getRectangle() {
		return vehicle.getRectangle();
	}

	/**
	 * getDurability get the durability of all the vehicles.
	 * 
	 * @return the Durability.
	 */
	public int getDurability() {
		return vehicle.getDurability();
	}
}
