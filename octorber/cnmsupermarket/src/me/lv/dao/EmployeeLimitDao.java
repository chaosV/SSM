package me.lv.dao;

import me.lv.pojo.EmployeeLimit;

public interface EmployeeLimitDao {
	EmployeeLimit selectByValue(String value);
	EmployeeLimit selectById(int id);
	
}
