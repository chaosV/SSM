package me.lv.dao;

import me.lv.pojo.GoodsSize;

public interface GoodsSizeDao {
	GoodsSize selectById(int id);
	GoodsSize selectByValue(String value);
}
