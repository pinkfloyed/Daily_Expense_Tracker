import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

class HomePage extends JPanel {
    public HomePage(ExpenseTrackerApp app) {
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Welcome to the Daily Expense Tracker", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton aboutButton = new JButton("About");
        JButton expenseButton = new JButton("Expense");
        JButton savingsButton = new JButton("Savings");

        buttonPanel.add(aboutButton);
        buttonPanel.add(expenseButton);
        buttonPanel.add(savingsButton);

        add(buttonPanel, BorderLayout.SOUTH);

        aboutButton.addActionListener(e -> app.switchTo("About"));
        expenseButton.addActionListener(e -> app.switchTo("Expense"));
        savingsButton.addActionListener(e -> app.switchTo("Savings"));
    }
}
