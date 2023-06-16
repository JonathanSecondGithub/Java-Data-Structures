public class Main extends JFrame implements ActionListener {
    private User user;
    private JLabel label1, label2, balanceLabel;
    private JButton depositBtn, withdrawBtn;

    public Main(User user) {
        this.user = user;
        setTitle("Banking Application - Main");
        setLayout(new GridLayout(3, 2));

        label1 = new JLabel("Account Number:");
        label2 = new JLabel("Current Balance:");
        balanceLabel = new JLabel(String.valueOf(user.getAccount().getBalance()));
        depositBtn = new JButton("Deposit");
        withdrawBtn = new JButton("Withdraw");

        add(label1);
        add(new JLabel(user.getAccount().getAccountNumber()));
        add(label2);
        add(balanceLabel);
        add(depositBtn);
        add(withdrawBtn);

        depositBtn.addActionListener(this);
        withdrawBtn.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositBtn) {
            String input = JOptionPane.showInputDialog(this, "Enter deposit amount:");
            double amount = Double.parseDouble(input);
            user.getAccount().deposit(amount);
            balanceLabel.setText(String.valueOf(user.getAccount().getBalance()));
        } else if (e.getSource() == withdrawBtn) {
            String input = JOptionPane.showInputDialog(this, "Enter withdrawal amount:");
            double amount = Double.parseDouble(input);
            if (amount > user.getAccount().getBalance()) {
                JOptionPane.showMessageDialog(this, "Insufficient funds!");
            } else {
                user.getAccount().withdraw(amount);
                balanceLabel.setText(String.valueOf(user.getAccount().getBalance()));
            }
        }
    }
}
