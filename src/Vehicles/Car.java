package Vehicles;

import graphics.CityPanel;

public class Car extends HasEngine {
	
	
	private final static int speed = 4;
	private typeOfEngine engineType;
	private int Durability;
	public Car(int numOfPassengers, CarColor color, typeOfEngine type, CityPanel pan) {

		super(color, numOfPassengers, pan);
		this.Durability=150;
		setNumOfPassengers(5);
		setnumOfWheels(4);
		this.setEngineType(type);
		if (engineType == typeOfEngine.BENZINE) {
			this.setEngine(new BenzineEngine());
		}
		if (engineType == typeOfEngine.SOLAR) {
			this.setEngine(new SolarEngine());
		}
		this.getEngine().setCapacity(40);

	}

	/**
	 * typeOfEngine function.
	 * 
	 * @return engineType
	 */
	public typeOfEngine getEngineType() {

		return engineType;
	}

	/**
	 * setEngineType function.
	 * 
	 * @param type type of the engine.
	 * @return true
	 */
	public boolean setEngineType(typeOfEngine type) {

		this.engineType = type;
		return true;
	}

	@Override
	public String toString() {
		return "Car [engineType=" + name + ", numOfWheels=" + wheels + ", color=" + color + ", location=" + location
				+ ", km=" + km + ", lights=" + lights + ", id=" + CarID + ", wheels=" + wheels + ", numOfPassengers="
				+ numOfPassengers + "]";
	}

	/**
	 * CalculateKM function.
	 * 
	 * @param point point of the car
	 * @return the calculate
	 */
	public int CalculateKM(Point point) {

		return Math.abs(this.getLocation().getPoint().getX() - point.getX())
				+ Math.abs(this.getLocation().getPoint().getY() - point.getY());
	}

	@Override
	public boolean drive(Point point) {

		if (this.getFuel() <= 0) {

			return false;
		}
		this.setKm(this.getKm() + CalculateKM(point));
		if (this.getEngineType() == typeOfEngine.SOLAR) {
			this.setFuel((int) Math.max(this.getFuel() - (CalculateKM(point) * 1), 0));

		}
		if (this.getEngineType() == typeOfEngine.BENZINE) {
			this.setFuel((int) Math.max(this.getFuel() - (CalculateKM(point) * 2), 0));
		}
		this.getLocation().setPoint(point);
		return true;
	}

	public int getSpeed() {

		return speed;
	}

	@Override
	public String getVehicleName() {
		// TODO Auto-generated method stub
		return this.engineType.name();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public int getFuelConsumption() {
		return 0;
	}

	@Override
	public boolean applyRefual() {
		this.Refuel();
		return true;
	}

	@Override
	public int energy() {
		return getFuel();
	}

	@Override
	public int getDurability() {
		// TODO Auto-generated method stub
		return Durability;
	}

}
