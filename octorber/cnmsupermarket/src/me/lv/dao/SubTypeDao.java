package me.lv.dao;

import me.lv.pojo.SubType;

public interface SubTypeDao {
	SubType selectById(int id);
	SubType selectByName(String name);
}
