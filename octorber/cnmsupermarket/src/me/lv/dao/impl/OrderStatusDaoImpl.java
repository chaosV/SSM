package me.lv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.lv.dao.OrderStatusDao;
import me.lv.pojo.OrderStatus;
import me.lv.util.JdbcConnection;

public class OrderStatusDaoImpl implements OrderStatusDao{

	static {
		JdbcConnection.loadDriver();
	}

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	
	@Override
	public OrderStatus selectById(int id) {
		String sql="select * from order_status where id=?";
		OrderStatus orderStatus=null;
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet=statement.executeQuery();
			
			while(resultSet.next()){
				int statusId=resultSet.getInt("id");
				String status=resultSet.getString("status");
				orderStatus = new OrderStatus(statusId,status);
			}
			return orderStatus;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
		
		return null;
	}

	@Override
	public OrderStatus selectByStatus(String status) {
		String sql="select * from order_status where status=?";
		OrderStatus orderStatus=null;
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, status);
			resultSet=statement.executeQuery();
			
			while(resultSet.next()){
				int statusId=resultSet.getInt("id");
				String orserStatus=resultSet.getString("status");
				orderStatus = new OrderStatus(statusId,orserStatus);
			}
			return orderStatus;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
		
		
		return null;
	}

}
