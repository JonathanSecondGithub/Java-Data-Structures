import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    private JLabel label1, label2;
    private JTextField tf1;
    private JPasswordField pf;
    private JButton loginBtn;

    public Login() {
        setTitle("Banking Application - Login");
        setLayout(new GridLayout(3, 2));

        label1 = new JLabel("Username:");
        label2 = new JLabel("Password:");
        tf1 = new JTextField(20);
        pf = new JPasswordField(20);
        loginBtn = new JButton("Login");

        add(label1);
        add(tf1);
        add(label2);
        add(pf);
        add(new JLabel(""));
        add(loginBtn);

        loginBtn.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            String username = tf1.getText();
            String password = new String(pf.getPassword());

            // Perform login validation here
            // You can replace this with your own validation code

            if (username.equals("admin") && password.equals("admin123")) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                new Main(user);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password!");
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
