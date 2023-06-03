package interfaz;

import javax.swing.*;
import java.awt.event.*;

public class MenuAdministrador extends JFrame {

    public MenuAdministrador() {
        JPanel panel = new JPanel();

        JButton habitacionesButton = new JButton("Habitaciones");
        habitacionesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show the ModificacionHabitaciones JFrame
                new ModificacionHabitaciones();
            }
        });

        JButton menuButton = new JButton("Menu");
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show the ModificacionMenu JFrame
                new ModificacionMenu();
            }
        });

        panel.add(habitacionesButton);
        panel.add(menuButton);

        add(panel);
        setContentPane(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuAdministrador();
    }
}
