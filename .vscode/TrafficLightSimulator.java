import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrafficLightSimulator extends JFrame implements ActionListener {
    private JRadioButton redButton, yellowButton, greenButton;
    private JLabel messageLabel;

    public TrafficLightSimulator() {
        setTitle("Traffic Light Simulator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Message Label
        messageLabel = new JLabel(" ");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(messageLabel);

        // Radio Buttons
        redButton = new JRadioButton("Red");
        yellowButton = new JRadioButton("Yellow");
        greenButton = new JRadioButton("Green");

        // Button Group
        ButtonGroup group = new ButtonGroup();
        group.add(redButton);
        group.add(yellowButton);
        group.add(greenButton);

        add(redButton);
        add(yellowButton);
        add(greenButton);

        // Adding action listeners
        redButton.addActionListener(this);
        yellowButton.addActionListener(this);
        greenButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (redButton.isSelected()) {
            messageLabel.setText("Stop");
            messageLabel.setForeground(Color.RED);
        } else if (yellowButton.isSelected()) {
            messageLabel.setText("Ready");
            messageLabel.setForeground(Color.ORANGE);
        } else if (greenButton.isSelected()) {
            messageLabel.setText("Go");
            messageLabel.setForeground(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TrafficLightSimulator().setVisible(true);
        });
    }
}
