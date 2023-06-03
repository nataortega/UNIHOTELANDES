package interfaz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import controller.CalculadoraRF;
import controller.Sistema;

public class Login extends JFrame {
    JLabel cargoLabel, usuarioLabel, contrasenaLabel;
    JTextField usuarioField;
    JPasswordField contrasenaField;
    JButton submitButton;
    BufferedImage backgroundImage;
    JComboBox cargoField;

    CalculadoraRF calculadoraRF = new CalculadoraRF();
    Sistema sistema = new Sistema();

    public Login() throws IOException {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2)); // sets the layout of the panel to a 4x2 grid

        // Add logo to the top of the frame
        JPanel logoPanel = new JPanel();
        // BufferedImage logoImage = ImageIO.read(new File("data/fondo.jpg")); //
        // Replace with your own logo image file
        // JLabel logoLabel = new JLabel(new ImageIcon(logoImage));
        // logoPanel.add(logoLabel);
        // frame.add(logoPanel, BorderLayout.NORTH);

        cargoLabel = new JLabel("Cargo:");
        String[] cargos = { "Administrador", "Empleado", "Recepcionista" };
        cargoField = new JComboBox<String>(cargos);
        usuarioLabel = new JLabel("Usuario:");
        usuarioField = new JTextField();
        contrasenaLabel = new JLabel("Contrasena:");
        contrasenaField = new JPasswordField();
        submitButton = new JButton("Submit");

        panel.add(cargoLabel);
        panel.add(cargoField);
        panel.add(usuarioLabel);
        panel.add(usuarioField);
        panel.add(contrasenaLabel);
        panel.add(contrasenaField);
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cargoText = (String) cargoField.getSelectedItem();
                String usuarioText = usuarioField.getText();
                String contrasenaText = new String(contrasenaField.getPassword());

                System.out.println("Cargo: " + cargoText);
                System.out.println("Usuario: " + usuarioText);
                System.out.println("Contrasena: " + contrasenaText);

                if (cargoText.equals("Administrador") && sistema.validarCedencialesAdmin(usuarioText, contrasenaText)) {
                    // Show the MenuAdministrador JFrame
                    new MenuAdministrador();
                    dispose();
                } else if (cargoText.equals("Empleado")
                        && sistema.validarCedencialesEmp(usuarioText, contrasenaText)) {
                    // Show the MenuEmpleado JFrame
                    new RegistroConsumos();
                    dispose();
                } else if (cargoText.equals("Recepcionista")
                        && sistema.validarCedencialesRecp(usuarioText, contrasenaText)) {
                    // Show the MenuRecepcionista JFrame
                    new ManejadorReservas();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contrasena incorrectos", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Set background image
        // backgroundImage = ImageIO.read(new File("data/fondo.jpg")); // Replace with
        // your own background image file
        // JPanel backgroundPanel = new JPanel() {
        // @Override
        // protected void paintComponent(Graphics g) {
        // super.paintComponent(g);
        // g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        // }
        // };
        // backgroundPanel.setLayout(new BorderLayout());
        // backgroundPanel.add(panel, BorderLayout.CENTER);
        // frame.setContentPane(backgroundPanel);

        // Set JFrame properties
        add(panel);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new Login();
    }
}
