package me.lv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.lv.dao.GoodsSumDao;
import me.lv.pojo.GoodsSum;
import me.lv.util.JdbcConnection;

public class GoodsSumDaoImpl implements GoodsSumDao{
	static {
		JdbcConnection.loadDriver();
	}

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	
	
	@Override
	public void insert(GoodsSum t) {
		String sql="insert into goods_sum (id,sum,goods_size_id,goods_id) values (?,?,?,?)";
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			
			statement.setInt(1,t.getId());
			statement.setInt(2, t.getSum());;
			statement.setInt(3, t.getGoodsSizeId());
			statement.setInt(4, t.getGoodsId());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
		
	}

	@Override
	public void delete(GoodsSum t) {
		
		String sql="delete from goods_sum where id=?";
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
	public void update(GoodsSum t) {
		String sql="update goods_sum set goods_sum.sum=?,goods_size_id=?,goods_id=? where id=?";
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			
			statement.setInt(1, t.getSum());
			statement.setInt(2, t.getGoodsSizeId());
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
	public GoodsSum select(int sizeId, int goodsId) {
		String sql="select * from goods_sum where goods_size_id=? and goods_id=?"; 
		connection=JdbcConnection.getConnection();
		GoodsSum goodsSum=null;
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, sizeId);
			statement.setInt(2,goodsId );
			resultSet=statement.executeQuery();
			while(resultSet.next()){
				int id=resultSet.getInt("id");
				int sum=resultSet.getInt("sum");
				int goodsSizeId=resultSet.getInt("goods_size_id");
				int goodsSumId=resultSet.getInt("goods_id");
				
				goodsSum=new GoodsSum(id,sum,goodsSizeId,goodsSumId);
			}
			return goodsSum;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
		return null;
	}
	public List<GoodsSum> select() {
		String sql="select * from goods_sum"; 
		List<GoodsSum> list=new ArrayList<>();
		connection=JdbcConnection.getConnection();
		GoodsSum goodsSum=null;
		try {
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			while(resultSet.next()){
				int id=resultSet.getInt("id");
				int sum=resultSet.getInt("sum");
				int goodsSizeId=resultSet.getInt("goods_size_id");
				int goodsSumId=resultSet.getInt("goods_id");
				
				goodsSum=new GoodsSum(id,sum,goodsSizeId,goodsSumId);
				list.add(goodsSum);
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
