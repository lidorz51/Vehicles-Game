package graphics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Vehicles.Vehicle;

/**
 * buttons class.
 * 
 * @author Yoav Yung id:203127329 ,Lidor zaguri id:205622814.
 */
public class buttons extends JPanel implements ActionListener {
	private AddVehiclsDialog car;
	Vehicle v = null;
	private CityPanel city = null;
	private JButton FuelandFood = null;

	buttons(CityPanel city) {
		this.city = city;
		this.v = city.getVehicls();
		setLayout(new GridLayout());
		JButton AddVehicle = new JButton("Add Vehicle");
		JButton Clear = new JButton("Clear");
		FuelandFood = new JButton("Fuel/Food");
		JButton Lights = new JButton("Lights");
		JButton Info = new JButton("Info");
		JButton Exit = new JButton("Exit");

		add(AddVehicle);
		add(Clear);
		add(FuelandFood);
		add(Lights);
		add(Info);
		add(Exit);

		AddVehicle.addActionListener(this);
		Clear.addActionListener(this);
		FuelandFood.addActionListener(this);
		Lights.addActionListener(this);
		Info.addActionListener(this);
		Exit.addActionListener(this);

	}

	/**
	 * actionPerformed.
	 */
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Add Vehicle":
			car = new AddVehiclsDialog(city);
			break;

		case "Clear":
			for (int i = 0; i < city.vehiclelist().size(); i++) {
				city.vehiclelist().get(i).interrupt();
			}
			city.removCar();
			city.repaint();
			break;

		case "Fuel/Food":
			for (int i = 0; i < city.vehiclelist().size(); i++) {
				synchronized (city.vehiclelist().get(i)) {
					city.vehiclelist().get(i).vehicle().applyRefual();
					city.vehiclelist().get(i).notify();
				}
			}
			break;
		case "Info":
			JTable table;
			JFrame info = new JFrame();
			info.setLayout(new BorderLayout());
			info.setSize(1127, 280);
			info.setVisible(true);
			v = city.getVehicls();
			String cols[] = { "Vehicle", "ID", "Color", "Wheels", "Speed", "fuelAmount", "Distance", "Fual consumption",
					"Lights", "ID-Collision","Name of vehcles collision" };
			Object[][] rows = {};
			if (v != null) {
				rows = new Object[city.vehiclelist1().size() + 1][11];
				for (int i = 0; i < city.vehiclelist1().size(); i++) {
					rows[i][0] = city.vehiclelist1().get(i).getVehicleName();
					rows[i][1] = city.vehiclelist1().get(i).getCarID();
					rows[i][2] = city.vehiclelist1().get(i).getColor();
					rows[i][3] = city.vehiclelist1().get(i).getnumOfWheels();
					rows[i][4] = city.vehiclelist1().get(i).getSpeed();
					rows[i][5] = city.vehiclelist1().get(i).energy();
					rows[i][6] = city.vehiclelist1().get(i).getKm();
					rows[i][7] = city.vehiclelist1().get(i).getFuelConsumption();
					rows[i][8] = city.vehiclelist1().get(i).getlights();
					rows[i][9] = city.vehiclelist1().get(i).getVehiclesCollisoin();
					rows[i][10] = city.vehiclelist1().get(i).getVehiclesCollisoinName();

				}
			}
			table = new JTable(rows, cols);
			table.setPreferredScrollableViewportSize(new Dimension(1100, 200));
			table.setFillsViewportHeight(true);
			JScrollPane scroll = new JScrollPane(table);
			scroll.setVisible(true);
			info.add(scroll,BorderLayout.CENTER);
			break;
		
		case "Lights":
			v=city.getVehicls();
			v.setLights(true);
			break;
			
		case "Exit":
			System.exit(1);
			break;
		}

	}
}
