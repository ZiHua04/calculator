package calculator;
import javax.swing.*;
public class calculator extends JFrame
{
	public calculator()
	{
		//标题
		setTitle("my calculator");
		setSize(400,500);
		//创建面板
		JPanel panel=new JPanel();
		//创建按钮
		JButton butten0 =new JButton("0");
		
		JButton butten1 =new JButton("1");
		butten1.setBounds(10, 1, 30, 30); 
		JButton butten2 =new JButton("2");
		JButton butten3 =new JButton("3");
		JButton butten4 =new JButton("4");
		JButton butten5 =new JButton("5");
		JButton butten6 =new JButton("6");
		JButton butten7 =new JButton("7");
		JButton butten8 =new JButton("8");
		JButton butten9 =new JButton("9");
		JButton butten10=new JButton("+");
		JButton butten11=new JButton("-");
		JButton butten12=new JButton("*");
		JButton butten13=new JButton("/");
		JButton butten14=new JButton("=");
		JButton butten15=new JButton("AC");
		//添加按钮至面板
		panel.add(butten0);
		panel.add(butten1);
		panel.add(butten2);
		panel.add(butten3);
		panel.add(butten4);
		panel.add(butten5);
		panel.add(butten6);
		panel.add(butten7);
		panel.add(butten8);
		panel.add(butten9);
		panel.add(butten10);
		panel.add(butten11);
		panel.add(butten12);
		panel.add(butten13);
		panel.add(butten14);
		panel.add(butten15);
		butten0.setBounds(100, 100, 50, 50);
		//添加面板至窗口
		add(panel);
		//窗口关闭默认操作
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//显示窗口
		setVisible(true);
	}
	public static void main(String[] args) {
		calculator cal=new calculator();
	}
}

