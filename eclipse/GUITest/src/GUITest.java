import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class GUITest {

	public static void main(String[] args) {
		new InfoFrame();    //new一个InforFrame对象，使用构造函数
	}

}

class InfoFrame extends JFrame{     //InforFrame类继承JFrame，JFrame是一个构造计算机图形界面的类
	public InfoFrame(){             //构造函数
		this.setSize(300, 300);     //设置界面的长和宽
		this.setTitle("My Info Windows");    //设置界面的标题
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //设置窗口关闭的方法，不会改变，记住就好
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();   //获取电脑屏幕尺寸大小 
		this.setLocation(screenSize.width/2 - getSize().width/2, screenSize.height/2 - getSize().height/2);   //设置窗口界面相对电脑屏幕的位置
		this.setVisible(true);           //设置窗口界面在电脑屏幕上是可见的
		add(new Canvas(), BorderLayout.CENTER);       //添加一个canvas（）对象，放置在窗口的中间
		add(new JButton("Click Me"), BorderLayout.SOUTH);   //添加一个按键，放置在窗口下面
	}
}

class Canvas extends JComponent{      //Canvas类继承JComponent，JComponent是一个容器，可以不用管
	
	@Override
	protected void paintComponent(Graphics g){   //重写JComponent中的paintComponent（）方法
		g.setColor(Color.RED);                    //设置颜色为红色
		g.drawString("Name: Si YaQi", 100, 100);  //写入字符串，并设置相对窗口的位置
		g.drawString("ID: 201523071", 100, 110);
		g.drawString("Major: EC", 100, 120);
	}
}