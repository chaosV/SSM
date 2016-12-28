package me.lv.dao;

import me.lv.pojo.OrderStatus;

public interface OrderStatusDao {
	OrderStatus selectById(int id);
	OrderStatus selectByStatus(String status);
	
}
