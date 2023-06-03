package interfaz;

import javax.swing.*;

import controller.CalculadoraRF;
import controller.Sistema;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class ModificacionHabitaciones extends JFrame {
    private CalculadoraRF calc = new CalculadoraRF();
    private Sistema sis = new Sistema();

    private JTextField idField, ubicacionField, capacidadField, tarifaField;
    private JComboBox<String> tipoCamaComboBox;
    private JButton subirArchivoButton, actualizarButton, crearButton;

    private File selectedFile;
    private String id;
    private String ubicacion;
    private String capacidad;
    private String tipoCama;
    private String tarifa;

    public ModificacionHabitaciones() {
        // set up the frame
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        JLabel subirArchivoLabel = new JLabel("Subir archivo:");
        subirArchivoButton = new JButton("Seleccionar archivo...");
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField(10);
        JLabel ubicacionLabel = new JLabel("Ubicación:");
        ubicacionField = new JTextField(20);
        JLabel capacidadLabel = new JLabel("Capacidad:");
        capacidadField = new JTextField(10);
        JLabel tipoCamaLabel = new JLabel("Tipo cama:");
        String[] tiposCama = { "Double", "Single" };
        tipoCamaComboBox = new JComboBox<String>(tiposCama);
        JLabel tarifaLabel = new JLabel("Tarifa:");
        tarifaField = new JTextField(10);
        actualizarButton = new JButton("Actualizar");
        crearButton = new JButton("Crear");

        // Add components to content pane
        JPanel panel = new JPanel();

        panel.add(subirArchivoLabel);
        panel.add(subirArchivoButton);
        panel.add(idLabel);
        panel.add(idField);
        panel.add(ubicacionLabel);
        panel.add(ubicacionField);
        panel.add(capacidadLabel);
        panel.add(capacidadField);
        panel.add(tipoCamaLabel);
        panel.add(tipoCamaComboBox);
        panel.add(tarifaLabel);
        panel.add(tarifaField);
        panel.add(actualizarButton);
        panel.add(crearButton);
        add(panel);

        // Add event listeners
        subirArchivoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int result = chooser.showOpenDialog(ModificacionHabitaciones.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = chooser.getSelectedFile();
                    try {
                        calc.actualizarHabitacionesArchivo("Habitacion.txt", selectedFile);
                        sis.cargarHabitaciones();
                        JOptionPane.showMessageDialog(ModificacionHabitaciones.this, "Habitaciones actualizadas");

                    } catch (IOException e1) {
                        System.out.println("Error al actualizar habitaciones");
                        JOptionPane.showMessageDialog(ModificacionHabitaciones.this,
                                "Error al actualizar habitaciones", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the current values of the input fields
                id = idField.getText();
                ubicacion = ubicacionField.getText();
                capacidad = capacidadField.getText();
                tipoCama = (String) tipoCamaComboBox.getSelectedItem();
                tarifa = tarifaField.getText();

                // if any of the fields is empty, display an error message
                if (id.equals("") || ubicacion.equals("") || capacidad.equals("") || tarifa.equals("")) {
                    JOptionPane.showMessageDialog(ModificacionHabitaciones.this, "Por favor llene todos los campos",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(ModificacionHabitaciones.this, "Habitaciones actualizadas");
                }

            }
        });

        crearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the current values of the input fields
                id = idField.getText();
                ubicacion = ubicacionField.getText();
                capacidad = capacidadField.getText();
                tipoCama = (String) tipoCamaComboBox.getSelectedItem();
                tarifa = tarifaField.getText();

                if (id.equals("") || ubicacion.equals("") || capacidad.equals("") || tarifa.equals("")) {
                    JOptionPane.showMessageDialog(ModificacionHabitaciones.this, "Por favor llene todos los campos",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(ModificacionHabitaciones.this, "Habitaciones actualizadas");
                }

            }
        });

        // Configure window
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ModificacionHabitaciones();
    }
}
