package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.w3c.dom.css.CSSRuleList;

import com.model.Customer;

public class CustomerActionimpl implements CustomerAction {

	@Override
	public boolean addCustomers(Customer cus) {
		try {
			Connection con =DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			PreparedStatement pst=con.prepareStatement("insert into customer_final (accountname,openingbalance,openingbranch,accounttype,currentbalance) values(?,?,?,?,?)");
			pst.setString(1, cus.getAccountName());
			pst.setFloat(2, cus.getOpeningBalance());
			pst.setString(3, cus.getAccountOpenedBranch());
			pst.setString(4, cus.getAccountType());
			pst.setFloat(5, cus.getCurrentbalance());
			 pst.executeUpdate();
			 con.close();
		
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return true;
	}

	@Override
	public boolean depositeAmount(int accountnumber, float amount) {
				
		try {
			
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			PreparedStatement pst= con.prepareStatement("select currentbalance from customer_final where accountnumber='"+accountnumber+"'");
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
			if(amount != 0) {
				float currentbalance=(rs.getFloat("currentbalance"));
				currentbalance=currentbalance + amount;
				PreparedStatement pst1= con.prepareStatement("update customer_final set currentbalance='"+ currentbalance +"' where accountnumber='"+accountnumber+"'");
				pst1.executeUpdate();
			}
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean withdrawAmount(int accountnumber, float amount) {
try {
			
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			PreparedStatement pst= con.prepareStatement("select currentbalance from customer_final where accountnumber='"+accountnumber+"'");
			ResultSet rs= pst.executeQuery();
				float currentbalance=(rs.getFloat("currentbalance"));
				while(rs.next()) {

				if(amount <= currentbalance) {

				currentbalance=currentbalance - amount;
				PreparedStatement pst1= con.prepareStatement("update customer_final set currentbalance='"+ currentbalance +"' where accountnumber='"+accountnumber+"'");
				pst1.executeUpdate();
				}
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	

	@Override
	public boolean deleteCustomer(int id) {
try {
			
			
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");		
				 PreparedStatement pst2=conn.prepareStatement("delete from customer_final where accountnumber = '"+id+"'");
				 pst2.executeUpdate();
				 return true;
			 
		
	} catch (SQLException e) {
		e.printStackTrace();

	}
	return false;

}

	@Override
	public List<Customer> getAllcustomer() {
		List<Customer>cslist=new ArrayList();
	
		
		try {

		Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");		
			 PreparedStatement pst2=conn.prepareStatement("select * from customer_final");
			 ResultSet rs =pst2.executeQuery();
			 while(rs.next()) {
				 Customer cs =new Customer();
			 
				cs.setAccountNumber( rs.getInt("accountnumber"));
				cs.setOpeningBalance( rs.getFloat("openingbalance"));
				 cs.setCurrentbalance(rs.getFloat("currentbalance"));
				 cs.setAccountType(rs.getString("accounttype"));
				cs.setAccountOpenedBranch( rs.getString("openingbranch"));
				 cs.setAccountName(rs.getString("accountname"));
				 
				 cslist.add(cs);
			 }
			 

		 
	
} catch (SQLException e) {
	e.printStackTrace();

	}
		return cslist;
		
			}

	@Override
	public List<Customer> searchemployee(String searchdata) {
		
List<Customer>cslist=new ArrayList();
	
		
		try {

		Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");		
			 PreparedStatement pst2=conn.prepareStatement("select * from customer_final where accountnumber like '"+searchdata+"%' OR accountname like '%"+searchdata+"%' OR accounttype like '%"+searchdata+"%' OR currentbalance like '%"+searchdata+"%' OR openingbranch like '%"+searchdata+"%' OR openingbalance like '%"+searchdata+"%'");
			 ResultSet rs =pst2.executeQuery();
			 while(rs.next()) {
				 Customer cs =new Customer();
			 
				cs.setAccountNumber( rs.getInt("accountnumber"));
				cs.setOpeningBalance( rs.getFloat("openingbalance"));
				 cs.setCurrentbalance(rs.getFloat("currentbalance"));
				 cs.setAccountType(rs.getString("accounttype"));
				cs.setAccountOpenedBranch( rs.getString("openingbranch"));
				 cs.setAccountName(rs.getString("accountname"));
				 
				 cslist.add(cs);
			 }
			 
		} catch (SQLException e) {
			e.printStackTrace();

			}
				return cslist;
				
					}
		 
	
		
	
	}

