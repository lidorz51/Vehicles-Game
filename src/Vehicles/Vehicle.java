package Vehicles;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

import javax.imageio.ImageIO;

import graphics.CityPanel;
import graphics.IDrawable;
import graphics.IMoveable;

/**
 * abstract class Vehicle.
 * 
 * @author Yoav Yung id:203127329 ,Lidor zaguri id:205622814.
 */
public abstract class Vehicle implements IDrawable, IMoveable, Cloneable {

	protected static int age = 18;
	protected static int globalID = 1000;

	protected Rectangle rec;
	protected String name;
	protected int numOfWheels;
	protected CarColor color;
	protected Location location;
	protected int km;
	protected boolean lights;
	protected int size = 65;
	protected int id;
	protected int wheels;
	protected Location loc;
	protected int fuelConsumption;
	protected CityPanel pan;
	protected BufferedImage img1, img2, img3, img4;
	protected int numOfPassengers, randChoice;
	protected int CarID;
	protected int Durability;
	protected int vehiclesCollisoin = 0;
	protected String vehiclesCollisoinName;

	public String getVehiclesCollisoinName() {
		return vehiclesCollisoinName;
	}

	public void setVehiclesCollisoinName(String vehiclesCollisoinName) {
		this.vehiclesCollisoinName = vehiclesCollisoinName;
	}

	/**
	 * 
	 * @param numOfPassengers number of passengers.
	 * @param color color of the vehicles.
	 * @param city object of CityPanel
	 */

	public Vehicle(int numOfPassengers, CarColor color, CityPanel city) {
		setLights(false);
		this.km = 0;
		this.numOfPassengers = numOfPassengers;
		this.CarID = globalID;
		Vehicle.globalID++;
		this.fuelConsumption = 0;
		this.color = color;
		this.pan = city;
		this.rec = new Rectangle();

	}

	/**
	 * 
	 * @param point the point of the vehicles.
	 * @return the point of the vehicles.
	 */
	abstract public boolean drive(Point point);

	/**
	 * 
	 * @return CarID
	 */
	public int getCarID() {
		return CarID;
	}

	/**
	 * getnumOfWheels function.
	 * 
	 * @return numOfWheels number of the wheels.
	 */
	public int getnumOfWheels() {

		return numOfWheels;
	}

	/**
	 * getNumOfPassengers function.
	 * 
	 * @param numOfPassengers number of the passenger.
	 * @return the number of the passenger.
	 */
	public int getNumOfPassengers(int numOfPassengers) {

		return numOfPassengers;
	}

	/**
	 * getColor function.
	 * 
	 * @return color.toString().
	 */
	public String getColor() {

		return color.toString();
	}

	/**
	 * getLocation function.
	 * 
	 * @return location.
	 */
	public Location getLocation() {

		return location;
	}

	/**
	 * getNumOfWheels function.
	 * 
	 * @return numOfWheels.
	 */
	public int getNumOfWheels() {
		return numOfWheels;
	}

	public int getVehiclesCollisoin() {
		return vehiclesCollisoin;
	}

	public void setVehiclesCollisoin(int vehiclesCollisoin) {
		this.vehiclesCollisoin = vehiclesCollisoin;
	}

	/**
	 * setWheels function.
	 * 
	 * @param wheels set the number of wheels in vehicles.
	 */
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	/**
	 * getFuelConsumption
	 */
	public int getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(int fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public int getNumOfPassengers() {
		return numOfPassengers;
	}

	public void setNumOfPassengers(int numOfPassengers) {
		this.numOfPassengers = numOfPassengers;
	}

	/**
	 * getKm function.
	 * 
	 * @return: this function return Km.
	 */
	public int getKm() {

		return km;
	}

	/**
	 * lights function.
	 * 
	 * @return: this function return true or false if the lights on or not.
	 */
	public boolean getlights() {

		return lights;
	}

	/**
	 * setnumOfWheels function.
	 * 
	 * @param num: int type num Of Wheels.
	 * 
	 * @return: true or false if set or not.
	 */
	protected boolean setnumOfWheels(int num) {
		this.numOfWheels = num;
		return true;
	}

	/**
	 * setColor function.
	 * 
	 * @param color: set color.
	 * 
	 * @return: true or false if set or not.
	 */
	protected boolean setColor(CarColor color) {

		this.color = color;
		return true;
	}

	/**
	 * setLocation function.
	 * 
	 * 
	 * @param loc obj Point type set a Location
	 * @return  true or false if set or not.
	 */
	public boolean setLocation(Location loc) {

		this.location = loc;
		return true;
	}

	/**
	 * setkm function.
	 * 
	 * @param km:int type set a km
	 * 
	 * @return: true or false if set or not.
	 */
	protected boolean setKm(int km) {

		this.km = km;
		return true;
	}

	public boolean setLights(boolean lights) {

		/*
		 * setLights function.
		 * 
		 * @param p:obj Point type set a Location
		 * 
		 * @return: true or false if set or not.
		 */

		this.lights = lights;
		return true;
	}

	public String getVehicleName() {
		return name;
	}

	public int calcDurability(int durability) {
		return Durability -= durability;
	}

	public int getDurability() {
		return Durability;
	}

	public void drawObject(Graphics g)

	{
		if (location.getDir() == direction.NORTH) // car drives to the north side
		{
			g.drawImage(img1, location.getPoint().getX(), location.getPoint().getY(), size, size * 2, pan);
			rec.setBounds(location.getPoint().getX(), location.getPoint().getY(), size, size * 2);
			;

		} else if (location.getDir() == direction.SOUTH) // car drives to the south side
		{
			g.drawImage(img2, location.getPoint().getX(), location.getPoint().getY(), size, size * 2, pan);
			rec.setBounds(location.getPoint().getX(), location.getPoint().getY(), size, size * 2);
			;

		} else if (location.getDir() == direction.EAST) // car drives to the east side
		{
			g.drawImage(img3, location.getPoint().getX(), location.getPoint().getY(), size * 2, size, pan);
			rec.setBounds(location.getPoint().getX(), location.getPoint().getY(), size * 2, size);
			;

		} else if (location.getDir() == direction.WEST) // car drives to the west side
		{
			g.drawImage(img4, location.getPoint().getX(), location.getPoint().getY(), size * 2, size, pan);
			rec.setBounds(location.getPoint().getX(), location.getPoint().getY(), size * 2, size);
			;
		}
	}

	public void loadImages(String nm) {
		String pathName = PICTURE_PATH + getColor().toLowerCase() + nm;
		File f = null;
		try {
			f = new File(pathName + "North.png");
			img1 = ImageIO.read(f);
			f = new File(pathName + "South.png");
			img2 = ImageIO.read(f);
			f = new File(pathName + "East.png");
			img3 = ImageIO.read(f);
			f = new File(pathName + "West.png");
			img4 = ImageIO.read(f);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public boolean move() {
		this.drive(nextLocation());
		pan.repaint();
		return true;
	}

	public Point nextLocation() {
		Point p = new Point(this.location.getPoint());
		Random rand = new Random();
		if (location.getDir() == direction.EAST) {
			if (p.getX() < 720)
				p.setX(this.location.getPoint().getX() + this.getSpeed());
			else {
				location.setDir(direction.SOUTH);
				randChoice = rand.nextInt(2);
			}
		} else if (location.getDir() == direction.WEST) {
			if (p.getX() > 0)
				p.setX(this.location.getPoint().getX() - this.getSpeed());
			else {
				location.setDir(direction.NORTH);
				randChoice = rand.nextInt(2);
			}
		} else if (location.getDir() == direction.NORTH) {
			if (p.getY() > (randChoice == 0 ? 0 : 430 / 2 - 10))
				p.setY(this.location.getPoint().getY() - this.getSpeed());
			else
				location.setDir(direction.EAST);

		} else if (location.getDir() == direction.SOUTH) {
			if (p.getY() < (randChoice == 0 ? 430 : 430 / 2 - 10))
				p.setY(this.location.getPoint().getY() + this.getSpeed());
			else
				location.setDir(direction.WEST);
		}
		return p;
	}

	public static int getAge() {
		return age;
	}

	@Override

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public Rectangle getRectangle() {
		return rec;
	}

	public boolean collision() {
		int i, j;
		for (i = 0; i < pan.vehiclelist().size(); i++) {
			for (j = 0; j < pan.vehiclelist().size(); j++) {
				if (i != j) {
					if (pan.vehiclelist().get(i).getRectangle().intersects(pan.vehiclelist().get(j).getRectangle())) {
						if (pan.vehiclelist().get(i).getDurability() < pan.vehiclelist().get(j).getDurability()) {
							pan.vehiclelist().get(j).vehicle()
									.setVehiclesCollisoin(pan.vehiclelist().get(i).vehicle().getCarID());
							pan.vehiclelist().get(j).vehicle()
									.setVehiclesCollisoinName(pan.vehiclelist().get(i).vehicle().getVehicleName());
							pan.vehiclelist().remove(i);
						} else if (pan.vehiclelist().get(j).getDurability() < pan.vehiclelist().get(i)
								.getDurability()) {
							pan.vehiclelist().get(i).vehicle()
									.setVehiclesCollisoin(pan.vehiclelist().get(j).vehicle().getCarID());
							pan.vehiclelist().get(i).vehicle()
									.setVehiclesCollisoinName(pan.vehiclelist().get(j).vehicle().getVehicleName());
							pan.vehiclelist().remove(j);
						} else if (pan.vehiclelist().get(j).getDurability() == pan.vehiclelist().get(i)
								.getDurability()) {
							pan.vehiclelist().get(j).vehicle()
									.setVehiclesCollisoin(pan.vehiclelist().get(i).vehicle().CarID);
							pan.vehiclelist().get(j).vehicle()
									.setVehiclesCollisoinName(pan.vehiclelist().get(i).vehicle().getVehicleName());
							pan.vehiclelist().get(i).vehicle()
									.setVehiclesCollisoin(pan.vehiclelist().get(j).vehicle().getCarID());
							pan.vehiclelist().get(i).vehicle()
									.setVehiclesCollisoinName(pan.vehiclelist().get(j).vehicle().getVehicleName());
							pan.vehiclelist().remove(j);
							pan.vehiclelist().remove(i);
						}
						pan.Threadman();
					}
				}
			}
		}
		return true;
	}

}
