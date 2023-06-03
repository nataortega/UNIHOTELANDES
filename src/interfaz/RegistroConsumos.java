package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistroConsumos extends JFrame {
    private JTextField nombreField;
    private JTextField habitacionField;
    private JTextField tipoConsumoField;
    private JTextField consumoField;
    private JTextField tarifaField;
    private JRadioButton siButton;
    private JRadioButton noButton;
    private JButton registrarButton;

    public RegistroConsumos() {
        // Set up the JFrame
        setTitle("Registro de Huéspedes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Create the fields and button
        nombreField = new JTextField(20);
        habitacionField = new JTextField(20);
        tipoConsumoField = new JTextField(20);
        consumoField = new JTextField(20);
        tarifaField = new JTextField(20);
        siButton = new JRadioButton("Sí");
        noButton = new JRadioButton("No");
        registrarButton = new JButton("Registrar");

        // Add the radio buttons to a ButtonGroup
        ButtonGroup group = new ButtonGroup();
        group.add(siButton);
        group.add(noButton);

        // Add an ActionListener to the button
        registrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Save the fields here
                String nombre = nombreField.getText();
                String habitacion = habitacionField.getText();
                String tipoConsumo = tipoConsumoField.getText();
                String consumo = consumoField.getText();
                String tarifa = tarifaField.getText();
                String pagoInmediato = siButton.isSelected() ? "true" : "false";

                // Do something with the saved fields, like printing them out
                System.out.println("Nombre del Huésped: " + nombre);
                System.out.println("Nombre de la habitación: " + habitacion);
                System.out.println("Tipo de Consumo: " + tipoConsumo);
                System.out.println("Consumo: " + consumo);
                System.out.println("Tarifa: " + tarifa);
                System.out.println("Pago Inmediato: " + pagoInmediato);

                // if any of the fields is empty, display an error message
                if (nombre.equals("") || habitacion.equals("") || tipoConsumo.equals("") || consumo.equals("")
                        || tarifa.equals("")) {
                    JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    // otherwise, display a success message
                    JOptionPane.showMessageDialog(null, "¡Huésped registrado con éxito!", "Registro exitoso",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        // Create a JPanel to hold the fields and button
        JPanel panel = new JPanel(new GridLayout(7, 2));
        panel.add(new JLabel("Nombre del Huésped:"));
        panel.add(nombreField);
        panel.add(new JLabel("Nombre de la habitación:"));
        panel.add(habitacionField);
        panel.add(new JLabel("Tipo de Consumo:"));
        panel.add(tipoConsumoField);
        panel.add(new JLabel("Consumo:"));
        panel.add(consumoField);
        panel.add(new JLabel("Tarifa:"));
        panel.add(tarifaField);
        panel.add(new JLabel("Pago Inmediato:"));
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioPanel.add(siButton);
        radioPanel.add(noButton);
        panel.add(radioPanel);
        panel.add(new JPanel()); // Placeholder for the last cell
        panel.add(registrarButton);

        // Add the panel to the JFrame and display it
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RegistroConsumos();
    }
}
