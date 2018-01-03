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




//�½�һ�����ֹ����� ��һ��
class GUIFrame extends JFrame{
	//���캯��
	public GUIFrame(){
		//����������Ͻ�ȡ��
		setTitle("xiaoqiang");
		//������������С
		setSize(500, 300);
		//������������Ƿ�ɼ���
		setVisible(true);
		//��ιرմ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ӣ�һ����
		add(new Canvas());
		
		//�½�һ���ı����������������
		JLabel label = new JLabel("����һ���ı���");
		//���һ���ı��򣬷������м�
		add(label, BorderLayout.CENTER);
		//BorderLayout.NORTH
		//BorderLayout.SOUTH
		//BorderLayout.WEST
		//BorderLayout.EAST
		
		//�½�һ����ť
		JButton btnRed = new JButton("Red");	
		//����ť���ı��򱳾���ɫ���
		btnRed.addActionListener(e ->{
			label.setBackground(Color.red);
			//����������ɫ
			label.setForeground(Color.YELLOW);
		});	
		//���һ����ť,����������
		add(btnRed, BorderLayout.SOUTH);
		
		//�½�һ��JCheckBox
		JCheckBox italic = new JCheckBox("Italic");
		//�򹴣��ı��������б��
		italic.addActionListener(e->{
			//�½�һ��Ĭ������
			int mode = 0;
			//�Ƿ�ѡ��
			if(italic.isSelected()){
				mode += Font.ITALIC;
			}
			//��label�������
			label.setFont(new Font("Serif", mode, 30));
		});
		add(italic, BorderLayout.NORTH);
		
		//JRadioButton�½���
		ButtonGroup group = new ButtonGroup();
		//�½�JRadioButton
		JRadioButton smallRB = new JRadioButton("��С");
		JRadioButton bigRB = new JRadioButton("���");	
		//����
		smallRB.addActionListener(e->{
			label.setFont(new Font("Serif", Font.PLAIN, 5));
		});
		bigRB.addActionListener(e->{
			label.setFont(new Font("Serif", Font.PLAIN, 40));
		});
		
		//��JRadioButton��ӵ�����
		group.add(smallRB);
		group.add(bigRB);
		//����(����)
		JPanel jp = new JPanel();
		jp.add(smallRB);
		jp.add(bigRB);
		jp.add(italic);
		//���
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
		
		//JToolBar������
		//�½�JToolBar
		JToolBar bar = new JToolBar();
		//�ڰ�ť�����ͼƬ�ķ���
		//JButton btnRed = new JButton(new ImageIcon("red-ball.gif"));
		//�½���ť
		JButton toolButton1 = new JButton("JToolBar1");
		JButton toolButton2 = new JButton("JToolBar2");
		//��button����¼���ͬ��
		toolButton1.addActionListener(e->{
			label.setForeground(Color.PINK);
		});
		//��JToolBar����Ӱ�ť
		bar.add(toolButton1);
		bar.add(toolButton2);
		//��JToolBar��ӵ����ֹ�������
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
			
			//JOptionPane.showMessageDialog(null, "Сǿ��˧");
			
			
			
			
			
			//int retConfirm = JOptionPane.showConfirmDialog(null, "Сǿ˧��");
			
			
			//String inputText = JOptionPane.showInputDialog("Сǿ˧��");
		
		
		
			//label.setText(inputText);
		
		
		});

		UserPwdDialog dialog =  new UserPwdDialog();
		dialog.setVisible(true);

		/*
		
		//JMenu
		JMenu editMenu = new JMenu("Edit");
		mnuBar.add(editMenu);
		//�����˵�
		JMenu blue = new JMenu("blue");
		JMenuItem reditem = new JMenuItem("��ɫ");
		JMenuItem blueitem1 = new JMenuItem("ǳ��ɫ");
		JMenuItem blueitem2 = new JMenuItem("����ɫ");
		editMenu.add(reditem);
		editMenu.add(blue);
		blue.add(blueitem1);
		blue.add(jp);
		//����
		reditem.addActionListener(e->{
			label.setForeground(Color.RED);
			String input = JOptionPane.showInputDialog("Type here");
			label.setText(input);
		});
		*/
		
		//JOptionPane.showMessageDialog(null, "Hello the Dialog World!");
		//int retConfirm = JOptionPane.showConfirmDialog(null, "Accept the offer?");
		//String inputText = JOptionPane.showInputDialog("What's your favorite book?");
		

		//��ʼִ��
		validate();
		
	}
}


//��һ��ֱ��
class Canvas extends JPanel{
	
	protected void paintComponent(Graphics g){
		//ʹ�ø��෽��
		super.paintComponent(g);
		
		//��һ��ֱ�ߣ��ӣ�0�� 0����ʼ������500�� 300������
		g.drawLine(0, 0, 500, 300);
		
		
	}
}







public class Displaying {

	public static void main(String[] args) {
		new GUIFrame();
	}

}













class UserPwdDialog extends JDialog {
		//���캯��
	   public UserPwdDialog() {
	   JPanel southP = new JPanel();
	   JButton okBtn = new JButton("OK");
	   JButton cancelBtn = new JButton("Cancel");
	   southP.add(okBtn);
	   southP.add(cancelBtn);
	   add(southP, BorderLayout.SOUTH);
	   }
	}









