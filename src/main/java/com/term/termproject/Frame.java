package com.term.termproject;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;

class Frame extends JFrame {
	HashMap<Integer, Player> playerlist;

	Frame(HashMap<Integer, Player> playerlist) {
		this.playerlist = playerlist;
	}

	void Mainpage() {
		setTitle("Football Analyzer");
		setMinimumSize(new Dimension(500, 1000));
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JLabel label = new JLabel("English Premier League Analyzer");
		label.setBounds(100, 0, 300, 100);
		panel.add(label);
		JButton button0 = new JButton("View Information");
		button0.setBounds(100, 100, 300, 50);
		panel.add(button0);
		button0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createInfoView();
			}
		});
		JButton button1 = new JButton("Show rank");
		button1.setBounds(100, 150, 300, 50);
		panel.add(button1);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createRankView();
			}
		});

		JButton button2 = new JButton("Make your own rank");
		button2.setBounds(100, 200, 300, 50);
		panel.add(button2);
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Login Fail");
			}
		});

		JButton button3 = new JButton("Simulate a game");
		button3.setBounds(100, 250, 300, 50);
		panel.add(button3);
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		Container c = getContentPane();
		c.add(panel);
		pack();
		setVisible(true);
	}

	void createInfoView() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame("Test");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
				JPanel panel = new JPanel();

				panel.setOpaque(true);
				JTextArea textArea = new JTextArea(30, 50);
				textArea.setWrapStyleWord(true);

				textArea.setFont(Font.getFont(Font.SANS_SERIF));
				JScrollPane scroller = new JScrollPane(textArea);

				JPanel inputpanel = new JPanel();
				inputpanel.setLayout(null);
				JTextField team = new JTextField(20);
				inputpanel.add(team);

				panel.add(scroller);

				panel.add(inputpanel);
				frame.getContentPane().add(BorderLayout.CENTER, panel);
				frame.pack();
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
				frame.setResizable(false);
				team.requestFocus();
			}
		});
	}

	void createRankView() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame("Test");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}

				final JPanel panel = new JPanel();
				panel.setOpaque(true);
				
				Container c = getContentPane();
				
				
				final ArrayList<String> list = new ArrayList<String>();
				for (int i = 0; i<10; i++) {
					String temp = playerlist.get(i).getName();
					int temp2 = playerlist.get(i).getGoals();
					temp.concat("   ");
					temp.concat(Integer.toString(temp2));
					list.add(temp);
				}

			

				
				
				
				JPanel inputpanel = new JPanel();
				inputpanel.setLayout(new GridLayout(4, 4));
				JButton goal = new JButton("Goals");
				goal.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						final JList players = new JList(list.toArray());
						panel.add(players);
						
					}
				});
				JButton assists = new JButton("Assists");
				JButton min = new JButton("Minutes");
				JButton saves = new JButton("Saves");

				
				inputpanel.add(goal);
				inputpanel.add(assists);
				inputpanel.add(min);
				inputpanel.add(saves);
				panel.add(inputpanel);
				frame.getContentPane().add(BorderLayout.CENTER, panel);
				frame.pack();
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
				frame.setResizable(false);

			}
		});
	}
}
