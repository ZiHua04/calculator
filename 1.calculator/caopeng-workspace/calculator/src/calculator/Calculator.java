package calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

    private JTextField inputField; // 输入框
    private JButton[] buttons; // 按钮数组
    private String[] buttonLabels = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", ".", "=", "/"}; // 按钮标签数组
    private double num1, num2, result; // 计算器基本变量：两个操作数和计算结果
    private String operator; // 运算符

    public Calculator() {
        setTitle("Calculator"); // 设置窗口标题
        setSize(300, 400); // 设置窗口大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口关闭方式

        inputField = new JTextField(15); // 创建输入框，长度为15个字符
        inputField.setEditable(false); // 输入框不可编辑

        buttons = new JButton[buttonLabels.length]; // 创建按钮数组
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]); // 创建按钮，设置标签
            buttons[i].addActionListener(this); // 添加按钮监听器
        }

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4)); // 创建按钮面板，使用网格布局，4行4列
        for (int i = 0; i < buttons.length; i++) {
            buttonPanel.add(buttons[i]); // 将按钮添加到按钮面板中
        }

        JPanel inputPanel = new JPanel(); // 创建输入面板
        inputPanel.add(inputField); // 将输入框添加到输入面板中

        add(inputPanel, BorderLayout.NORTH); // 将输入面板添加到窗口的北部
        add(buttonPanel, BorderLayout.CENTER); // 将按钮面板添加到窗口的中心
    }

    public void actionPerformed(ActionEvent e) {
        String label = e.getActionCommand(); // 获取按钮标签

        if (label.equals("C")) { // 如果是清空操作
            inputField.setText(""); // 将输入框清空
        } else if (label.equals("+")) { // 如果是加法操作
            num1 = Double.parseDouble(inputField.getText()); // 获取第一个操作数
            operator = "+"; // 设置运算符
            inputField.setText(""); // 将输入框清空，等待输入第二个操作数
        } else if (label.equals("-")) { // 如果是减法操作
            num1 = Double.parseDouble(inputField.getText()); // 获取第一个操作数
            operator = "-"; // 设置运算符
            inputField.setText(""); // 将输入框清空，等待输入第二个操作数
        } else if (label.equals("*")) { // 如果是乘法操作
            num1 = Double.parseDouble(inputField.getText()); // 获取第一个操作数
            operator = "*"; // 设置运算符
            inputField.setText(""); // 将输入框清空，等待输入第二个操作数
        } else if (label.equals("/")) { // 如果是除法操作
            num1 = Double.parseDouble(inputField.getText()); // 获取第一个操作数
            operator = "/"; // 设置运算符
            inputField.setText(""); // 将输入框清空，等待输入第二个操作数
        } else if (label.equals("=")) { // 如果是等号操作
            num2 = Double.parseDouble(inputField.getText()); // 获取第二个操作数
            if (operator.equals("+")) { // 如果是加法运算
                result = num1 + num2; // 计算结果
            } else if (operator.equals("-")) { // 如果是减法运算
                result = num1 - num2; // 计算结果
            } else if (operator.equals("*")) { // 如果是乘法运算
                result = num1 * num2; // 计算结果
            } else if (operator.equals("/")) { // 如果是除法运算
                result = num1 / num2; // 计算结果
            }
            inputField.setText(Double.toString(result)); // 将结果显示在输入框中
        } else {
            inputField.setText(inputField.getText() + label); // 如果是数字或小数点，则将其添加到输入框中
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator(); // 创建计算器对象
        calculator.setVisible(true); // 显示计算器窗口
    }
}