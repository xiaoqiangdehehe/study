
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * A frame with a calculator panel.
 */
public class RightCalculatorFrame extends JFrame {
	String lastCommand = "=";
	double result = 0;
	JTextField display = new JTextField();
	boolean start = true;
	
	public RightCalculatorFrame() {
		setTitle("Swing Components");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		// Add the display
		
		add(display, BorderLayout.NORTH);
		
		// Define all Buttons
		JButton btnAdd = new JButton("+");
		JButton btnMinus = new JButton("-");
		JButton btnTimes = new JButton("*");
		JButton btnDivision = new JButton("/");
		JButton btnDot = new JButton(".");
		JButton btnEqu = new JButton("=");
		
		btnAdd.addActionListener(new ArithmaticListener());
		btnMinus.addActionListener(new ArithmaticListener());
		btnTimes.addActionListener(new ArithmaticListener());
		btnDivision.addActionListener(new ArithmaticListener());
		btnEqu.addActionListener(new ArithmaticListener());

		JButton[] btnNums = new JButton[10];
		for (int i = 0; i < 10; ++i) {
			btnNums[i] = new JButton("" + i);
			btnNums[i].addActionListener(new NumberInputListener());
		}
		btnDot.addActionListener(new NumberInputListener());

		// Add the number pad
		JPanel p = new JPanel();
		// Set 4*4 Grid Layout
		p.setLayout(new GridLayout(4, 4));
		p.add(btnNums[7]);
		p.add(btnNums[8]);
		p.add(btnNums[9]);
		p.add(btnDivision);

		p.add(btnNums[4]);
		p.add(btnNums[5]);
		p.add(btnNums[6]);
		p.add(btnTimes);

		p.add(btnNums[1]);
		p.add(btnNums[2]);
		p.add(btnNums[3]);
		p.add(btnMinus);

		p.add(btnNums[0]);
		p.add(btnDot);
		p.add(btnEqu);
		p.add(btnAdd);
		add(p, BorderLayout.CENTER);
		pack();
	}
	
	class NumberInputListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String num = e.getActionCommand();
			if (start) {
				display.setText(num);
				start = false;
			}
			else
				display.setText(display.getText()+num);			
		}	
	}
	
	class ArithmaticListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			start = true;
			String command = e.getActionCommand();
			double x = Double.parseDouble(display.getText());
			if (lastCommand.equals("+"))
				result += x;
			else if (lastCommand.equals("-"))
				result -= x;
			else if (lastCommand.equals("*"))
				result *= x;
			else if (lastCommand.equals("/"))
				result /= x;
			else if (lastCommand.equals("="))
				result = x;
			display.setText(""+result);
			lastCommand = command;
		}
	}
}


