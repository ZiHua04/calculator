package calculator;
import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame
{
	private JTextField text;//创建文本框的对象
	private GridBagConstraints gbc;
	private String[] ButtonLabels = {"%","√","x^2","1/x","CE","C","Back","÷","7","8","9","×","4","5","6","——","1","2","3","+"," ","0",".","="};
	public Calculator()
	{
		setTitle("calculator");//设置窗口标题
		setSize(720,480);//设置窗口大小
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口关闭方式
		
		text = new JTextField(20);//创建文本框
		
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
			PanelButton.add(buttons[i]);//添加到按钮面板上
		}
	    	
	    
	    add(PanelButton);
		
		setVisible(true);//使窗口可见
	}
	public static void main(String[] args)
	{
		new Calculator();
	}
}
