package me.lv.dao;

import me.lv.pojo.Customer;

public interface CustomerDao extends BaseDao<Customer> {
	
	Customer selectCustomerById(int id);

	
}
