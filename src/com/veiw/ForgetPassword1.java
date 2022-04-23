package com.veiw;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.stream.IntStream;

import javax.swing.JPasswordField;

public class ForgetPassword1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgetPassword1 frame = new ForgetPassword1();
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
	public ForgetPassword1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 580);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(338, 161, 163, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblRetypePassword = new JLabel("Re-type Password");
		lblRetypePassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRetypePassword.setBounds(338, 275, 163, 33);
		contentPane.add(lblRetypePassword);
		
		JButton btnNewButton = new JButton("change");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					String username=textField_2.getText();
					String pass=passwordField.getText();
					String pass1=passwordField_1.getText();
					PreparedStatement pst= conn.prepareStatement("select username from signup where username=?");
					pst.setString(1,username);
					ResultSet rs=pst.executeQuery();
					
							
							 if(textField_2.getText().isBlank()&& textField_2.getText().isEmpty()) {
									JOptionPane.showMessageDialog(null, "Username field is empty");

								}else if(passwordField.getText().isBlank()&& passwordField.getText().isEmpty()) {
									JOptionPane.showMessageDialog(null, "password field is empty");
									
								}else if(passwordField_1.getText().isBlank()&& passwordField_1.getText().isEmpty()) {
									JOptionPane.showMessageDialog(null, "password field 2 is empty");
									

								}else if(rs.next()) {
										PreparedStatement pst1= conn.prepareStatement("update signup Set password=? where username=?");
										pst1.setString(1, pass1);
										pst1.setString(2, username);
										int rowsUpdated = pst1.executeUpdate();
								 if (rowsUpdated > 0) {
								JOptionPane.showMessageDialog(null, "password changed successfully");

							}else {
								JOptionPane.showMessageDialog(null, "Password not changed : returns 0 update from server !!!!");
							}
			
								}else {
									JOptionPane.showMessageDialog(null, "Username Doesn't match!!");

								}
				
								
						
						
						
					
					
						

					
				} catch (SQLException e1) {
					System.out.println("Exception occurred.");
					System.out.println(e1.getMessage());
				}
			}
		});
		btnNewButton.setBounds(349, 394, 113, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Back");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ForgetPassword fp=new ForgetPassword();
				fp.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(368, 455, 87, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Back to login page");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login lg=new Login();
				lg.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(368, 484, 156, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(338, 41, 163, 33);
		contentPane.add(lblUsername);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(255, 93, 321, 33);
		contentPane.add(textField_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(255, 217, 321, 33);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(255, 328, 321, 33);
		contentPane.add(passwordField_1);
	}
}

	
