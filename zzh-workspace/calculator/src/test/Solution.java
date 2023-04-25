package test;

public class Solution {
	public static double evaluateExpressionSimple(String expression)
	{
		double num = 0;
		double result = 0;
		char formerOps = ' ';
        expression = expression.replaceAll("\\s+", ""); // 去除空格
        for(int i = 0; i < expression.length(); i++)
        {
        	char ch = expression.charAt(i);
        	if(ch >= '0' && ch <= '9')
        	{
        		int j = i;
        		while(j < expression.length() && (expression.charAt(j) >= '0' && expression.charAt(j) <= '9'))
        		{
        			j++;
        		}
        		num = Double.parseDouble(expression.substring(i,j));
        		i = j-1;
        	}
        	else if(ch == '+' || ch == '-')
        	{
        		if(formerOps != ' ')
        			result = applyOperator(formerOps,result,num);
        		else result = num;
        		formerOps = ch;
        	}
        }
        result = applyOperator(formerOps,result,num);
        return result;
	}
	public static double applyOperator(char operator, double operand1, double operand2)
    {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                   
                }
                return operand1 / operand2;
            default:
                
        }
        return 0;
    }
	public static void main(String[] args)
	{
		String a = "3-6+9";
		double res = evaluateExpressionSimple(a);
		System.out.println(res);
	}
}
