import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;

class AboutPage extends JPanel {
    public AboutPage(ExpenseTrackerApp app) {
        setLayout(new BorderLayout());

        // About label with improved HTML formatting
        JLabel label = new JLabel("<html>" +
                "<h1 style='font-size: 28px; font-family: Grey Qo, sans-serif; font-weight: bold; color: #2E86C1;'>About This App</h1>" +
                "<p style='font-size: 18px; font-family: Arial, sans-serif; color: #555555;'>This is a simple daily expense tracker.<br>" +
                "Available on Windows and iOS devices.<br>" +
                "Daily Expense Tracker is great for monitoring your everyday spending.<br>" +
                "It also offers options for calculating your daily income and savings.<br>" +
                "Easy to operate and very handy for those who are students, housewives, or have small businesses.<br>" +
                "All you have to do is create an account and start listing!<br>" +
                "CONTACT NO: <span style='font-weight: bold;'>+88 01858012612</span></p>" +
                "</html>", SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);

        // Back button with custom styling
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 16)); // Larger bold font
        backButton.setBackground(Color.DARK_GRAY); // Darker button background color
        backButton.setForeground(Color.WHITE); // Button text color
        backButton.setMargin(new Insets(10, 20, 10, 20)); // Add more padding

        add(backButton, BorderLayout.SOUTH);

        // Back button action
        backButton.addActionListener(e -> app.switchTo("Home"));
    }
}
