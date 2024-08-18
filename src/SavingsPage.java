import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;

class SavingsPage extends JPanel {
    private JLabel totalCostLabel;
    private JLabel totalExpensesLabel;
    private JLabel savingsLabel;
    private JButton backButton;

    public SavingsPage(ExpenseTrackerApp app) {
        setLayout(new GridLayout(4, 1, 10, 10)); // Added extra row for the Back button

        // Initialize labels with updated font and color
        totalCostLabel = new JLabel("Total Cost: $0.00", SwingConstants.CENTER);
        totalCostLabel.setFont(new Font("Arial", Font.BOLD, 18));
        totalCostLabel.setForeground(Color.BLACK);

        totalExpensesLabel = new JLabel("Total Expenses: $0.00", SwingConstants.CENTER);
        totalExpensesLabel.setFont(new Font("Arial", Font.BOLD, 18));
        totalExpensesLabel.setForeground(Color.BLACK);

        savingsLabel = new JLabel("Savings: $0.00", SwingConstants.CENTER);
        savingsLabel.setFont(new Font("Arial", Font.BOLD, 18));
        savingsLabel.setForeground(Color.GREEN); // Color for savings

        // Add labels to panel
        add(totalCostLabel);
        add(totalExpensesLabel);
        add(savingsLabel);

        // Initialize Back button with updated font, color, and style
        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 14)); // Bold font
        backButton.setBackground(Color.GRAY); // Button background color
        backButton.setForeground(Color.WHITE); // Button text color
        backButton.setMargin(new Insets(10, 20, 10, 20)); // Add padding

        // Add Back button to panel
        add(backButton);

        // Add Back button action listener
        backButton.addActionListener(e -> app.switchTo("Home"));
    }

    // Method to update savings details
    public void updateSavings(double totalCost, double totalExpenses) {
        double savings = totalCost - totalExpenses;
        totalCostLabel.setText("Total Cost: $" + String.format("%.2f", totalCost));
        totalExpensesLabel.setText("Total Expenses: $" + String.format("%.2f", totalExpenses));
        savingsLabel.setText("Savings: $" + String.format("%.2f", savings));
    }
}
