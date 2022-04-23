package com.veiw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField txtForgetPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 481);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(456, 11, 500, 71);
		contentPane.add(lblNewLabel);
		
		JTextPane txtpnUsername = new JTextPane();
		txtpnUsername.setBackground(Color.LIGHT_GRAY);
		txtpnUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnUsername.setText("Username");
		txtpnUsername.setBounds(144, 150, 115, 20);
		contentPane.add(txtpnUsername);
		
		textField = new JTextField();
		textField.setBounds(400, 150, 199, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(144, 233, 115, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String user= textField.getText();
					String pass=passwordField.getText();
				Connection conn;
					conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					PreparedStatement pst = conn.prepareStatement("select username,password from SIGNUP where username=? and password=?");
					pst.setString(1, user);
					pst.setString(2, pass );
					ResultSet rs = pst.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Login successfull...!!");
						Homepage home=new Homepage();
						home.setVisible(true);
						dispose();
					}
					else if (textField.getText().isEmpty() && textField.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "The username field is empty :null");
					}else if(passwordField.getText().isEmpty()&& passwordField.getText().isBlank()){
					JOptionPane.showMessageDialog(null, "The Password field is empty field is empty :null");
				}
				else {				
						JOptionPane.showMessageDialog(null, "USERNAME OR PASSWORD incorrect please check");
						
						
						textField.setText("");
						passwordField.setText("");
					}
					
									
					
				 }catch (SQLException e1) {
					e1.printStackTrace();
				
				}
				
				
			}
			
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(328, 319, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Signup");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Signup signinto= new Signup();
				signinto.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_2.setBounds(328, 366, 163, 45);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(400, 232, 211, 20);
		contentPane.add(passwordField);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("show password");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox.isSelected()) {
						passwordField.setEchoChar((char) 0);
				}else {
					passwordField.setEchoChar('*'); 

				}
			}
		});
		chckbxNewCheckBox.setBounds(400, 276, 103, 23);
		contentPane.add(chckbxNewCheckBox);
		
		txtForgetPassword = new JTextField();
		txtForgetPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ForgetPassword fp=new ForgetPassword();
				fp.setVisible(true);
				dispose();
			}
		});
		txtForgetPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtForgetPassword.setText("Forget password?");
		txtForgetPassword.setBounds(317, 404, 186, 29);
		contentPane.add(txtForgetPassword);
		txtForgetPassword.setColumns(10);
		
	}
}
