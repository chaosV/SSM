package me.lv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.lv.dao.UserLoginDao;
import me.lv.pojo.UserLogin;
import me.lv.util.JdbcConnection;

public class UserLoginDaoImpl implements UserLoginDao{
	static {
		JdbcConnection.loadDriver();
	}

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	
	@Override
	public void insert(UserLogin t) {
		String sql="insert into surpermarket.user_login (username,password) values (?,?)";
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, t.getUsername());
			statement.setString(2, t.getPassword());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
	}

	@Override
	public void delete(UserLogin t) {
		String sql="delete from user_login where id=?";
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
	public void update(UserLogin t) {
		String sql="update user_login set username=?,password=? where id=?";
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, t.getUsername());
			statement.setString(2, t.getPassword());
			statement.setInt(3, t.getId());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
		
	}

	@Override
	public UserLogin selectById(int id) {
		
		String sql="select * from user_login where id=?";
		UserLogin userLogin=null;
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				int userLoginId=resultSet.getInt("id");
				String loginUsername=resultSet.getString("username");
				String password=resultSet.getString("password");
				userLogin=new UserLogin(userLoginId,loginUsername,password);
			}
			return userLogin;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}

		return null;
	}

	@Override
	public UserLogin selectByName(String username) {
		String sql="select * from user_login where username=?";
		UserLogin userLogin=null;
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, username);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				int userLoginId=resultSet.getInt("id");
				String loginUsername=resultSet.getString("username");
				String password=resultSet.getString("password");
				userLogin=new UserLogin(userLoginId,loginUsername,password);
			}
			return userLogin;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}

		return null;
	}

}
