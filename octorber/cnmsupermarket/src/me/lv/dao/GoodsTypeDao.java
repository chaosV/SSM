package me.lv.dao;

import me.lv.pojo.GoodsType;

public interface GoodsTypeDao {
	GoodsType selectBySubTypeId(int id);
	
	GoodsType selectByName(String name);
}
