package me.lv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.lv.dao.EmployeeDao;
import me.lv.pojo.Employee;
import me.lv.pojo.EmployeeLimit;
import me.lv.util.JdbcConnection;

public class EmployeeDaoImpl implements EmployeeDao {

	public EmployeeDaoImpl() {
		super();
	}

	static {
		JdbcConnection.loadDriver();
	}

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	
	@Override
	public void insert(Employee t) {
		String sql="insert into `employee` (`name`,`phone`,`email`,password,employee_limit_id) values(?,?,?,?,?)";
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			
		
			statement.setString(1, t.getName());
			statement.setString(2, t.getPhone());
			statement.setString(3, t.getEmail());
			statement.setString(4, t.getPassword());
			statement.setInt(5, t.getEmployeeLimitId());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement,resultSet);
			
		}
	}
	@Override
	public void delete(Employee t) {
		String sql="delete from employee where id=?";
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1,t.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
	}
	@Override
	public void update(Employee t) {
		String sql="update employee set id=?,name=?,phone=?,email=?,password=? where id=?";
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, t.getId());
			statement.setString(2, t.getName());
			statement.setString(3, t.getPhone());
			statement.setString(4, t.getEmail());
			statement.setString(5, t.getPassword());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
		
		
	}
	@Override
	public List<Employee> selectEmployees() {
		List<Employee> list=new ArrayList<>();
		String sql="select * from employee";
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			
			while(resultSet.next()){
				int id=resultSet.getInt("id");
				String name=resultSet.getString("name");
				String phone=resultSet.getString("phone");
				String email=resultSet.getString("email");
				int employeeLimitId=resultSet.getInt("employee_limit_id");
				
				
				Employee employee=new Employee(id,name,phone,email,employeeLimitId);
				list.add(employee);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
		
		
		return null;
	}
	@Override
	public Employee selectEmployeeById(int id) {
		String sql="SELECT employee.id,name,phone,email,password,employee_limit_id from employee where employee.id=? ";
		Employee employee=null;
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet=statement.executeQuery();
			
			while(resultSet.next()){
				int employeeById=resultSet.getInt("id");
				String name=resultSet.getString("name");
				String phone=resultSet.getString("phone");
				String email=resultSet.getString("email");
				String password=resultSet.getString("password");
				int employeeLimitId=resultSet.getInt("employee_limit_id");
				
				employee=new Employee(employeeById,name,phone,email,password,employeeLimitId);
				
			}
			return employee;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
		
		return null;
	}



}
