package Vehicles;

import graphics.CityPanel;

public class Bike extends Vehicle {
	private String vehiclesCollisoinCar;
	private static int speed = 2;
	private int numOfGears;
	/**
	 * constructor of Bike.
	 * @param color the color of the Bike.
	 * @param numOfGears the number of gear. 
	 */
	public Bike(CarColor color, int numOfGears,CityPanel pan) {
		super(numOfGears, color, pan);
		this.Durability=25;
		setNumOfPassengers(1);
		setnumOfWheels(2);
		
		this.numOfGears = numOfGears;
	}

	@Override
	public String toString() {
		return "Bike [numOfGears=" + numOfGears + ", numOfWheels=" + numOfWheels + ", color=" + color + ", location="
				+ location + ", km=" + km + ", lights=" + lights + ", size=" + size + ", id=" + id + ", wheels="
				+ wheels + ", loc=" + loc + ", fuelConsumption=" + fuelConsumption + ", pan=" + pan + ", img1=" + img1
				+ ", img2=" + img2 + ", img3=" + img3 + ", img4=" + img4 + ", numOfPassengers=" + numOfPassengers + "]";
	}

	@Override
	public boolean drive(Point point) 
	{
		this.setKm(this.getKm() + Math.abs(this.getLocation().getPoint().getX() - point.getX())
		+ Math.abs(this.getLocation().getPoint().getY() - point.getY()));
		this.getLocation().setPoint(point);
		return true;	
	}
	
	/**
	 * getnumOfGears function.
	 * @return numOfGears
	 */
	public int getnumOfGears() {
		
		
		return numOfGears;
	}

	/**
	 * setnumOfGears function.
	 * @param num the number of gear.
	 * @return true.
	 */
	public boolean setnumOfGears(int num) {
		
		
		this.numOfGears = num;
		return true;
	}
	
	/**
	 * getSpeed function. 
	 */
	public int getSpeed() {
		
		
		return speed;
	}

	@Override
	public String getVehicleName() {
		// TODO Auto-generated method stub
		return "Bike";
	}

	@Override
	public int getFuelConsumption() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	@Override
	public boolean applyRefual() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int energy() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getDurability() {
		// TODO Auto-generated method stub
		return Durability;
	}
	
}
