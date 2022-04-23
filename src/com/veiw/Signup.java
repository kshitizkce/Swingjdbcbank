package com.veiw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

public class Signup extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JRadioButton male;
	private JRadioButton female;
	private JRadioButton others;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(34, 47, 185, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLastName.setBounds(34, 104, 185, 39);
		contentPane.add(lblLastName);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sex");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(34, 154, 185, 39);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Purpose of use");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(34, 204, 185, 39);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Age");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(34, 254, 185, 39);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(34, 304, 185, 39);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Signup Form");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(434, -14, 300, 70);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(369, 60, 203, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(369, 117, 203, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButton male = new JRadioButton("male");
		male.setBounds(370, 166, 111, 23);
		contentPane.add(male);
		
		JRadioButton female = new JRadioButton("female");
		female.setBounds(537, 166, 111, 23);
		contentPane.add(female);
		
		JRadioButton others = new JRadioButton("others");
		others.setBounds(708, 166, 111, 23);
		contentPane.add(others);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Education", "Self learning", "Business", "Banking", "Governmental", "Student", "Home purpose"}));
		comboBox.setBounds(369, 216, 203, 22);
		contentPane.add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.setBounds(369, 267, 203, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(369, 317, 203, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(34, 354, 163, 26);
		contentPane.add(lblNewLabel_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(369, 359, 203, 20);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(34, 391, 163, 26);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Signup");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fname=textField.getText();
				String lname=textField_1.getText();
				String gender;
				if (male.getSelectedObjects() != null) {
					 male.setText(gender="male");
				}
				else if ( female.getSelectedObjects() != null) {
					 female.setText(gender="female");

				}
				else {
					others.setText(gender="other");
					
				}
				String purpose=(String) comboBox.getSelectedItem();
				String age=textField_2.getText().toString();
				String email=textField_3.getText();
				String password=passwordField.getText();
				String user=textField_4.getText();
				
				try {
					Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					PreparedStatement statement = conn.prepareStatement("insert into signup (fname,lname,sex,purposeofuse,age,email,username,password) values (?,?,?,?,?,?,?,?)");
			statement.setString(1, fname);
			statement.setString(2, lname);
			statement.setString(3, gender);
			statement.setString(4, purpose);
			statement.setString(5, age);
			statement.setString(6, email);
			statement.setString(7, user);
			statement.setString(8, password);
			
				int rowCount = statement.executeUpdate();
				
				if (rowCount == 1) {
					JOptionPane.showMessageDialog(null, "data inserted successfully");			
				}
			} catch (SQLException e1) {
				System.out.println("Exception occurred.");
				System.out.println(e1.getMessage());
			}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.setBounds(369, 427, 145, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Back to login page");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login loginpage=new Login ();
				loginpage.setVisible(true);
				dispose();
				
			}
		});
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(379, 477, 241, 25);
		contentPane.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(369, 396, 203, 20);
		contentPane.add(passwordField);
		
}
}
	
