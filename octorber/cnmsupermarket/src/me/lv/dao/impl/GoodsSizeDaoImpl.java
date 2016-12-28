package me.lv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.lv.dao.GoodsSizeDao;
import me.lv.pojo.GoodsSize;
import me.lv.util.JdbcConnection;

public class GoodsSizeDaoImpl implements GoodsSizeDao {
	
	static {
		JdbcConnection.loadDriver();
	}

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;

	@Override
	public GoodsSize selectById(int id) {
		String sql = "select id,size from goods_size where id=?";
		connection = JdbcConnection.getConnection();
		GoodsSize gs = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int sizeid = resultSet.getInt("id");
				String size = resultSet.getString("size");

				gs = new GoodsSize(sizeid, size);
			}
			return gs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
		return null;
	}

	@Override
	public GoodsSize selectByValue(String value) {
		String sql = "select id,size from goods_size where size=?";
		connection = JdbcConnection.getConnection();
		GoodsSize gs = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, value);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int sizeid = resultSet.getInt("id");
				String size = resultSet.getString("size");

				gs = new GoodsSize(sizeid, size);
			}
			return gs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
		return null;
	}

}
