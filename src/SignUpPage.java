import javax.swing.*;
import java.awt.*;

class SignUpPage extends JPanel {
    public SignUpPage(ExpenseTrackerApp app) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        // Set background color for the panel
        setBackground(new Color(102, 51, 0)); // Dark brown background

        // Set label styles
        JLabel emailLabel = createStyledLabel("Email Address:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(emailLabel, gbc);

        JTextField emailField = new JTextField(20);
        gbc.gridx = 1;
        add(emailField, gbc);

        JLabel nameLabel = createStyledLabel("Enter Name:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(nameLabel, gbc);

        JTextField nameField = new JTextField(20);
        gbc.gridx = 1;
        add(nameField, gbc);

        JLabel usernameLabel = createStyledLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(usernameLabel, gbc);

        JTextField usernameField = new JTextField(20);
        gbc.gridx = 1;
        add(usernameField, gbc);

        JLabel passwordLabel = createStyledLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        add(passwordField, gbc);

        JLabel addressLabel = createStyledLabel("Address:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(addressLabel, gbc);

        JTextField addressField = new JTextField(20);
        gbc.gridx = 1;
        add(addressField, gbc);

        // Gender Radio Buttons
        JLabel genderLabel = createStyledLabel("Gender:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(genderLabel, gbc);

        JPanel genderPanel = new JPanel();
        genderPanel.setBackground(new Color(102, 51, 0)); // Match background color
        JRadioButton maleRadio = new JRadioButton("Male");
        maleRadio.setForeground(Color.WHITE);
        maleRadio.setBackground(new Color(102, 51, 0));
        JRadioButton femaleRadio = new JRadioButton("Female");
        femaleRadio.setForeground(Color.WHITE);
        femaleRadio.setBackground(new Color(102, 51, 0));
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);

        gbc.gridx = 1;
        add(genderPanel, gbc);

        // Location Dropdown
        JLabel locationLabel = createStyledLabel("Location:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(locationLabel, gbc);

        JComboBox<String> locationComboBox = new JComboBox<>(new String[]{"Dhaka", "Chittagong", "Sylhet"});
        gbc.gridx = 1;
        add(locationComboBox, gbc);

        // Submit Button
        JButton signUpButton = new JButton("SUBMIT");
        signUpButton.setFont(new Font("Arial", Font.BOLD, 12));
        signUpButton.setBackground(Color.BLACK);
        signUpButton.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 7;
        add(signUpButton, gbc);

        signUpButton.addActionListener(e -> {
            // Handle sign-up logic
            app.switchTo("Login");
        });
    }

    // Helper method to create styled labels
    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.WHITE); // White text color
        return label;
    }
}
