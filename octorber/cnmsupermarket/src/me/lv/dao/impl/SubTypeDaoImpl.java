package me.lv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.lv.dao.SubTypeDao;
import me.lv.pojo.SubType;
import me.lv.util.JdbcConnection;

public class SubTypeDaoImpl implements SubTypeDao{

	public SubTypeDaoImpl() {
		super();
	}

	static {
		JdbcConnection.loadDriver();
	}

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	@Override
	public SubType selectById(int id) {
		String sql = "select * from sub_type where id=?";
		SubType subType = null;
		connection = JdbcConnection.getConnection();
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int subTypeId = resultSet.getInt("id");
				String sunTypeName = resultSet.getString("name");
				subType = new SubType(subTypeId, sunTypeName);
			}
			return subType;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public SubType selectByName(String name) {
		String sql = "select * from sub_type where name=?";
		SubType subType = null;
		connection = JdbcConnection.getConnection();
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int subTypeId = resultSet.getInt("id");
				String sunTypeName = resultSet.getString("name");
				subType = new SubType(subTypeId, sunTypeName);
			}
			return subType;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}




}
