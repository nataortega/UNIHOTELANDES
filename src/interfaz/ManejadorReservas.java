package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManejadorReservas extends JFrame implements ActionListener {
    private JTextField nombreHuespedField, idField, correoElectronicoField, numeroCelularField,
            cantidadPersonasField, cantidadHabitacionesField, habitacionesDisponiblesField;

    public ManejadorReservas() {
        // Set up the JFrame
        setTitle("Manejador de Reservas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Set up the text fields
        nombreHuespedField = new JTextField(20);
        idField = new JTextField(20);
        correoElectronicoField = new JTextField(20);
        numeroCelularField = new JTextField(20);
        cantidadPersonasField = new JTextField(20);
        cantidadHabitacionesField = new JTextField(20);
        habitacionesDisponiblesField = new JTextField(20);

        // Set up the buttons
        JButton crearButton = new JButton("Crear");
        crearButton.addActionListener(this);
        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(this);

        // Set up the layout
        JPanel panel = new JPanel(new GridLayout(8, 2));
        panel.add(new JLabel("Nombre de Huesped:"));
        panel.add(nombreHuespedField);
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Correo Electronico:"));
        panel.add(correoElectronicoField);
        panel.add(new JLabel("Numero de Celular:"));
        panel.add(numeroCelularField);
        panel.add(new JLabel("Cantidad de Personas:"));
        panel.add(cantidadPersonasField);
        panel.add(new JLabel("Cantidad de Habitaciones:"));
        panel.add(cantidadHabitacionesField);
        panel.add(new JLabel("Habitaciones Disponibles:"));
        panel.add(habitacionesDisponiblesField);
        panel.add(cancelarButton);
        panel.add(crearButton);

        // Add the panel to the JFrame
        add(panel);

        // Make the JFrame visible
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Crear")) {
            // Save the values of the text fields
            String nombreHuesped = nombreHuespedField.getText();
            String id = idField.getText();
            String correoElectronico = correoElectronicoField.getText();
            String numeroCelular = numeroCelularField.getText();
            int cantidadPersonas = Integer.parseInt(cantidadPersonasField.getText());
            int cantidadHabitaciones = Integer.parseInt(cantidadHabitacionesField.getText());
            int habitacionesDisponibles = Integer.parseInt(habitacionesDisponiblesField.getText());

            // if any of the fields is empty, display an error message

            if (nombreHuesped.equals("") || id.equals("") || correoElectronico.equals("") || numeroCelular.equals("")
                    || cantidadPersonasField.equals("") || cantidadHabitacionesField.equals("")
                    || habitacionesDisponiblesField.equals("")) {
                JOptionPane.showMessageDialog(this, "Por favor, llene todos los campos.");
            } else {
                // Create a new reservation
                // Display a message
                JOptionPane.showMessageDialog(this, "Reserva creada exitosamente.");

            }

        } else if (e.getActionCommand().equals("Cancelar")) {
            // Clear the values of the text fields
            nombreHuespedField.setText("");
            idField.setText("");
            correoElectronicoField.setText("");
            numeroCelularField.setText("");
            cantidadPersonasField.setText("");
            cantidadHabitacionesField.setText("");
            habitacionesDisponiblesField.setText("");
        }
    }

    public static void main(String[] args) {
        ManejadorReservas manejadorReservas = new ManejadorReservas();
    }
}
