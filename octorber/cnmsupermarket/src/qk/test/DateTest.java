package qk.test;


import me.lv.dao.impl.UserLoginDaoImpl;

import me.lv.pojo.UserLogin;

public class DateTest {

	public static void main(String[] args) {
		UserLoginDaoImpl odi=new UserLoginDaoImpl();
		UserLogin o=new UserLogin();
		
		o=odi.selectByName("qw");
		System.out.println(o);
	}
}
