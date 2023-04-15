package calculator;
import javax.swing.*;
import javafx.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener//继承JFrame，使用ActionListener的接口
{
	private JTextField text;//创建文本框的对象
	private GridBagConstraints gbc;
	private String[] ButtonLabels = {"%","√","x^2","1/x","CE","C","Back","÷","7","8","9","×","4","5","6","-","1","2","3","+"," ","0",".","="};
	private double result,num1,num2;
	private String operator;
	public Calculator()
	{
		setTitle("calculator");//设置窗口标题
		setSize(720,480);//设置窗口大小
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口关闭方式
		
		text = new JTextField(20);//创建文本框
		//text.setEditable(false);//让文本框变为不可输入
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		Font font = new Font("宋体", Font.PLAIN,50);//设置字体
		text.setFont(font);//将设置的字体添加到text文本框中
		
		JPanel PanelText = new JPanel();//创立一个文本面板
		PanelText.setLayout(new GridBagLayout());
		PanelText.add(text,gbc);//将文本框添加到文本面板里
		add(PanelText,BorderLayout.NORTH);//将文本面板添加进窗口的最上方中

		JPanel PanelButton = new JPanel(new GridLayout(6,4));//新建一个按钮面板
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
	
	public void actionPerformed(java.awt.event.ActionEvent e) {
		String label = ((JButton)e.getSource()).getText();
		int isPoint = 0;// 0表示没输入小数点 
		int NowIn = 1;//1表示输入第一个2表示输入第二个
		switch (label)
		{
			case "CE":
			{
				NowIn = 1;
				isPoint = 0;
				text.setText(" ");
				break;
			}
			case "C":
			{
				isPoint = 0;
				text.setText(" ");
				break;
			}
			case "Back":
			{
				String temp = text.getText();
				text.setText(temp.substring(0,temp.length()-1));
				break;
			}
			case "+":
			{
				if(NowIn == 1)
				{
					num1 = Double.parseDouble(text.getText());
					operator = "+";
					NowIn = 2;
					text.setText("");
				}
				else if(NowIn == 2)
				{
					
				}
				
			}
			case "-":
			{
				if(NowIn == 1)
				{
					num1 = Double.parseDouble(text.getText());
					operator = "-";
					NowIn = 2;
					text.setText("");
				}
				break;
			}
			case "×":
			{
				num1 = Double.parseDouble(text.getText());
				operator = "×";
				NowIn = 2;
				text.setText("");
				break;
			}
			case "÷":
			{
				num1 = Double.parseDouble(text.getText());
				operator = "÷";
				NowIn = 2;
				text.setText("");
				break;
			}
			case "=":
			{
				num2 = Double.parseDouble(text.getText());
				if(operator == "+")
				{
					result = num1 + num2;
					
				}else if(operator == "-")
				{
					result = num1 - num2;
				}else if(operator == "×")
				{
					result = num1 * num2;
				}else if(operator == "÷")
				{
					result = num1 / num2;
				}
				text.setText(Double.toString(result));
				break;
			}
			default:
			{
				if(NowIn == 2)
				{
					text.setText(" ");
				}
				text.setText(text.getText()+label);
			}
		
		}
	}
	public static void main(String[] args)
	{
		new Calculator();
	}
	
	
	
}
