package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

import Vehicles.Bike;
import Vehicles.Car;
import Vehicles.CarColor;
import Vehicles.Carriage;
import Vehicles.Location;
import Vehicles.PackAnimal;
import Vehicles.Vehicle;
import Vehicles.typeOfEngine;

/**
 * AddVehiclseDialog class.
 * 
 * @author Yoav Yusng id:203127329 ,Lidor zaguri id:205622814.
 */
public class AddVehiclsDialog extends JDialog {

	JRadioButton benzinecar;
	JRadioButton solarcar;
	JRadioButton carrige;
	JRadioButton bike;
	CityPanel city = null;

	JRadioButton Silver;
	JRadioButton Red;
	JRadioButton Green;
	JRadioButton White;

	JButton Ok;
	JButton Cancel;
	JDialog d = new JDialog();

	JPanel panel1;
	JSlider slider;
	ButtonGroup group = null;

	CarColor color, select;
	typeOfEngine type;
	PackAnimal Animal = null;
	Vehicle v = null;

	/**
	 * constructor AddVehiclesDialog.
	 * 
	 * @param city of city panel.
	 */

	public AddVehiclsDialog(CityPanel city) {

		this.city = city;
		setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new GridLayout());
		p.add(createvehicls());
		p.add(createcolor());
		d.add(getSlider());
		d.add(buttonsAddvhicals(), BorderLayout.PAGE_END);
		d.setTitle("Add Vehicles");
		d.add(p, BorderLayout.NORTH);
		d.setSize(500, 300);
		d.setLocation(100, 200);
		d.setVisible(true);
	}

	/**
	 * @return panel of buttons of vehicles.
	 */
	public JPanel createvehicls() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100, 150));
		setLayout(new BorderLayout());
		group = new ButtonGroup();
		benzinecar = new JRadioButton(" Benzine car");
		benzinecar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false);

			}

		});
		solarcar = new JRadioButton(" Solar car");
		solarcar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false);

			}

		});
		bike = new JRadioButton("Bike");
		bike.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(true);
			}

		});
		carrige = new JRadioButton("Carrige");
		carrige.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false);

			}
		});
		group.add(benzinecar);
		group.add(solarcar);
		group.add(bike);
		group.add(carrige);

		panel.add(benzinecar);
		panel.add(solarcar);
		panel.add(bike);
		panel.add(carrige);

		panel.setSize(300, 150);
		panel.setBorder(BorderFactory.createTitledBorder("Choose a Vehicals"));

		return panel;
	}

	/**
	 * @author Yoav Yung id:203127329 ,Lidor zaguri id:205622814. create buttons of
	 *         color.
	 */
	private JPanel createcolor() {
		ButtonGroup group = new ButtonGroup();
		Silver = new JRadioButton("Silver");
		Silver.setEnabled(true);
		Silver.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				color = CarColor.SILVER;

			}
		});
		Red = new JRadioButton("Red");
		Red.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				color = CarColor.RED;

			}
		});
		Green = new JRadioButton("Green");
		Green.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				color = CarColor.GREEN;

			}
		});
		White = new JRadioButton("White");
		White.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				color = CarColor.WHITE;

			}
		});

		group.add(Silver);
		group.add(Green);
		group.add(Red);
		group.add(White);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100, 150));
		panel.add(Silver);
		panel.add(Red);
		panel.add(Green);
		panel.add(White);

		panel.setBorder(BorderFactory.createTitledBorder("Choose a color"));

		return panel;
	}

	/**
	 * buttonsAddvhicals.
	 * 
	 * @return panel of buttons Ok / Cancel.
	 */
	public JPanel buttonsAddvhicals() {
		JPanel panel = new JPanel();
		setLayout(new GridLayout());
		Ok = new JButton("OK");
		Ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					createobj();
					d.dispose();
				} catch (NullPointerException v) {
					JFrame message = new JFrame();
					JOptionPane.showMessageDialog(message, "//ERROR!!//please insert vehicle perfectly.");
				}
			}
		});
		Cancel = new JButton("Cancel");
		Cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				d.dispose();
			}
		});
		panel.add(Ok);
		panel.add(Cancel);
		return panel;
	}

	/**
	 * getSlider.
	 * 
	 * @return panel of the slider.
	 */
	public JPanel getSlider() {
		slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
		slider.setMinorTickSpacing(2);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		panel1 = new JPanel();
		panel1.add(slider);
		panel1.setVisible(false);
		return panel1;
	}

	/**
	 * createobj.
	 * 
	 * @return a vehicles.
	 */
	public boolean createobj() {
		Vehicle v = city.getVehicls();

		if (Silver.isSelected()) {
			select = CarColor.SILVER;
		} else if (Red.isSelected()) {
			select = CarColor.RED;
		} else if (Green.isSelected()) {
			select = CarColor.GREEN;
		} else if (White.isSelected()) {
			select = CarColor.WHITE;
		}

		benzinecar.setEnabled(true);
		if (solarcar.isSelected()) {
			Car car = new Car(5, select, typeOfEngine.SOLAR, city);
			v = car;
			v.loadImages("Car");
			v.applyRefual();

		} else if (benzinecar.isSelected()) {
			Car car = new Car(5, select, typeOfEngine.BENZINE, city);
			v = car;
			v.loadImages("Car");
			v.applyRefual();

		}

		if (bike.isSelected()) {
			Bike bike = new Bike(select, slider.getValue(), city);
			v = bike;
			v.loadImages("Bike");
		}

		if (carrige.isSelected()) {
			Carriage carriage = new Carriage(select, 2, city);
			v = carriage;
			v.loadImages("Carriage");
		}
		v.setLocation(new Location());
		city.setVehicls(v);
		city.repaint();
		return true;
	}
}