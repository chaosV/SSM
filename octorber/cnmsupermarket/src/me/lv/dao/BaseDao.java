package me.lv.dao;

public interface BaseDao<T> {
	void insert(T t);
	void delete(T t);
	void update(T t);
}
