package me.lv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.lv.dao.OrderItemDao;
import me.lv.pojo.OrderItem;
import me.lv.util.JdbcConnection;

public class OrderItemDaoImpl implements OrderItemDao{
	static {
		JdbcConnection.loadDriver();
	}

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	
	@Override
	public void insert(OrderItem t) {
		String sql="insert into order_item (sum,order_id,goods_id) values (?,?,?)";
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, t.getSum());
			statement.setInt(2, t.getOrderId());
			statement.setInt(3, t.getGoodsId());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
		
	}

	@Override
	public void delete(OrderItem t) {
		String sql="delete from order_item where order_id=? ";
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, t.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
	}

	@Override
	public void update(OrderItem t ) {
		String sql="update order_item set sum=?,order_id=?,goods_id=? where id=?";
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, t.getSum());
			statement.setInt(2, t.getOrderId());
			statement.setInt(3, t.getGoodsId());
			statement.setInt(4, t.getId());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
	}

	@Override
	public OrderItem select(int orderId, int goodsId) {
		String sql="select sum from order_item where order_id=? and goods_id=? ";
		OrderItem orderItem=null;
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1,orderId);
			statement.setInt(2,goodsId );
			resultSet=statement.executeQuery();
			while(resultSet.next()){
				int sum=resultSet.getInt("sum");
				int orderById=resultSet.getInt("order_id");
				int goodsById=resultSet.getInt("goods_id");
				
				orderItem=new OrderItem(sum,orderById,goodsById);
			}
			return orderItem;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
		
		return null;
	}
	
}
