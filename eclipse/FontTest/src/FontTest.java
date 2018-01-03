import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class FontTest {

	public static void main(String[] args) {
	new FontFrame();

	}

}

class FontFrame extends JFrame {

	JCheckBox bold = new JCheckBox("Bold");
	JCheckBox italic = new JCheckBox("Italic");
	JRadioButton small = new JRadioButton("Small");
	JRadioButton middle = new JRadioButton("Middle");
	JRadioButton large = new JRadioButton("Large");
	JRadioButton vlarge = new JRadioButton("VeryLarge");
	int fontSize = 10;
	int smallSize = 5;
	int middleSize = 10;
	int largeSize = 20;
	int vLargeSize = 40;
	JLabel display;
	
	public FontFrame() {
		
		setTitle("Change Font");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		display = new JLabel();
		display.setText("The quick brown fox jumps over the lazy dog");
		
		add(display, BorderLayout.CENTER);
		
		JPanel btnP = new JPanel();
		btnP.add(bold);
		btnP.add(italic);
		btnP.add(small);
		btnP.add(middle);
		btnP.add(large);
		btnP.add(vlarge);
		
		ButtonGroup bg = new ButtonGroup();;
		bg.add(small);
		bg.add(middle);
		bg.add(large);
		bg.add(vlarge);
		add(btnP, BorderLayout.SOUTH);
		
		bold.addActionListener(e -> changeFont());		
		italic.addActionListener(e -> changeFont());
		small.addActionListener(e -> changeFont());
		middle.addActionListener(e -> changeFont());
		large.addActionListener(e -> changeFont());
		vlarge.addActionListener(e -> changeFont());
		
		pack();
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
		else if(vlarge.isSelected())
			fontSize = vLargeSize;
		display.setFont(new Font("Serif", mode, fontSize));
	}
}