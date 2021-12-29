package FA.PA4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Frame extends JFrame {
	Frame() {
		setTitle("Football Analyzer");
		setSize(270, 150);
		setMinimumSize(new Dimension(270, 150));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JButton button1 = new JButton("Show rank");
		button1.setBounds(10, 10, 250, 25);
		panel.add(button1);
		button1.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Login Success");
					}
				}
		);
		
		JButton button2 = new JButton("Make your own rank");
		button2.setBounds(10, 40, 250, 25);
		panel.add(button2);
		button2.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Login Fail");
					}
				}
		);
		
		JButton button3 = new JButton("Simulate a game");
		button3.setBounds(10, 70, 250, 25);
		panel.add(button3);
		button3.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//
					}
				}
		);
		
		Container c = getContentPane(); 
		c.add(panel);
		pack();
		setVisible(true);
	}
}
