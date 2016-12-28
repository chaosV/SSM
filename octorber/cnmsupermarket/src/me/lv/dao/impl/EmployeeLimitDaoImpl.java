package me.lv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.lv.dao.EmployeeLimitDao;
import me.lv.pojo.EmployeeLimit;
import me.lv.util.JdbcConnection;

public class EmployeeLimitDaoImpl implements EmployeeLimitDao{
	
	static {
		JdbcConnection.loadDriver();
	}

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;

	@Override
	public EmployeeLimit selectByValue(String value) {
		EmployeeLimit employeeLimit=null;
		
		String sql="select * from employee_limit where level=?";
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, value);
			resultSet=statement.executeQuery();
			
			while(resultSet.next()){
				int id=resultSet.getInt("id");
				String level=resultSet.getString("level");
				
				employeeLimit=new EmployeeLimit(id,level);
				
			}
			return employeeLimit;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
		return null;
	}

	@Override
	public EmployeeLimit selectById(int id) {
		EmployeeLimit employeeLimit=null;
		
		String sql="select * from employee_limit where id=?";
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet=statement.executeQuery();
			
			while(resultSet.next()){
				int limitid=resultSet.getInt("id");
				String level=resultSet.getString("level");
				
				employeeLimit=new EmployeeLimit(limitid,level);
				
			}
			return employeeLimit;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
		return null;
	}

}
