import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;

class ExpensePage extends JPanel {
    private DefaultTableModel tableModel;
    private JLabel totalLabel;
    private double totalAmount = 0.0;

    public ExpensePage(ExpenseTrackerApp app) {
        setLayout(new BorderLayout());

        // Table model
        tableModel = new DefaultTableModel(new Object[]{"Category", "Amount"}, 0);
        JTable table = new JTable(tableModel);

        // Customize table header
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16)); // Bold and larger font for headers
        header.setForeground(Color.BLUE); // Header text color

        // Set a custom renderer for headers
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(JLabel.CENTER); // Center align header text
        headerRenderer.setFont(new Font("Arial", Font.BOLD, 16)); // Bold and larger font

        add(new JScrollPane(table), BorderLayout.CENTER);

        // Panel for buttons and total amount
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 5, 10, 10)); // Use GridLayout for better spacing

        // Add button
        JButton addButton = new JButton("Add");
        addButton.setFont(new Font("Arial", Font.BOLD, 14)); // Bold font
        addButton.setBackground(Color.GREEN); // Button background color
        addButton.setForeground(Color.WHITE); // Button text color
        addButton.setMargin(new Insets(5, 10, 5, 10)); // Add padding

        // Update button
        JButton updateButton = new JButton("Update");
        updateButton.setFont(new Font("Arial", Font.BOLD, 14)); // Bold font
        updateButton.setBackground(Color.ORANGE); // Button background color
        updateButton.setForeground(Color.WHITE); // Button text color
        updateButton.setMargin(new Insets(5, 10, 5, 10)); // Add padding

        // Delete button
        JButton deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font("Arial", Font.BOLD, 14)); // Bold font
        deleteButton.setBackground(Color.RED); // Button background color
        deleteButton.setForeground(Color.WHITE); // Button text color
        deleteButton.setMargin(new Insets(5, 10, 5, 10)); // Add padding

        // Total label
        totalLabel = new JLabel("Total: $0.00");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Bold font

        // Back button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 14)); // Bold font
        backButton.setBackground(Color.GRAY); // Button background color
        backButton.setForeground(Color.WHITE); // Button text color
        backButton.setMargin(new Insets(5, 10, 5, 10)); // Add padding

        bottomPanel.add(addButton);
        bottomPanel.add(updateButton);
        bottomPanel.add(deleteButton);
        bottomPanel.add(totalLabel);
        bottomPanel.add(backButton); // Add the Back button to the panel

        add(bottomPanel, BorderLayout.SOUTH);

        // Add button action
        addButton.addActionListener(e -> {
            String category = JOptionPane.showInputDialog("Enter category:");
            String amountStr = JOptionPane.showInputDialog("Enter amount:");
            double amount = Double.parseDouble(amountStr);
            tableModel.addRow(new Object[]{category, amount});
            updateTotal(amount);
        });

        // Update button action
        updateButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String category = JOptionPane.showInputDialog("Enter new category:", tableModel.getValueAt(selectedRow, 0));
                String amountStr = JOptionPane.showInputDialog("Enter new amount:", tableModel.getValueAt(selectedRow, 1));
                double newAmount = Double.parseDouble(amountStr);
                double oldAmount = (double) tableModel.getValueAt(selectedRow, 1);
                tableModel.setValueAt(category, selectedRow, 0);
                tableModel.setValueAt(newAmount, selectedRow, 1);
                updateTotal(newAmount - oldAmount);
            }
        });

        // Delete button action
        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                double amount = (double) tableModel.getValueAt(selectedRow, 1);
                tableModel.removeRow(selectedRow);
                updateTotal(-amount);
            }
        });

        // Back button action
        backButton.addActionListener(e -> app.switchTo("Home"));
    }

    private void updateTotal(double amount) {
        totalAmount += amount;
        totalLabel.setText("Total: $" + String.format("%.2f", totalAmount));
    }
}
