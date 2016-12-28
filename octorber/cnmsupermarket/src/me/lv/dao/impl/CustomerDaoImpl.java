package me.lv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.lv.dao.CustomerDao;
import me.lv.pojo.Customer;
import me.lv.util.JdbcConnection;

public class CustomerDaoImpl implements CustomerDao{

	
	
	public CustomerDaoImpl() {
		super();
	}

	static {
		JdbcConnection.loadDriver();
	}

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	
	@Override
	public void insert(Customer t) {
		String sql="insert into `customer` (id,`nickname`,`sex`,`email`,`phone`,user_login_id) values(?,?,?,?,?,?)";
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			
			statement.setInt(1, t.getId());
			statement.setString(2, t.getNickname());
			statement.setString(3, t.getSex());
			statement.setString(4, t.getEmail());
			statement.setString(5, t.getPhone());
			statement.setInt(6, t.getUserLoginId());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement,resultSet);
			
		}
	}

	@Override
	public void delete(Customer t) {
		String sql="delete from customer where id=?";
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
	public void update(Customer t) {
		String sql="update customer set nickname=?,sex=?,email=?,phone=? where user_login_id=?";
		connection=JdbcConnection.getConnection();
		try {
			
			statement=connection.prepareStatement(sql);
			statement.setString(1, t.getNickname());
			statement.setString(2, t.getSex());
			statement.setString(3, t.getEmail());
			statement.setString(4, t.getPhone());
			statement.setInt(5, t.getUserLoginId());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
		
	}

	@Override
	public Customer selectCustomerById(int customerById) {
		String sql="select id,nickname,sex,email,phone,user_login_id from customer where id=?";
		connection=JdbcConnection.getConnection();
		Customer customer=null;
		try {
			statement=connection.prepareStatement(sql); 
			statement.setInt(1, customerById);
			resultSet=statement.executeQuery();
			
			while(resultSet.next()){
				int id=resultSet.getInt("id");
				String nickname=resultSet.getString("nickname");
				String sex=resultSet.getString("sex");
				String email=resultSet.getString("email");
				String phone=resultSet.getString("phone");
				int userLoginId=resultSet.getInt("user_login_id");
				
				customer=new Customer(id,nickname,sex,email,phone,userLoginId);
			}
			return customer;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
		
		return null;
	}

}
