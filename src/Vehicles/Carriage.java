package Vehicles;


import graphics.CityPanel;

public class Carriage extends Vehicle  {
	private String vehiclesCollisoinCarriage;
	private static int speed = 1;
	private PackAnimal animal; 
	
/**
 * constructor of carriage.
 * @param color the color of the carriage.
 * @param numOfPassengers the number of the passenger.
 */
	public Carriage(CarColor color,int numOfPassengers,CityPanel city) {
		
		
		super(numOfPassengers,color,city);
		this.Durability=50;
		setNumOfPassengers(2);
		setnumOfWheels(4);
		this.animal = new PackAnimal();

	}

	/**
	 * getAnimal function.
	 * @return animal
	 */
	public PackAnimal getAnimal() {
		
		
		return animal;
	}

	/**
	 * setAnimal function
	 * @param animal the object animal.
	 * @return true
	 */
	public boolean setAnimal(PackAnimal animal) {
		
		
		this.animal = animal;
		return true;
	}
	
	
	@Override
	public boolean drive(Point point) {

		this.animal.setEnergy(Math.max(this.animal.getEnergy()-20,0));
		if(animal.getEnergy()<=0)
		{
			return false;
		}
		this.setKm(this.getKm() + Math.abs(this.getLocation().getPoint().getX() - point.getX())
				+ Math.abs(this.getLocation().getPoint().getY() - point.getY()));
		this.getLocation().setPoint(point);
		return true;
	}

	@Override
	public String toString() {
		return "Carriage [animal=" + animal + ", numOfWheels=" + numOfWheels + ", color=" + color + ", location="
				+ location + ", km=" + km + ", lights=" + lights + ", size=" + size + ", id=" + id + ", wheels="
				+ wheels + ", loc=" + loc + ", fuelConsumption=" + fuelConsumption + ", pan=" + pan + ", img1=" + img1
				+ ", img2=" + img2 + ", img3=" + img3 + ", img4=" + img4 + ", numOfPassengers=" + numOfPassengers + "]";
	}

	
	public int getSpeed() {
		
		
		return speed;
	}

	@Override
	public String getVehicleName() {
		// TODO Auto-generated method stub
		return "Carriage";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public int getFuelConsumption() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean applyRefual() {
		this.animal.eat();
		return false;
	}

	@Override
	public int energy() {
		return animal.getEnergy();
		
	}

	@Override
	public int getDurability() {
		// TODO Auto-generated method stub
		return Durability;
	}

}
