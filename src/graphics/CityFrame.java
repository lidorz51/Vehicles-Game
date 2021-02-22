package graphics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * CityFrame class.
 * @author Yoav Yung id:203127329 ,Lidor zaguri id:205622814.
 */
public class CityFrame extends JFrame {
	private CityPanel citypanel;
	private JMenuBar menubar;
	private JMenu file,help; 
	private JMenuItem exit,Help;    

	/**
	 * constructor of CityFrame.
	 */
	CityFrame()  {

		setPreferredSize(new Dimension(800,600));
		setLocation(300,100);
		exit=new JMenuItem("Exit");
		Help=new JMenuItem("Help");
		file=new JMenu("File");
		file.add(exit);
		help=new JMenu("Help");
		help.add(Help);
		menubar = new JMenuBar();
		menubar.add(file);
		menubar.add(help);
		setJMenuBar(menubar);
		citypanel = new CityPanel();
		Help.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame help = new JFrame();
				JOptionPane.showMessageDialog(help, "Home work 2 \nGUI.");
			}
		});
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		this.setLayout(new GridLayout());
		add(citypanel, BorderLayout.CENTER);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	
	public CityPanel getCitypanel()
	{
		return citypanel;
	}

	public static void main(String[] args) {
		CityFrame cityframe=new CityFrame();
	}

	
}
