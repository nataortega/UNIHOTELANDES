
package view;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.synth.ColorType;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class ModificacionHabitaciones extends JFrame {
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
    	setTitle("Hotel uniandes HABITACIONES");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create components
        JLabel subirArchivoLabel = new JLabel("Subir archivo:");
        subirArchivoButton = new JButton("Seleccionar archivo...");
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField(10);
        JLabel ubicacionLabel = new JLabel("UbicaciÃ³n:");
        ubicacionField = new JTextField(20);
        JLabel capacidadLabel = new JLabel("Capacidad:");
        capacidadField = new JTextField(10);
        JLabel tipoCamaLabel = new JLabel("Tipo cama:");
        String[] tiposCama = {"Double", "Single"};
        tipoCamaComboBox = new JComboBox<String>(tiposCama);
        JLabel tarifaLabel = new JLabel("Tarifa:");
        tarifaField = new JTextField(10);
        actualizarButton = new JButton("Actualizar");
        crearButton = new JButton("Crear");
        JLabel subTitulo = new JLabel("Crear o actualizar habitaciones");
        
        GridLayout grillaElementos = new GridLayout(0,2,5,5);
        
        
        // Add components to content pane
        
        final JPanel panel = new JPanel();
        JPanel panelOpciones = new JPanel();
        panel.setLayout(new BorderLayout());
        panelOpciones.setLayout(grillaElementos);
        panel.add(panelOpciones, "Center");
        panel.add(subTitulo,"North");
        panelOpciones.add(subirArchivoLabel);
        panelOpciones.add(subirArchivoButton);
        panelOpciones.add(idLabel);
        panelOpciones.add(idField);
        panelOpciones.add(ubicacionLabel);
        panelOpciones.add(ubicacionField);
        panelOpciones.add(capacidadLabel);
        panelOpciones.add(capacidadField);
        panelOpciones.add(tipoCamaLabel);
        panelOpciones.add(tipoCamaComboBox);
        panelOpciones.add(tarifaLabel);
        panelOpciones.add(tarifaField);
        panelOpciones.add(actualizarButton);
        panelOpciones.add(crearButton);
        panelOpciones.setBackground(Color.orange);
        add(panel);
        
        // Add event listeners
        subirArchivoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int result = chooser.showOpenDialog(ModificacionHabitaciones.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = chooser.getSelectedFile();
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

                // TODO: update the room with the given ID using the input values
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

                // TODO: create a new room using the input values
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