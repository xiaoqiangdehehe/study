import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

public class FontGUITest {

	public static void main(String[] args) {
		new FontGUI();
	}

}

class FontGUI extends JFrame {
	
	JCheckBox bold = new JCheckBox("Bold");
	JCheckBox italic = new JCheckBox("Italic");
	JRadioButton large = new JRadioButton("Large");
	JRadioButton middle = new JRadioButton("Middle");
	JRadioButton small = new JRadioButton("Small");
	int fontSize = 12;
	int largeSize = 30;
	int middleSize = 15;
	int smallSize = 10;
	JLabel label;
	
	public FontGUI() {
		setTitle("Menu Test Frame");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 200);
		
		label = new JLabel("The quick brown fox jumps over the lazy dog.");
		add(label, BorderLayout.CENTER);
		
		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		
		JMenu inputMnu = new JMenu("Input");
		JMenu edit = new JMenu("Edit");
		JMenu color = new JMenu("Color");
		JMenu font = new JMenu("Font");
		mb.add(inputMnu);
		mb.add(edit);
		edit.add(color);
		edit.add(font);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(large);
		bg.add(middle);
		bg.add(small);
		
		JMenuItem newItem = new JMenuItem("New");
		JMenuItem redItem = new JMenuItem("Red");
		JMenuItem greenItem = new JMenuItem("Green");
		JMenuItem blueItem = new JMenuItem("Blue");
		inputMnu.add(newItem);
		color.add(redItem);
		color.add(greenItem);
		color.add(blueItem);
		font.add(bold);
		font.add(italic);
		font.add(large);
		font.add(middle);
		font.add(small);
		
		newItem.addActionListener(e -> {
			String input = JOptionPane.showInputDialog("Type here");
			label.setText(input);
		});
		redItem.addActionListener(e -> label.setForeground(Color.red));
		greenItem.addActionListener(e -> label.setForeground(Color.green));
		blueItem.addActionListener(e -> label.setForeground(Color.blue));
		bold.addActionListener(e -> changeFont());		
		italic.addActionListener(e -> changeFont());
		large.addActionListener(e -> changeFont());
		middle.addActionListener(e -> changeFont());
		small.addActionListener(e -> changeFont());
		
		JToolBar tb = new JToolBar();		
		JButton redBtn = new JButton(new ImageIcon("src/red-ball.gif"));
		JButton greenBtn = new JButton(new ImageIcon("src/green-ball.gif"));
		JButton blueBtn = new JButton(new ImageIcon("src/blue-ball.gif"));
		tb.add(redBtn);
		tb.add(greenBtn);
		tb.add(blueBtn);
		add(tb, BorderLayout.NORTH);
		
		redBtn.addActionListener(e -> label.setForeground(Color.red));
		greenBtn.addActionListener(e -> label.setForeground(Color.green));
		blueBtn.addActionListener(e -> label.setForeground(Color.blue));
	}
	
	void changeFont() {
		int mode = Font.PLAIN;
		if(bold.isSelected())
			mode += Font.BOLD;
		if(italic.isSelected())
			mode += Font.ITALIC;
		if(small.isSelected())
			fontSize = smallSize;
		else if(middle.isSelected())
			fontSize = middleSize;
		else if(large.isSelected())
			fontSize = largeSize;
		label.setFont(new Font("Serif", mode, fontSize));
	}
}