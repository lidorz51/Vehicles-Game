package Vehicles;

import graphics.IAnimal;
import graphics.ICloneabel;

public class PackAnimal implements IAnimal,ICloneabel {
	private String Name;
	private int MaxEnergy;
	private int Energy;
	private int lessEnergy;
/*
 * 
 */
	public PackAnimal() {
		this.Name = "PackAnimal";
		this.MaxEnergy =1000;
		this.eat();
	}
/*
 * 
 */
	public int getEnergy() {
		return Energy;
	}
/*
 * 
 */
	public void setEnergy(int energy) {
		Energy = energy;
	}
/*
 * (non-Javadoc)
 * @see graphics.IMoveable#move(Vehicles.Point)
 */
	public boolean move(Point p) {
		Energy-=20;

		return true;
	}
/*
 * (non-Javadoc)
 * @see graphics.IAnimal#getAnimalName()
 */
	@Override
	public String getAnimalName() {
		return Name;
	}
/*
 * 
 */
	public int getMaxEnergy() {
		return MaxEnergy;
	}
/*
 * (non-Javadoc)
 * @see graphics.IAnimal#eat()
 */
	@Override
	public boolean eat() {
		if (Energy!=MaxEnergy) {
			Energy = MaxEnergy;
		}
		return false;
	}
/*
 * (non-Javadoc)
 * @see graphics.IMoveable#getVehicleName()
 */
	@Override
	public String getVehicleName() {
		// TODO Auto-generated method stub
		return null;
	}
/*
 * (non-Javadoc)
 * @see graphics.IMoveable#getSpeed()
 */
	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}
/*
 * (non-Javadoc)
 * @see graphics.IMoveable#getFuelConsumption()
 */
	@Override
	public int getFuelConsumption() {
		// TODO Auto-generated method stub
		return 0;
	}
/*
 * (non-Javadoc)
 * @see java.lang.Object#toString()
 */
	@Override
	
	public String toString() {
		return "PackAnimal [Name=" + Name + ", MaxEnergy=" + MaxEnergy + ", Energy=" + Energy + ", lessEnergy="
				+ lessEnergy + "]";
	}
/*
 * (non-Javadoc)
 * @see graphics.IMoveable#applyRefual()
 */
	@Override
	public boolean applyRefual() {
		// TODO Auto-generated method stub
		return false;
	}
/*
 * (non-Javadoc)
 * @see graphics.IMoveable#energy()
 */
	@Override
	public int energy() {
		return 0;
		
	}
	@Override
	public int getDurability() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean move() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
