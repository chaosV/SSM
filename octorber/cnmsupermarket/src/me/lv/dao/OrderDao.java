package me.lv.dao;

import java.util.List;

import me.lv.pojo.Order;

public interface OrderDao extends BaseDao<Order>{
	Order selectOrderByCustomerId(int customerId);
	
	List<Order> selectOrders();
}
