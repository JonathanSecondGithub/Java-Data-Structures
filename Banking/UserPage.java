import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserPage extends JFrame implements ActionListener {
    JLabel balanceLabel;
    JTextField balanceText;
    JButton withdrawButton, depositButton;

    public UserPage() {
        setTitle("Banking System User Page");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        balanceLabel = new JLabel("Balance:");
        balanceText = new JTextField();
        balanceText.setEditable(false);
        withdrawButton = new JButton("Withdraw");
        depositButton = new JButton("Deposit");

        add(balanceLabel);
        add(balanceText);
        add(withdrawButton);
        add(depositButton);

        withdrawButton.addActionListener(this);
        depositButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdrawButton) {
            // TODO: implement withdraw functionality
        } else if (e.getSource() == depositButton) {
            // TODO: implement deposit functionality
        }
    }

    public static void main(String[] args) {
        UserPage userPage = new UserPage();
    }
}
