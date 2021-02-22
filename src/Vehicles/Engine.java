package Vehicles;

/**
 * class Engine.
 * @author Yoav Yung id:203127329 ,Lidor zaguri id:205622814.
 */
public abstract class Engine {
	private int FuelPerKM;
	private int Capacity;
	
	

	/**
	 * getFuelPerKM
	 * @return a fuelPerKm.
	 */
	public int getFuelPerKM() {
		
		
		return FuelPerKM;
	}

	/**
	 * getCapacity function.
	 * @return Capacity.
	 */
	public int getCapacity() {
		
		
		return Capacity;
	}

	/**
	 * setFuelPerKM function.
	 * @param num
	 * @return FuelPerKM
	 */
	protected boolean setFuelPerKM(int num) {
		
		
		this.FuelPerKM = num;
		return true;
	}

	/**
	 * setCapacity function.
	 * @param num
	 * @return true.
	 */
	protected boolean setCapacity(int num) {
		
		
		this.Capacity = num;
		return true;
	}

	public String toString() {
		return "\nEngine Fuel per KM : " + FuelPerKM + "\nEngine Capacity : " + Capacity;
	}
}
