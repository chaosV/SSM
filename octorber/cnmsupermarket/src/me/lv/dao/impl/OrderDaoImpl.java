package me.lv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.lv.dao.OrderDao;
import me.lv.pojo.Order;
import me.lv.util.JdbcConnection;

public class OrderDaoImpl implements OrderDao{

	public OrderDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	
	@Override
	public void insert(Order t) {
		
		String sql="insert into `order` (order_num,address,user_login_id,order_status_id) values (?,?,?,?)";
		connection=JdbcConnection.getConnection();
		
		try {
			statement=connection.prepareStatement(sql);
		
			statement.setString(1, t.getOrderNum());
			statement.setString(2, t.getAddress());
			statement.setInt(3, t.getUserLoginId());
			statement.setInt(4, t.getOrderStatusId());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
	}

	@Override
	public void delete(Order t) {
		String sql="delete from `order` where id=?";
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
	public void update(Order t) {
		String sql="update `order` set order_num=?,address=?,user_login_id=?,order_status_id=? where id=?";
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, t.getOrderNum());
			statement.setString(2, t.getAddress());
			statement.setInt(3, t.getUserLoginId());
			statement.setInt(4, t.getOrderStatusId());
			statement.setInt(5, t.getId());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
		
	}

	@Override
	public Order selectOrderByCustomerId(int customerId) {
		String sql="select * from `order` where id=?";
		connection=JdbcConnection.getConnection();
		Order order=null;
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1,customerId );
			resultSet=statement.executeQuery();
			
			while(resultSet.next()){
				int id=resultSet.getInt("id");
				String orderNum=resultSet.getString("order_num");
				String address=resultSet.getString("address");
				int userLoginId=resultSet.getInt("user_login_id");
				int orderStatusId=resultSet.getInt("order_status_id");
				
				order=new Order(id,orderNum,address,userLoginId,orderStatusId);
			}
			return order;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
		
		return null;
	}

	@Override
	public List<Order> selectOrders() {
		List<Order> list=new ArrayList<>();
		String sql="select * from `order` ";
		connection=JdbcConnection.getConnection();
		
		try {
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			while(resultSet.next()){
				int id=resultSet.getInt("id");
				String orderNum=resultSet.getString("order_num");
				String address=resultSet.getString("address");
				int userLoginId=resultSet.getInt("user_login_id");
				int orderStatusId=resultSet.getInt("order_status_id");
				
				Order order=new Order(id,orderNum,address,userLoginId,orderStatusId);
				list.add(order);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
		
		return null;
	}



}
