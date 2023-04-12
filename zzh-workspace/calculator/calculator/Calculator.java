package calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

    private JTextField inputField;
    private JButton[] buttons;
    private String[] buttonLabels = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", ".", "=", "/"};
    private double num1, num2, result;
    private String operator;

    public Calculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(15);
        inputField.setEditable(false);

        buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].addActionListener(this);
        }

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        for (int i = 0; i < buttons.length; i++) {
            buttonPanel.add(buttons[i]);
        }

        JPanel inputPanel = new JPanel();
        inputPanel.add(inputField);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        String label = e.getActionCommand();

        if (label.equals("C")) {
            inputField.setText("");
        } else if (label.equals("+")) {
            num1 = Double.parseDouble(inputField.getText());
            operator = "+";
            inputField.setText("");
        } else if (label.equals("-")) {
            num1 = Double.parseDouble(inputField.getText());
            operator = "-";
            inputField.setText("");
        } else if (label.equals("*")) {
            num1 = Double.parseDouble(inputField.getText());
            operator = "*";
            inputField.setText("");
        } else if (label.equals("/")) {
            num1 = Double.parseDouble(inputField.getText());
            operator = "/";
            inputField.setText("");
        } else if (label.equals("=")) {
            num2 = Double.parseDouble(inputField.getText());
            if (operator.equals("+")) {
                result = num1 + num2;
            } else if (operator.equals("-")) {
                result = num1 - num2;
            } else if (operator.equals("*")) {
                result = num1 * num2;
            } else if (operator.equals("/")) {
                result = num1 / num2;
            }
            inputField.setText(Double.toString(result));
        } else {
            inputField.setText(inputField.getText() + label);
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setVisible(true);
    }
}
