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
		new InfoFrame();    //newһ��InforFrame����ʹ�ù��캯��
	}

}

class InfoFrame extends JFrame{     //InforFrame��̳�JFrame��JFrame��һ����������ͼ�ν������
	public InfoFrame(){             //���캯��
		this.setSize(300, 300);     //���ý���ĳ��Ϳ�
		this.setTitle("My Info Windows");    //���ý���ı���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //���ô��ڹرյķ���������ı䣬��ס�ͺ�
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();   //��ȡ������Ļ�ߴ��С 
		this.setLocation(screenSize.width/2 - getSize().width/2, screenSize.height/2 - getSize().height/2);   //���ô��ڽ�����Ե�����Ļ��λ��
		this.setVisible(true);           //���ô��ڽ����ڵ�����Ļ���ǿɼ���
		add(new Canvas(), BorderLayout.CENTER);       //���һ��canvas�������󣬷����ڴ��ڵ��м�
		add(new JButton("Click Me"), BorderLayout.SOUTH);   //���һ�������������ڴ�������
	}
}

class Canvas extends JComponent{      //Canvas��̳�JComponent��JComponent��һ�����������Բ��ù�
	
	@Override
	protected void paintComponent(Graphics g){   //��дJComponent�е�paintComponent��������
		g.setColor(Color.RED);                    //������ɫΪ��ɫ
		g.drawString("Name: Si YaQi", 100, 100);  //д���ַ�������������Դ��ڵ�λ��
		g.drawString("ID: 201523071", 100, 110);
		g.drawString("Major: EC", 100, 120);
	}
}