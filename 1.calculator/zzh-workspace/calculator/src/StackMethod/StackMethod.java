package StackMethod;
import java.util.*;
import javax.swing.*;
import java.math.*;

import ScriptMethod.ScriptMethod;
import javafx.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.script.*;
public class StackMethod extends JFrame implements ActionListener
{
	private JTextField text1,text2;//创建文本框的对象
	private GridBagConstraints gbc;
	private String expression;
	private String[] ButtonLabels = {"(",")","Back","/","7","8","9","*","4","5","6","-","1","2","3","+","CE","0",".","="};
	private static int judge = 0;//表示输入的运算字符串是否正确
	private int NowIn = 1;//表示输入状态
	private Font font1 = new Font("宋体", Font.PLAIN,50);//设置字体
	private Font font2 = new Font("宋体", Font.PLAIN,30);//设置字体

	public static void main(String[] args)
	{
		StackMethod stackmethod = new StackMethod();
	}
	public StackMethod()
	{
		setTitle("calculator");//设置窗口标题
		setSize(720,720);//设置窗口大小
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口关闭方式
		
		text1 = new JTextField(20);//创建文本框
		text2 = new JTextField(20);
		//text1.setEditable(false);//让文本框变为不可输入
		text2.setEditable(false);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		text1.setFont(font1);//将设置的字体添加到text文本框中
		text2.setFont(font1);
		text1.setHorizontalAlignment(JTextField.RIGHT);
		text2.setHorizontalAlignment(JTextField.RIGHT);
		
		JPanel PanelText = new JPanel();//创立一个文本面板
		PanelText.setLayout(new GridBagLayout());
		
		PanelText.add(text1,gbc);//将文本框添加到文本面板里
		gbc.gridy = 0;
        PanelText.add(text1, gbc);

        gbc.gridy = 1;
        PanelText.add(text2, gbc);
        add(PanelText,BorderLayout.NORTH);
		
		JPanel PanelButton = new JPanel(new GridLayout(5,4));//新建一个按钮面板
		JButton buttons[] = new JButton[ButtonLabels.length];//初始化按钮数组
		for (int i = 0; i < ButtonLabels.length; i++)
		{
			buttons[i] = new JButton(ButtonLabels[i]);
			buttons[i].setFont(new Font("宋体",Font.BOLD,15));//设置按钮的字体大小,粗细
			buttons[i].addActionListener(this);//为每个按钮添加监听器，需要在下面重写actionPerformed方法
			PanelButton.add(buttons[i]);//添加到按钮面板上
		}
	    	
	    add(PanelButton,BorderLayout.CENTER);//将按钮面版添加到窗口的中心
	    
	   

		
		setVisible(true);//使窗口可见
	}
	public void actionPerformed(java.awt.event.ActionEvent e)//实现按钮对应的动作
	{
		judge = 0;
		String label = ((JButton)e.getSource()).getText();//将按钮上的文本转化，赋给label
		switch (label)
			{ 
			case "=":
			{
				if(NowIn == 1)
				{
					text1.setFont(font2);
					text2.setFont(font1);
					NowIn = 2;
				}
				expression = text1.getText();
				double result = evaluateExpression(expression);
				text2.setText(Double.toString(result));
				switch (judge)
				{
					case 0:
					{
						text2.setText("="+Double.toString(result));
						break;
					}
					case 1:
					{
						text2.setText("请输入正确表达式");
						break;
					}
					case 2:
					{
						text2.setText("括号不匹配");
						break;
					}
					case 3:
					{
						text2.setText("除数不能为零");
						break;
					}
					
				}
				break;
			}
			case "CE":
			{
				text1.setText("");
				text2.setText("");
				break;
			}
			case "Back":
			{
				String temp = text1.getText();
				text1.setText(temp.substring(0,temp.length()-1));
				expression = text1.getText();
				double result = evaluateExpression(expression);
				text2.setText(Double.toString(result));
				break;
			}
			case ".":
			{
				boolean flag = false;
				for(int i = 0; i < text1.getText().length(); i++)
				{
					if(text1.getText().charAt(i) == '.')
					{
						flag = true;
						break;
					}
				}
				if(!flag)
				{
					text1.setText(text1.getText()+label);
					expression = text1.getText();
					double result = evaluateExpression(expression);
					text2.setText(Double.toString(result));
				}
				break;
			}
			
			default :
			{
				if(NowIn == 1)//还未得出结果的状态
				{
					switch (label)
					{
					case "+":
				//	case "-":
					case "*":
					case "/":
					case ")":	
					{
						char temp = text1.getText().charAt(text1.getText().length()-1);
						if(temp == '+' || temp == '-' || temp == '*' || temp == '/' || temp == '(')
						{
							
						}
						else
						{
							text1.setText(text1.getText()+label);
							expression = text1.getText();
							double result = evaluateExpression(expression);
							text2.setText(Double.toString(result));
						}
						break;
					}
					case "-":
					{
						char temp = text1.getText().charAt(text1.getText().length()-1);
						if(temp == '+' || temp == '-' || temp == '*' || temp == '/' )
						{
						}
						else
						{
							text1.setText(text1.getText()+label);
							expression = text1.getText();
							double result = evaluateExpression(expression);
							text2.setText(Double.toString(result));
						}
						break;
					}
					default:
					{
						text1.setText(text1.getText()+label);
						expression = text1.getText();
						double result = evaluateExpression(expression);
						text2.setText(Double.toString(result));
					}
					}
					text1.setFont(font1);
					text2.setFont(font2);
					
				}
				else if(NowIn == 2)//在得出结果的状态
				{
					text1.setFont(font1);
					text2.setFont(font2);
					switch (label)
						{
						case "1":
						case "2":
						case "3":
						case "4":
						case "5":
						case "6":
						case "7":
						case "8":
						case "9":
						case "0":
						{
							text1.setText(label);
							expression = text1.getText();
							double result = evaluateExpression(expression);
							text2.setText(Double.toString(result));
							break;
						}
						
						default:
						{
							double result = evaluateExpression(text1.getText());
							text1.setText(Double.toString(result)+label);
						}
					}
					NowIn = 1;
				}
				
				expression = text1.getText();
				double result = evaluateExpression(expression);
				text2.setText(Double.toString(result));
				
				switch (judge)
				{
					case 0:
					{
						text2.setText("="+Double.toString(result));
						break;
					}
					case 1:
					{
						text2.setText("请输入正确表达式");
						break;
					}
					case 2:
					{
						text2.setText("括号不匹配");
						break;
					}
					case 3:
					{
						text2.setText("除数不能为零");
						break;
					}
					
				}
				
			}
		}
	}
	private static final Map<String,Integer> OP_PRIORITY_MAP=new HashMap<String, Integer>(){
        {
            put("(",0);
            put("+",3);
            put("-",3);
            put("*",4);
            put("/",4);
            put(")",10);
        }
    };

    public double evaluateExpression(String expression){
        Stack<String> opStack = new Stack<String>();         //运算符栈
        Stack<BigDecimal> numStack = new Stack<BigDecimal>();       //操作数栈
        StringBuilder numBuilder = new StringBuilder();     //当前数值的追加器

        for (int i = 0;i < expression.length();i++){
            char c = expression.charAt(i);
            if (c >= '0' && c <= '9' || c == '.'){          //如果是数值则加入追加器
                numBuilder.append(c);
            }else{                                          //如果是运算符
                if (numBuilder.length() > 0){               //如果numBuilder有值说明里面已经有一个数值
                    numStack.push(new BigDecimal(numBuilder.toString()));     //把数值入运算符栈
                    numBuilder.delete(0,numBuilder.length());  //清空数值
                }
                //读取到的字符是运算符
                String op = String.valueOf(c);
                if (opStack.empty()){    //如果操作数栈没有运算符
                    opStack.push(op);
                }else{
                    //如果是"("则直接入运算栈
                    if ("(".equals(op)){
                        opStack.push(op);
                    }else if (")".equals(op)){
                        //如果是")"则进行括号匹配运算括号内的表达式
                        while (!"(".equals(opStack.peek())){
                            stackOperation(opStack,numStack);
                        }
                        opStack.pop();
                    }else{
                        //如果是运算符，需要对比当前运算符op和栈顶的运算符优先级。
                        do {
                            //比较当前运算符和栈顶运算符的优先级,如果nowOp和opStack栈顶元素相同或者低级，
                            // 则进行运算，直到nowOp高于opStack栈顶
                            if (jubgmentPriority(op,opStack.peek())){
                                stackOperation(opStack,numStack);
                                if (opStack.empty()){
                                    opStack.push(op);
                                    break;
                                }
                            }else {
                                opStack.push(op);
                                break;
                            }
                        }while (!opStack.empty());
                    }
                }
            }
        }

        //表达式结束，追加器里面有值
        if (numBuilder.length()>0){
            numStack.push(new BigDecimal(numBuilder.toString()));
        }

        while (!opStack.empty()){
            stackOperation(opStack,numStack);
        }
        return numStack.pop().doubleValue();
    }

    /**
     * 进行一次二元运算
     * @param opStack
     * @param numStack
     */
    public void stackOperation(Stack<String> opStack,Stack<BigDecimal> numStack){
        String opT = opStack.pop();              //栈顶运算符
        BigDecimal num2 = numStack.pop();       //第二个操作数
        BigDecimal num1 = numStack.pop();       //第一个操作数
        BigDecimal operationNum = oneOperation(opT,num1,num2);   //num1 op num2

        numStack.push(operationNum);            //把计算完的结果放入操作数栈
    }


//

    /**
     * 单次计算，计算为num1 op num2
     * @param op    运算符
     * @param num1  第一个操作数
     * @param num2  第二个操作数
     * @return  num1 op num2
     */
    public BigDecimal oneOperation(String op,BigDecimal num1,BigDecimal num2){
        BigDecimal result = new BigDecimal(0);
        switch (op){
            case "+":
                result = num1.add(num2);
                break;
            case "-":
                result = num1.subtract(num2);
                break;
            case "*":
                result = num1.multiply(num2);
                break;
            case "/":
                result = num1.divide(num2);
                break;
            default:
                break;
        }
        return result;
    }
    private boolean jubgmentPriority(String op1, String op2){
        return (OP_PRIORITY_MAP.get(op1) - OP_PRIORITY_MAP.get(op2)) <= 0;
    }
}


    