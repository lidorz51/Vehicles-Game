package graphics;

import java.awt.BorderLayout;
import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import javax.swing.JPanel;

import Vehicles.Vehicle;

/**
 * CityPanel class. 
 * 
 * @version 20.5 May 2019.
 * @author Yoav Yung id:203127329 ,Lidor zaguri id:205622814.
 * @see Vehicle 
 */
public class CityPanel extends JPanel {
	static final int NumOfVehcles = 5;
	static final int MaxOfVehcles = 10;

	private buttons Buttons = null;
	private BufferedImage img = null;
	private Vehicle v = null;
	private LinkedList<ThreadCity> vehiclwait = new LinkedList();
	private ArrayList<Vehicle> cars = new ArrayList<Vehicle>();
	private ThreadCity vehiclesthrad;
	private LinkedList<ThreadCity> VehiclesThrad = new LinkedList();
	private String vehiclesCollisoin;

	public CityPanel() {

		setLayout(new BorderLayout());
		try {
			img = ImageIO.read(new File("C:\\Users\\lidor\\Desktop\\Yoav Yung id-203127329 ,Lidor zaguri id-205622814\\images\\cityBackground.png"));
		} catch (IOException e) {
			System.out.println("Cannot load image");
		}
		Buttons = new buttons(this);
		add(Buttons, BorderLayout.PAGE_END);
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), 520, this);
		for (int i = 0; i < VehiclesThrad.size(); i++) {
			if (i < NumOfVehcles) {
				VehiclesThrad.get(i).vehicle().drawObject(g);
			} else {
				break;
			}
		}
		if (v != null)
			v.collision();
	}

	public buttons getbuttons() {
		return Buttons;
	}

	public boolean setVehicls(Vehicle v) {

		this.v = v;
		if (VehiclesThrad.size() < NumOfVehcles) {
			vehiclesthrad = new ThreadCity(v);
			VehiclesThrad.add(vehiclesthrad);
			vehiclesthrad.start();
		} else
			vehiclwait.add(new ThreadCity(v));
		cars.add(getVehicls());
		return true;
	}

	public void Threadman() {
		if (vehiclwait.size() > 0) {

			ThreadCity vehicles = vehiclwait.get(0);
			vehiclwait.remove(0);
			VehiclesThrad.add(vehicles);
			vehicles.start();

		}

	}

	/**
	 * @return vehicles after is create. 
	 */
	public Vehicle getVehicls() {
		return v;
	}

	/**
	 * LinkedList of all the Threads.
	 * 
	 * @return VehiclesThrad.
	 */
	public LinkedList<ThreadCity> vehiclelist() {
		return VehiclesThrad;
	}

	/**
	 * ArrayList for the table.
	 * 
	 * @return all the data of the vehicles.
	 */
	public ArrayList<Vehicle> vehiclelist1() {
		return cars;
	}

	/**
	 * remove all the vehicles.
	 */
	public void removCar() {
		VehiclesThrad.removeAll(VehiclesThrad);
		Threadman();
	}

}