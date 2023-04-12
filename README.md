# calculator
scu22科研训练-软件开发小队第一次作业- 计算器
zzh
package learn;

import javax.swing.*;

public class 计算器 {
    public static void main(String[] args) {
        // 1. 创建一个顶层容器（窗口）
        // 创建窗口,JFrame表示顶层窗口
        JFrame jf = new JFrame("简易计算器");
        // 2.setSize功能实现设置窗口大小
        jf.setSize(500, 500);
        // 3.把窗口位置设置到屏幕中心
        jf.setLocationRelativeTo(null);
        // 4.当点击窗口的关闭按钮时退出程序（没有这一句，程序不会退出）
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 5. 创建中间容器（面板容器）
        // 创建面板容器，使用默认的布局管理器
        JPanel panel = new JPanel();
        // 6. 创建一个基本组件（按钮），并添加到 面板容器 中
        JButton btn0=new JButton("0");
        panel.add(btn0);
        JButton btn1 = new JButton("1");
        panel.add(btn1);
        JButton btn2=new JButton("2");
        panel.add(btn2);
        JButton btn3=new JButton("3");
        panel.add(btn3);
        JButton btn4=new JButton("4");
        panel.add(btn4);
        JButton btn5=new JButton("5");
        panel.add(btn5);
        JButton btn6=new JButton("6");
        panel.add(btn6);
        JButton btn7=new JButton("7");
        panel.add(btn7);
        JButton btn8=new JButton("8");
        panel.add(btn8);
        JButton btn9=new JButton("9");
        panel.add(btn9);
        JButton btn_add=new JButton("+");
        panel.add(btn_add);
        JButton btn_sub=new JButton("-");
        panel.add(btn_sub);
        JButton btn_eql=new JButton("=");
        panel.add(btn_eql);
        JButton btn_div=new JButton("/");
        panel.add(btn_div);
        JButton btn_mul=new JButton("*");
        panel.add(btn_mul);
        // 4. 把 面板容器 作为窗口的内容面板 设置到 窗口
        jf.setContentPane(panel);
        // 5. 显示窗口，前面创建的信息都在内存中，通过 jf.setVisible(true) 把内存中的窗口显示在屏幕上。
        jf.setVisible(true);//设置可见性
    }
}

