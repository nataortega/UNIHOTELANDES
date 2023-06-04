package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HotelGuestApplication {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public void createAndShowGUI() {
        frame = new JFrame("Hotel Guest Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridBagLayout());

        // Crear elementos de la interfaz
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(10);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(10);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                // Lógica de autenticación del usuario
                // ...
                // Si la autenticación es exitosa, abrir la ventana principal
                abrirVentanaPrincipal();
            }
        });

        // Crear diseño de la interfaz
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        frame.add(usernameLabel, gbc);

        gbc.gridx = 1;
        frame.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(passwordLabel, gbc);

        gbc.gridx = 1;
        frame.add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(loginButton, gbc);

        frame.setVisible(true);
    }

    private void abrirVentanaPrincipal() {
        // Lógica para abrir la ventana principal después de la autenticación exitosa
        // ...
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HotelGuestApplication application = new HotelGuestApplication();
                application.createAndShowGUI();
            }
        });
    }
}