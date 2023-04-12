package calculator;

import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame {
    public Main() {
        setTitle("JButton Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Click Me"); // 创建一个按钮
        button.addActionListener(new ActionListener() { // 添加按钮的事件监听器
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello World"); // 弹出对话框并显示消息
            }
        });

        add(button); // 将按钮添加到窗口中

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
