package interfaz;

import javax.swing.*;

import controller.CalculadoraRF;
import controller.Sistema;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ModificacionMenu extends JFrame {

    private CalculadoraRF calc = new CalculadoraRF();
    private Sistema sis = new Sistema();

    private JLabel subirArchivoLabel, nombreLabel, ubicacionLabel, horarioLabel, tipoLabel, tarifaLabel;
    private JTextField nombreField, horarioField, tarifaField;
    private JComboBox ubicacionBox, tipoBox;
    private JButton actualizarButton, crearButton, subirArchivoButton;

    // class variables for the field values
    private String nombre;
    private String ubicacion;
    private String horario;
    private String tipo;
    private String tarifa;

    public ModificacionMenu() {
        // set up the frame
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create the labels and fields
        nombreLabel = new JLabel("Nombre:");
        ubicacionLabel = new JLabel("Ubicacion disponible:");
        horarioLabel = new JLabel("Horario disponible:");
        tipoLabel = new JLabel("Tipo de servicio:");
        tarifaLabel = new JLabel("Tarifa:");

        nombreField = new JTextField(20);
        horarioField = new JTextField(20);
        tarifaField = new JTextField(20);

        // create the drop-down boxes
        String[] ubicacionOptions = { "Comedor", "Habitacion", "Ambos" };
        ubicacionBox = new JComboBox(ubicacionOptions);

        String[] tipoOptions = { "Desayuno", "Almuerzo", "Comida", "Permanente" };
        tipoBox = new JComboBox(tipoOptions);

        // create the buttons
        JLabel subirArchivoLabel = new JLabel("Subir archivo:");
        subirArchivoButton = new JButton("Seleccionar archivo...");
        actualizarButton = new JButton("Actualizar");
        crearButton = new JButton("Crear");

        // add the components to the frame
        JPanel panel = new JPanel();
        panel.add(subirArchivoLabel);
        // add a file chooser to select the file
        panel.add(nombreLabel);
        panel.add(nombreField);
        panel.add(ubicacionLabel);
        panel.add(ubicacionBox);
        panel.add(horarioLabel);
        panel.add(horarioField);
        panel.add(tipoLabel);
        panel.add(tipoBox);
        panel.add(tarifaLabel);
        panel.add(tarifaField);
        panel.add(actualizarButton);
        panel.add(crearButton);
        add(panel);

        subirArchivoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int result = chooser.showOpenDialog(ModificacionMenu.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    try {
                        calc.actualizarMenuArchivo("Menu.txt", file);
                        JOptionPane.showMessageDialog(ModificacionMenu.this, "Menu actualizadas");

                    } catch (IOException e1) {
                        System.out.println("Error al actualizar menu");
                        JOptionPane.showMessageDialog(ModificacionMenu.this,
                                "Error al actualizar menu", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // update the class variables with the current field values
                nombre = nombreField.getText();
                ubicacion = (String) ubicacionBox.getSelectedItem();
                horario = horarioField.getText();
                tipo = (String) tipoBox.getSelectedItem();
                tarifa = tarifaField.getText();

                // display the updated data in the console
                System.out.println("Nombre: " + nombre);
                System.out.println("Ubicacion: " + ubicacion);
                System.out.println("Horario: " + horario);
                System.out.println("Tipo: " + tipo);
                System.out.println("Tarifa: " + tarifa);

                // if any of the fields is empty, display an error message
                if (nombre.equals("") || horario.equals("") || tarifa.equals("")) {
                    JOptionPane.showMessageDialog(ModificacionMenu.this,
                            "Por favor, llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    JOptionPane.showMessageDialog(ModificacionMenu.this, "Menu actualizado");
                }

            }
        });

        crearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // update the class variables with the current field values
                nombre = nombreField.getText();
                ubicacion = (String) ubicacionBox.getSelectedItem();
                horario = horarioField.getText();
                tipo = (String) tipoBox.getSelectedItem();
                tarifa = tarifaField.getText();

                // display the updated data in the console
                System.out.println("Nombre: " + nombre);
                System.out.println("Ubicacion: " + ubicacion);
                System.out.println("Horario: " + horario);
                System.out.println("Tipo: " + tipo);
                System.out.println("Tarifa: " + tarifa);

                if (nombre.equals("") || horario.equals("") || tarifa.equals("")) {
                    JOptionPane.showMessageDialog(ModificacionMenu.this,
                            "Por favor, llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    JOptionPane.showMessageDialog(ModificacionMenu.this, "Menu actualizado");
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ModificacionMenu();
    }
}
