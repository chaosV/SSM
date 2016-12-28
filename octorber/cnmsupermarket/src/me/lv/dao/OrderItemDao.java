package me.lv.dao;

import me.lv.pojo.OrderItem;

public interface OrderItemDao extends BaseDao<OrderItem>{
	OrderItem select(int orderId, int goodsId);
}
