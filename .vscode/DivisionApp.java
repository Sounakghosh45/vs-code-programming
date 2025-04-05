import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DivisionApp {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Integer Division Calculator");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create panel
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Set frame visibility
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);  // Using null layout for absolute positioning
        
        // Labels and text fields
        JLabel label1 = new JLabel("Num1:");
        label1.setBounds(10, 20, 80, 25);  // Position the label
        panel.add(label1);

        JTextField num1Field = new JTextField(10);
        num1Field.setBounds(100, 20, 165, 25);  // Position the text field for num1
        panel.add(num1Field);

        JLabel label2 = new JLabel("Num2:");
        label2.setBounds(10, 50, 80, 25);
        panel.add(label2);

        JTextField num2Field = new JTextField(10);
        num2Field.setBounds(100, 50, 165, 25);  // Position the text field for num2
        panel.add(num2Field);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(10, 110, 80, 25);
        panel.add(resultLabel);

        JTextField resultField = new JTextField(10);
        resultField.setBounds(100, 110, 165, 25);
        resultField.setEditable(false);  // Disable editing of the result field
        panel.add(resultField);

        // Divide button
        JButton divideButton = new JButton("Divide");
        divideButton.setBounds(100, 80, 100, 25);  // Position the button
        panel.add(divideButton);
        
        // Action listener for the button
        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(num1Field.getText());
                    int num2 = Integer.parseInt(num2Field.getText());
                    if (num2 == 0) {
                        throw new ArithmeticException("Cannot divide by zero");
                    }
                    int result = num1 / num2;
                    resultField.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Please enter valid integers!", "Input Error", JOptionPane.ERROR_MESSAGE);
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(panel, ex.getMessage(), "Math Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
