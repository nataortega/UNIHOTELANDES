package view;

import javax.swing.*;
import java.awt.event.*;

	public class MenuAdministrador {
		public MenuAdministrador() {
			JFrame frame = new JFrame("Two Buttons Example");
	        JPanel panel = new JPanel();

	        JButton habitacionesButton = new JButton("Habitaciones");
	        habitacionesButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                JFrame habitacionesFrame = new JFrame("Habitaciones");
	                // Add components to habitacionesFrame here...
	                habitacionesFrame.setVisible(true);
	            }
	        });

	        JButton menuButton = new JButton("Menu");
	        menuButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                JFrame menuFrame = new JFrame("Menu");
	                // Add components to menuFrame here...
	                menuFrame.setVisible(true);
	            }
	        });

	        panel.add(habitacionesButton);
	        panel.add(menuButton);

	        frame.setContentPane(panel);
	        frame.pack();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	    }
		
		public static void main(String[] args) {
			new MenuAdministrador();
		}
	}

