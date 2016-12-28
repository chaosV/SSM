package me.lv.dao;

import java.util.List;

import me.lv.pojo.Employee;

public interface EmployeeDao extends BaseDao<Employee> {

	List<Employee> selectEmployees();

	Employee selectEmployeeById(int id);
}
