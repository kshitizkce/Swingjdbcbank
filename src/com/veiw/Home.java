package com.veiw;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.controller.CustomerAction;
import com.controller.CustomerActionimpl;
import com.model.Customer;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_2;
	private JLabel accname;
	private JLabel accbalance;
	private JLabel accbalancecur;
	private JLabel acctype;
	private JLabel accbranch;
	private JTable table;
	protected Object[] options;
	protected Component frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1122, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the Customer detail");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 406, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Account Name");
		lblNewLabel_1.setFont(new Font("Algerian", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 50, 204, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setFont(new Font("Algerian", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 88, 204, 34);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Opening Branch");
		lblNewLabel_1_2.setFont(new Font("Algerian", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 88, 204, 34);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Account type");
		lblNewLabel_1_1_1_1.setFont(new Font("Algerian", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(10, 157, 204, 34);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Opening Balance");
		lblNewLabel_1_1_1_2.setFont(new Font("Algerian", Font.PLAIN, 15));
		lblNewLabel_1_1_1_2.setBounds(10, 191, 204, 34);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		textField = new JTextField();
		textField.setBounds(195, 57, 172, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(195, 95, 172, 20);
		contentPane.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(195, 164, 172, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(195, 198, 172, 20);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("Add Customer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer cs =new Customer();
				cs.setAccountName(textField.getText());
				cs.setAccountOpenedBranch(textField_1.getText());
				cs.setAccountType(textField_3.getText());
				cs.setOpeningBalance(Float.parseFloat(textField_4.getText()));
				cs.setCurrentbalance(Float.parseFloat(textField_4.getText()));
				CustomerAction csr= new CustomerActionimpl();
				boolean result= csr.addCustomers(cs);
				if (result) {
					JOptionPane.showMessageDialog(null,"Customer data inserted to server");
					display();

				}else {
					JOptionPane.showMessageDialog(null,"Customer data insertion unsuccessful !!");

				}
			}
		});
		btnNewButton.setFont(new Font("Algerian", Font.PLAIN, 15));
		btnNewButton.setBounds(205, 236, 141, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblDeposite = new JLabel("Deposite");
		lblDeposite.setFont(new Font("Algerian", Font.BOLD, 20));
		lblDeposite.setBounds(10, 293, 406, 34);
		contentPane.add(lblDeposite);
		
		JLabel lblNewLabel_1_3 = new JLabel("Amount to deposite");
		lblNewLabel_1_3.setFont(new Font("Algerian", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(10, 324, 204, 34);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Account Number");
		lblNewLabel_1_3_1.setFont(new Font("Algerian", Font.PLAIN, 15));
		lblNewLabel_1_3_1.setBounds(10, 362, 204, 34);
		contentPane.add(lblNewLabel_1_3_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(195, 331, 172, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(195, 369, 172, 20);
		contentPane.add(textField_6);
		
		JLabel lblWithdraw = new JLabel("Withdraw");
		lblWithdraw.setFont(new Font("Algerian", Font.BOLD, 20));
		lblWithdraw.setBounds(10, 407, 406, 34);
		contentPane.add(lblWithdraw);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Amount to withdraw");
		lblNewLabel_1_3_2.setFont(new Font("Algerian", Font.PLAIN, 15));
		lblNewLabel_1_3_2.setBounds(10, 439, 204, 34);
		contentPane.add(lblNewLabel_1_3_2);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Account Number");
		lblNewLabel_1_3_1_1.setFont(new Font("Algerian", Font.PLAIN, 15));
		lblNewLabel_1_3_1_1.setBounds(10, 471, 204, 34);
		contentPane.add(lblNewLabel_1_3_1_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(195, 439, 172, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(195, 478, 172, 20);
		contentPane.add(textField_8);
		
		JButton btnDeposite = new JButton("Deposite");
		btnDeposite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer cs =new Customer();
				int accountnumber= (Integer.parseInt(textField_6.getText()));
				float currentbalance= (Float.parseFloat(textField_5.getText()));
				CustomerAction csr=new CustomerActionimpl();
				boolean result1=csr.depositeAmount(accountnumber,currentbalance);
				if(result1) {
					JOptionPane.showMessageDialog(null,"Customer deposite is sucessful");
					textField_6.setText(" ");
					textField_5.setText("");
					display();

				}else {
					JOptionPane.showMessageDialog(null,"Customer deposite is unsussful !!");
					textField_6.setText(" ");
					textField_5.setText("");
				}
			}
		});
		btnDeposite.setFont(new Font("Algerian", Font.PLAIN, 15));
		btnDeposite.setBounds(205, 400, 141, 23);
		contentPane.add(btnDeposite);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int accountnumber=Integer.parseInt(textField_8.getText());
				float amount  =Float.parseFloat(textField_7.getText());
				CustomerAction csr=new CustomerActionimpl();
				boolean result1=csr.withdrawAmount(accountnumber,amount);
				if(result1) {
					JOptionPane.showMessageDialog(null,"Customer withdraw is sucessful");
					textField_8.setText(" ");
					textField_7.setText("");
					display();
				}else {
					JOptionPane.showMessageDialog(null,"Customer withdraw is unsussful !!");
					textField_8.setText(" ");
					textField_7.setText("");
				}
			}
		});
		btnWithdraw.setFont(new Font("Algerian", Font.PLAIN, 15));
		btnWithdraw.setBounds(205, 509, 141, 23);
		contentPane.add(btnWithdraw);
		
		JLabel lblNewLabel_1_3_1_1_1 = new JLabel("Account Number");
		lblNewLabel_1_3_1_1_1.setFont(new Font("Algerian", Font.PLAIN, 15));
		lblNewLabel_1_3_1_1_1.setBounds(457, 50, 204, 34);
		contentPane.add(lblNewLabel_1_3_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searchdata=textField_2.getText().trim();
				CustomerAction cs=new CustomerActionimpl();
				List<Customer> searchemployee=cs.searchemployee(searchdata);
				DefaultTableModel tmodel=(DefaultTableModel) table.getModel();
				tmodel.setRowCount(0);
				for(Customer cus:searchemployee) {
					tmodel.addRow(new Object [] {cus.getAccountNumber(),cus.getAccountName(),cus.getOpeningBalance(),cus.getCurrentbalance(),cus.getAccountType(),cus.getAccountOpenedBranch()});
				}
				
				
			}
		});
			
		textField_2.setColumns(10);
		textField_2.setBounds(656, 57, 172, 20);
		contentPane.add(textField_2);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Please select the desired row from the table before proceeding to delete:Please not read the data carefully befor you delete" );
				return;
				}
				
				int result=JOptionPane.showConfirmDialog(frame,"Are you sure you want to DELETE THIS DATA?", "Swing Tester",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
			            if(result == JOptionPane.YES_OPTION){
							int selectedrow= table.getSelectedRow();
							int id=(int) table.getModel().getValueAt(selectedrow, 0);
							
							
							CustomerAction csa=new CustomerActionimpl();
							if (csa.deleteCustomer(id)) {
								JOptionPane.showMessageDialog(null, "OOPPSSS!!! Delete sucessful !!!" );
								display();

							}else {
								JOptionPane.showMessageDialog(null, "Opps !! Delete Unsucessful !!!" );

							}

			            }else if (result == JOptionPane.NO_OPTION){
			            	display();
			            }else {
			            	display();
			            }
				
				
				
			}
		});
		btnDelete.setFont(new Font("Algerian", Font.PLAIN, 15));
		btnDelete.setBounds(957, 99, 141, 23);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(387, 134, 711, 397);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Account Number", "Account Name", "Opening Balance", "Current Balance", "Account Type", "Account opened Branch"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Algerian", Font.BOLD, 20));
		lblSearch.setBounds(656, 22, 406, 34);
		contentPane.add(lblSearch);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Algerian", Font.PLAIN, 15));
		btnEdit.setBounds(957, 61, 141, 23);
		contentPane.add(btnEdit);
		
		JLabel lblNewLabel_2 = new JLabel("<<---");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Homepage hm= new Homepage();
				hm.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setFont(new Font("Algerian", Font.BOLD, 20));
		lblNewLabel_2.setBounds(1020, 11, 49, 25);
		contentPane.add(lblNewLabel_2);
		display();
	}
	private void display() {
		CustomerAction cs=new CustomerActionimpl();
		List<Customer>cuslist=cs.getAllcustomer();
		
		DefaultTableModel tmodel=(DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);
		for(Customer cus:cuslist) {
			tmodel.addRow(new Object[] {cus.getAccountNumber(),cus.getAccountName(),cus.getOpeningBalance(),cus.getCurrentbalance(),cus.getAccountType(),cus.getAccountOpenedBranch()});
		}
	}
}
