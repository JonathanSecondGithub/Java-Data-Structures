import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {
    JLabel userLabel, passwordLabel;
    JTextField userText;
    JPasswordField passwordText;
    JButton loginButton;

    public LoginPage() {
        setTitle("Banking System Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        userLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        userText = new JTextField();
        passwordText = new JPasswordField();
        loginButton = new JButton("Login");

        add(userLabel);
        add(userText);
        add(passwordLabel);
        add(passwordText);
        add(new JLabel(""));
        add(loginButton);

        loginButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = userText.getText();
        String password = new String(passwordText.getPassword());

        if (username.equals("user") && password.equals("password")) {
            UserPage userPage = new UserPage();
            userPage.setVisible(true);
            dispose(); // close the login page
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
    }
}
