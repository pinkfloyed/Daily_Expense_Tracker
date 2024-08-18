import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;

class LoginPage extends JPanel {
    public LoginPage(ExpenseTrackerApp app) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Username label and field
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JTextField usernameField = new JTextField(20);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 14));
        add(usernameField, gbc);

        // Password label and field
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        add(passwordField, gbc);

        // Login button
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBackground(Color.GREEN);
        loginButton.setForeground(Color.WHITE);
        loginButton.setMargin(new Insets(5, 15, 5, 15));
        add(loginButton, gbc);

        // Sign Up button
        gbc.gridy = 3;
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("Arial", Font.BOLD, 14));
        signUpButton.setBackground(Color.ORANGE);
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setMargin(new Insets(5, 15, 5, 15));
        add(signUpButton, gbc);

        // Back button
        gbc.gridy = 4;
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBackground(Color.GRAY);
        backButton.setForeground(Color.WHITE);
        backButton.setMargin(new Insets(5, 15, 5, 15));
        add(backButton, gbc);

        // Button actions
        loginButton.addActionListener(e -> {
            // Handle login logic
            app.switchTo("Home");
        });

        signUpButton.addActionListener(e -> {
            app.switchTo("Sign Up");
        });

        backButton.addActionListener(e -> {
            app.switchTo("Home"); // Or another screen as appropriate
        });
    }
}
