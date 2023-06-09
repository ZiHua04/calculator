package StackMethod;

import java.util.Scanner;
import java.util.Stack;

public class Main {
//	public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入一个表达式：");
//        String expression = sc.nextLine();
//
//        try {
//            double result = evaluateExpression(expression);
//            System.out.println("计算结果为：" + result);
//        } catch (Exception e) {
//            System.out.println("计算错误：" + e.getMessage());
//        }
//    }

    public static double evaluateExpression(String expression) throws Exception {
        expression = expression.replaceAll("\\s+", ""); // 去除空格
        expression = expression.replaceAll("\\(-", "(0-"); // 处理负数

        Stack<Double> operands = new Stack<>(); // 操作数栈
        Stack<Character> operators = new Stack<>(); // 运算符栈

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch >= '0' && ch <= '9') { // 数字
                int j = i;
                while (j < expression.length() && (expression.charAt(j) >= '0' && expression.charAt(j) <= '9' || expression.charAt(j) == '.')) {
                    j++;
                }
                double operand = Double.parseDouble(expression.substring(i, j));
                operands.push(operand);
                i = j - 1;
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') { // 运算符
                while (!operators.empty() && (operators.peek() == '*' || operators.peek() == '/') && (ch == '+' || ch == '-')) {
                    double operand2 = operands.pop();
                    double operand1 = operands.pop();
                    char operator = operators.pop();
                    double result = applyOperator(operator, operand1, operand2);
                    operands.push(result);
                }
                operators.push(ch);
            } else if (ch == '(') { // 左括号
                operators.push(ch);
            } else if (ch == ')') { // 右括号
                while (!operators.empty() && operators.peek() != '(') {
                    double operand2 = operands.pop();
                    double operand1 = operands.pop();
                    char operator = operators.pop();
                    double result = applyOperator(operator, operand1, operand2);
                    operands.push(result);
                }
                if (operators.empty()) {
                    throw new Exception("括号不匹配");
                }
                operators.pop();
            } else {
                throw new Exception("非法字符：" + ch);
            }
        }

        while (!operators.empty()) { // 处理剩余的运算符和操作数
            if (operators.peek() == '(') {
                throw new Exception("括号不匹配");
            }
            double operand2 = operands.pop();
            double operand1 = operands.pop();
            char operator = operators.pop();
            double result = applyOperator(operator, operand1, operand2);
            operands.push(result);
        }

        if (operands.empty()) {
            throw new Exception("表达式为空");
        }
        return operands.pop();
    }

    public static double applyOperator(char operator, double operand1, double operand2) throws Exception {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new Exception("除数不能为零");
                }
                return operand1 / operand2;
            default:
                throw new Exception("未知运算符：" + operator);
        }
    }
}
