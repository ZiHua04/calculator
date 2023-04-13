package calculator;
import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame
{
	private JTextField text;//创建文本框的对象
	private GridBagConstraints gbc;
	
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
		
		JPanel panel = new JPanel();//创立一个标签
		panel.setLayout(new GridBagLayout());
		panel.add(text,gbc);//将文本框添加到标签里
		add(panel,BorderLayout.NORTH);//将标签添加进窗口的最上方中

		JPanel PanelButton = new JPanel(new GridLayout(4,4));
		JButton[] buttons = new JButton[16];
	    for (int i = 0; i < buttons.length; i++) 
	    {
	        buttons[i] = new JButton(""+(i + 1));
	        PanelButton.add(buttons[i]);
	    }
	    add(PanelButton);
		
		setVisible(true);//使窗口可见
	}
	public static void main(String[] args)
	{
		new Calculator();
	}
}
