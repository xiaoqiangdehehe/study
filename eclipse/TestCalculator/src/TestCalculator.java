import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestCalculator {

	public static void main(String[] args) {
		CalculatorFrame cal = new CalculatorFrame();
	}

}

class CalculatorFrame extends JFrame {
	public CalculatorFrame() {
		setTitle("Si Ya Qi's Calculator");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JTextField display = new JTextField();
		display.setHorizontalAlignment(JTextField.RIGHT);
		display.setEditable(false);
		add(display, BorderLayout.NORTH);
		
		JPanel numPad = new JPanel();
		numPad.setLayout(new GridLayout(4, 4));
		JButton[] btns = new JButton[16];
		for (int i = 0; i < btns.length; ++i){
			int j = i;
			switch (i){
			case 0: case 1: case 2: case 4: case 5: case 6: case 8: case 9: case 10:
				if(j < 3)
					j += 7;
				else if(j > 7)
					j -= 7;
				btns[i] = new JButton("" + j);	
				break;
			case 3:	
				btns[i] = new JButton("/");
				break;
			case 7:	
				btns[i] = new JButton("*");
				break;
			case 11:	
				btns[i] = new JButton("-");
				break;
			case 12:	
				btns[i] = new JButton("" + 0);
				break;
			case 13:	
				btns[i] = new JButton(".");
				break;
			case 14:	
				btns[i] = new JButton("=");
				break;
			case 15:	
				btns[i] = new JButton("+");
				break;
			}
			btns[i].addActionListener((e) ->{
				String str = e.getActionCommand();
				display.setText(display.getText() + str);
			});
			numPad.add(btns[i]);
		}
		add(numPad, BorderLayout.CENTER);
		validate();
		pack();
	}
}