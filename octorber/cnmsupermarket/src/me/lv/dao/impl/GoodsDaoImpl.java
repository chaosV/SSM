package me.lv.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.lv.dao.GoodsDao;
import me.lv.pojo.Goods;
import me.lv.util.JdbcConnection;

public class GoodsDaoImpl implements GoodsDao {

	public GoodsDaoImpl() {
		super();
	}

	static {
		JdbcConnection.loadDriver();
	}

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;


	@Override
	public Goods selectGoodsById(int goodsId) {
		Goods goods =null;
		connection = JdbcConnection.getConnection();
		String sql = "select * from goods where id=?";

		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, goodsId);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int id=resultSet.getInt("id");
				String name=resultSet.getString("name");
				String url=resultSet.getString("url");
				double price=resultSet.getDouble("price");
				double discount=resultSet.getDouble("discount");
				Date createDate=resultSet.getDate("create_date");
				int expiryDate=resultSet.getInt("expiry_date");
				String producer=resultSet.getString("producer");
				String desc=resultSet.getString("desc");
				int goodsTypeId=resultSet.getInt("goods_type_id");
				
				goods=new Goods(id,name,url,price,discount,createDate,expiryDate,producer,desc,goodsTypeId);
			}
			return goods;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
		return null;
	}

	@Override
	public List<Goods> selectGoodses() {
		List<Goods> list=new ArrayList<>();
		String sql="select * from goods";
		connection=JdbcConnection.getConnection();
		
		try {
			statement=connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int id=resultSet.getInt("id");
				String name=resultSet.getString("name");
				String url=resultSet.getString("url");
				double price=resultSet.getDouble("price");
				double discount=resultSet.getDouble("discount");
				Date createDate=resultSet.getDate("create_date");
				int expiryDate=resultSet.getInt("expiry_date");
				String producer=resultSet.getString("producer");
				String desc=resultSet.getString("desc");
				int goodsTypeId=resultSet.getInt("goods_type_id");
				
				Goods goods=new Goods(id,name,url,price,discount,createDate,expiryDate,producer,desc,goodsTypeId);
				list.add(goods);
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

	@Override
	public void insert(Goods t) {

		String sql="insert into goods (name,url,price,discount,create_date,expiry_date,producer,goods.desc,goods_type_id) values (?,?,?,?,?,?,?,?,?)";
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1,t.getName());
			statement.setString(2, t.getUrl());
			statement.setDouble(3, t.getPrice());
			statement.setDouble(4, t.getDiscount());
			statement.setDate(5, (Date) t.getCreatDate());
			statement.setInt(6, t.getExpiryDate());
			statement.setString(7, t.getProducer());
			statement.setString(8, t.getDesc());
			statement.setInt(9,t.getGoodsTypeId());
			
			statement.executeUpdate();
		} catch (SQLException e){ 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
		
	}

	@Override
	public void delete(Goods t) {
		String sql="delete from goods where id=?";
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
	public void update(Goods t) {
		String sql="update goods set name=?,url=?,price=?,discount=?,create_date=?,expiry_date=?,producer=?,goods.desc=?,goods_type_id=? where id=?";
		connection=JdbcConnection.getConnection();
		try {
			statement=connection.prepareStatement(sql);
			
			statement.setString(1,t.getName());
			statement.setString(2, t.getUrl());
			statement.setDouble(3, t.getPrice());
			statement.setDouble(4, t.getDiscount());
			statement.setDate(5, (Date) t.getCreatDate());
			statement.setInt(6, t.getExpiryDate());
			statement.setString(7, t.getProducer());
			statement.setString(8, t.getDesc());
			statement.setInt(9,t.getGoodsTypeId());
			statement.setInt(10, t.getId());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcConnection.cleanUp(connection, statement, resultSet);
		}
	}


}
