package com.controller;

import java.util.List;

import com.model.Customer;

public interface CustomerAction {
	boolean addCustomers(Customer cus);
	boolean depositeAmount(int accountnumber, float amount);
	boolean withdrawAmount(int accountnumber, float amount);
	List<Customer> getAllcustomer();
	List<Customer> searchemployee(String searchdata);
	boolean deleteCustomer(int id);
}
