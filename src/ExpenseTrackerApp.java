import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;


public class ExpenseTrackerApp extends JFrame {
    CardLayout cardLayout;
    JPanel mainPanel;
    LoginPage loginPage;
    SignUpPage signUpPage;
    HomePage homePage;
    AboutPage aboutPage;
    ExpensePage expensePage;
    SavingsPage savingsPage;

    public ExpenseTrackerApp() {
        setTitle("Daily Expense Tracker");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        loginPage = new LoginPage(this);
        signUpPage = new SignUpPage(this);
        homePage = new HomePage(this);
        aboutPage = new AboutPage(this);
        expensePage = new ExpensePage(this);
        savingsPage = new SavingsPage(this);

        mainPanel.add(loginPage, "Login");
        mainPanel.add(signUpPage, "Sign Up");
        mainPanel.add(homePage, "Home");
        mainPanel.add(aboutPage, "About");
        mainPanel.add(expensePage, "Expense");
        mainPanel.add(savingsPage, "Savings");

        add(mainPanel);
        cardLayout.show(mainPanel, "Login");

        setVisible(true);
    }

    public void switchTo(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    public static void main(String[] args) {
        new ExpenseTrackerApp();
    }
}
