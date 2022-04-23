package com.veiw;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Color;

public class Homepage extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Homepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Find simple interest");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rdbtnNewRadioButton.setBounds(78, 99, 287, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Find Principal");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rdbtnNewRadioButton_1.setBounds(78, 137, 254, 39);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Find Rate");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rdbtnNewRadioButton_2.setBounds(78, 179, 199, 39);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Find  Time");
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		rdbtnNewRadioButton_3.setBounds(78, 221, 192, 39);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Find Total Amount");
		rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_4);
		rdbtnNewRadioButton_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rdbtnNewRadioButton_4.setBounds(78, 263, 310, 51);
		contentPane.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Database form for any object");
		rdbtnNewRadioButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_5);
		rdbtnNewRadioButton_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rdbtnNewRadioButton_5.setBounds(78, 317, 397, 39);
		contentPane.add(rdbtnNewRadioButton_5);
		
		JLabel lblNewLabel = new JLabel("Please Select The Desired Operation You want");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 45, 725, 58);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton_5_1 = new JRadioButton("Login For Billing and Recipt App");
		rdbtnNewRadioButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_5_1);
		rdbtnNewRadioButton_5_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rdbtnNewRadioButton_5_1.setBounds(78, 359, 397, 39);
		contentPane.add(rdbtnNewRadioButton_5_1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					Simpleinterest si=new Simpleinterest();
					si.setVisible(true);
					dispose();
				}else if (rdbtnNewRadioButton_1.isSelected()) {
					Principal pa=new Principal();
					pa.setVisible(true);
					dispose();
				}else if (rdbtnNewRadioButton_2.isSelected()) {
					Rate r=new Rate();
					r.setVisible(true);
					dispose();
				}else if (rdbtnNewRadioButton_3.isSelected()) {
					Time t=new Time();
					t.setVisible(true);
					dispose();
				}else if (rdbtnNewRadioButton_4.isSelected()) {
					TotalAmount tm=new TotalAmount();
					tm.setVisible(true);
					dispose();
					
				}
				else if (rdbtnNewRadioButton_5.isSelected()) {
					Databaseforanyobject db=new Databaseforanyobject();
					db.setVisible(true);
					dispose();
					
				}else {
					Home bill=new Home();
					bill.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(357, 433, 199, 58);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log=new Login();
				log.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_1.setBounds(701, 11, 182, 45);
		contentPane.add(btnNewButton_1);
	}
}
