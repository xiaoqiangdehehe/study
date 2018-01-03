import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;




//新建一个布局管理器 第一步
class GUIFrame extends JFrame{
	//构造函数
	public GUIFrame(){
		//给软件的左上角取名
		setTitle("xiaoqiang");
		//设置软件界面大小
		setSize(500, 300);
		//设置这个界面是否可见；
		setVisible(true);
		//如何关闭窗口
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//添加：一条线
		add(new Canvas());
		
		//新建一个文本框，设置里面的文字
		JLabel label = new JLabel("我是一个文本框");
		//添加一个文本框，放置在中间
		add(label, BorderLayout.CENTER);
		//BorderLayout.NORTH
		//BorderLayout.SOUTH
		//BorderLayout.WEST
		//BorderLayout.EAST
		
		//新建一个按钮
		JButton btnRed = new JButton("Red");	
		//按按钮，文本框背景颜色变红
		btnRed.addActionListener(e ->{
			label.setBackground(Color.red);
			//设置字体颜色
			label.setForeground(Color.YELLOW);
		});	
		//添加一个按钮,放置在下面
		add(btnRed, BorderLayout.SOUTH);
		
		//新建一个JCheckBox
		JCheckBox italic = new JCheckBox("Italic");
		//打勾，文本框字体变斜体
		italic.addActionListener(e->{
			//新建一个默认字体
			int mode = 0;
			//是否被选中
			if(italic.isSelected()){
				mode += Font.ITALIC;
			}
			//给label添加字体
			label.setFont(new Font("Serif", mode, 30));
		});
		add(italic, BorderLayout.NORTH);
		
		//JRadioButton新建组
		ButtonGroup group = new ButtonGroup();
		//新建JRadioButton
		JRadioButton smallRB = new JRadioButton("变小");
		JRadioButton bigRB = new JRadioButton("变大");	
		//作用
		smallRB.addActionListener(e->{
			label.setFont(new Font("Serif", Font.PLAIN, 5));
		});
		bigRB.addActionListener(e->{
			label.setFont(new Font("Serif", Font.PLAIN, 40));
		});
		
		//把JRadioButton添加到组里
		group.add(smallRB);
		group.add(bigRB);
		//并列(容器)
		JPanel jp = new JPanel();
		jp.add(smallRB);
		jp.add(bigRB);
		jp.add(italic);
		//添加
		add(jp, BorderLayout.NORTH);
	
		
	//	add(smallRB,BorderLayout.NORTH);
	//	add(bigRB,BorderLayout.NORTH);
		
		JComboBox<String> faceCombo = new JComboBox<>();
		faceCombo.addItem("Serif");
		faceCombo.addItem("SansSerif");
		faceCombo.addItem("Monospaced");
		
		faceCombo.addActionListener(event->{
			label.setFont(new Font( (String)faceCombo.getSelectedItem(), Font.PLAIN, 24));
		});

		jp.add(faceCombo, BorderLayout.EAST);
		
		//JToolBar工具栏
		//新建JToolBar
		JToolBar bar = new JToolBar();
		//在按钮上添加图片的方法
		//JButton btnRed = new JButton(new ImageIcon("red-ball.gif"));
		//新建按钮
		JButton toolButton1 = new JButton("JToolBar1");
		JButton toolButton2 = new JButton("JToolBar2");
		//给button添加事件，同上
		toolButton1.addActionListener(e->{
			label.setForeground(Color.PINK);
		});
		//在JToolBar里添加按钮
		bar.add(toolButton1);
		bar.add(toolButton2);
		//把JToolBar添加到布局管理器里
		add(bar, BorderLayout.WEST);
		
		
		//JMenuBar
		JMenuBar mnuBar = new JMenuBar();
		setJMenuBar(mnuBar);
		
		JMenu Editmenu = new JMenu("edit");
		mnuBar.add(Editmenu);
		
		JMenuItem reditem = new JMenuItem("red");
		Editmenu.add(reditem);
		
		JMenu bluemenu = new JMenu("blue");
		Editmenu.add(bluemenu);
		
		JMenuItem pinkitem = new JMenuItem("pink");
		bluemenu.add(pinkitem);
		
		pinkitem.addActionListener(e->{
			
			//JOptionPane.showMessageDialog(null, "小强最帅");
			
			
			
			
			
			//int retConfirm = JOptionPane.showConfirmDialog(null, "小强帅吗？");
			
			
			//String inputText = JOptionPane.showInputDialog("小强帅吗？");
		
		
		
			//label.setText(inputText);
		
		
		});

		UserPwdDialog dialog =  new UserPwdDialog();
		dialog.setVisible(true);

		/*
		
		//JMenu
		JMenu editMenu = new JMenu("Edit");
		mnuBar.add(editMenu);
		//下拉菜单
		JMenu blue = new JMenu("blue");
		JMenuItem reditem = new JMenuItem("红色");
		JMenuItem blueitem1 = new JMenuItem("浅蓝色");
		JMenuItem blueitem2 = new JMenuItem("深蓝色");
		editMenu.add(reditem);
		editMenu.add(blue);
		blue.add(blueitem1);
		blue.add(jp);
		//作用
		reditem.addActionListener(e->{
			label.setForeground(Color.RED);
			String input = JOptionPane.showInputDialog("Type here");
			label.setText(input);
		});
		*/
		
		//JOptionPane.showMessageDialog(null, "Hello the Dialog World!");
		//int retConfirm = JOptionPane.showConfirmDialog(null, "Accept the offer?");
		//String inputText = JOptionPane.showInputDialog("What's your favorite book?");
		

		//开始执行
		validate();
		
	}
}


//画一条直线
class Canvas extends JPanel{
	
	protected void paintComponent(Graphics g){
		//使用父类方法
		super.paintComponent(g);
		
		//画一条直线，从（0， 0）开始，到（500， 300）结束
		g.drawLine(0, 0, 500, 300);
		
		
	}
}







public class Displaying {

	public static void main(String[] args) {
		new GUIFrame();
	}

}













class UserPwdDialog extends JDialog {
		//构造函数
	   public UserPwdDialog() {
	   JPanel southP = new JPanel();
	   JButton okBtn = new JButton("OK");
	   JButton cancelBtn = new JButton("Cancel");
	   southP.add(okBtn);
	   southP.add(cancelBtn);
	   add(southP, BorderLayout.SOUTH);
	   }
	}









