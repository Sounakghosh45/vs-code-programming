import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankingApp extends JFrame implements ActionListener {
    private double balance = 0.0;
    private JTextField amountField;
    private JLabel balanceLabel;

    public BankingApp() {
        setTitle("Banking Application");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel amountLabel = new JLabel("Enter Amount:");
        amountField = new JTextField();
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton balanceButton = new JButton("Check Balance");
        balanceLabel = new JLabel("Current Balance: $0.0");

        add(amountLabel);
        add(amountField);
        add(depositButton);
        add(withdrawButton);
        add(balanceButton);
        add(balanceLabel);

        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        balanceButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        try {
            double amount = Double.parseDouble(amountField.getText());

            if (command.equals("Deposit")) {
                balance += amount;
                JOptionPane.showMessageDialog(this, "Deposited: $" + amount);
            } else if (command.equals("Withdraw")) {
                if (amount > balance) {
                    JOptionPane.showMessageDialog(this, "Insufficient Balance!");
                } else {
                    balance -= amount;
                    JOptionPane.showMessageDialog(this, "Withdrawn: $" + amount);
                }
            } else if (command.equals("Check Balance")) {
                JOptionPane.showMessageDialog(this, "Current Balance: $" + balance);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount!");
        }

        balanceLabel.setText("Current Balance: $" + balance);
        amountField.setText("");
    }

    public static void main(String[] args) {
        new BankingApp();
    }
}
