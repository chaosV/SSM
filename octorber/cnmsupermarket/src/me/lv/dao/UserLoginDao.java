package me.lv.dao;

import me.lv.pojo.UserLogin;

public interface UserLoginDao extends BaseDao<UserLogin>{
	UserLogin selectById(int id);
	UserLogin selectByName(String username);
}
