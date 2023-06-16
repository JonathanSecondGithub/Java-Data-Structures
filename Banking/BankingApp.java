import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankingApp extends JFrame implements ActionListener {

    private JLabel welcomeLabel, userLabel, passLabel;
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginBtn, checkBalanceBtn, withdrawBtn, depositBtn;
    private JPanel loginPanel, accountPanel;
    private JLabel balanceLabel;
    private JTextField withdrawField, depositField;

    // constructor
    public BankingApp() {
        // set up login panel
        welcomeLabel = new JLabel("Welcome to our Bank!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        userLabel = new JLabel("Username:");
        passLabel = new JLabel("Password:");
        userField = new JTextField(20);
        passField = new JPasswordField(20);
        loginBtn = new JButton("Login");
        loginBtn.addActionListener(this);
        loginPanel = new JPanel(new GridLayout(3, 2));
        loginPanel.add(userLabel);
        loginPanel.add(userField);
        loginPanel.add(passLabel);
        loginPanel.add(passField);
        loginPanel.add(new JLabel()); // filler
        loginPanel.add(loginBtn);

        // set up account panel
        balanceLabel = new JLabel();
        checkBalanceBtn = new JButton("Check Balance");
        checkBalanceBtn.addActionListener(this);
        withdrawField = new JTextField(10);
        withdrawBtn = new JButton("Withdraw");
        withdrawBtn.addActionListener(this);
        depositField = new JTextField(10);
        depositBtn = new JButton("Deposit");
        depositBtn.addActionListener(this);
        accountPanel = new JPanel(new GridLayout(4, 2));
        accountPanel.add(new JLabel("Balance:"));
        accountPanel.add(balanceLabel);
        accountPanel.add(checkBalanceBtn);
        accountPanel.add(new JLabel()); // filler
        accountPanel.add(new JLabel("Withdraw:"));
        accountPanel.add(withdrawField);
        accountPanel.add(new JLabel());
        accountPanel.add(withdrawBtn);
        accountPanel.add(new JLabel("Deposit:"));
        accountPanel.add(depositField);
        accountPanel.add(new JLabel());
        accountPanel.add(depositBtn);

        // add panels to frame
        setLayout(new BorderLayout());
        add(welcomeLabel, BorderLayout.NORTH);
        add(loginPanel, BorderLayout.CENTER);

        setTitle("Banking App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }

    // event handling
    public void actionPerformed(ActionEvent e) {
        String username = userField.getText();
        String password = String.valueOf(passField.getPassword());

        // check login credentials
        if (e.getSource() == loginBtn && checkLogin(username, password)) {
            remove(loginPanel);
            add(accountPanel, BorderLayout.CENTER);
            balanceLabel.setText("$1000.00"); // set starting balance
            revalidate();
            repaint();
        }

        // check balance
        if (e.getSource() == checkBalanceBtn) {
            JOptionPane.showMessageDialog(this, "Your balance is " + balanceLabel.getText());
        }

        // withdraw money
        if (e.getSource() == withdrawBtn) {
            double withdrawAmount = Double.parseDouble(withdrawField.getText());
            double balance = Double.parseDouble(balanceLabel.getText().substring(1)); // remove '$' sign
            if (balance >= withdrawAmount) {
                balance -= withdrawAmount;
                balanceLabel.setText("$" + String.format("%.2f", balance));
                JOptionPane.showMessageDialog(this, "Withdrawal successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient funds!");
            }
            withdrawField.setText("");
        }

        // deposit money
        if (e.getSource() == depositBtn) {
            double depositAmount = Double.parseDouble(depositField.getText());
            double balance = Double.parseDouble(balanceLabel.getText().substring(1)); // remove '$' sign
            balance += depositAmount;
            balanceLabel.setText("$" + String.format("%.2f", balance));
            JOptionPane.showMessageDialog(this, "Deposit successful!");
            depositField.setText("");
        }
    }

    // helper method to check login credentials
    private boolean checkLogin(String username, String password) {
        // hardcoded username and password for demo purposes
        return username.equals("user123") && password.equals("password123");
    }

    // main method to start program
    public static void main(String[] args) {
        new BankingApp();
    }
}
