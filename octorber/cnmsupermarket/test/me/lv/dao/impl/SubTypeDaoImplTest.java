package me.lv.dao.impl;

import org.junit.Test;

public class SubTypeDaoImplTest {
	SubTypeDaoImpl daoImpl = new SubTypeDaoImpl();

	@Test
	public void testGetSubTypeById() {
		System.out.println(daoImpl.getSubTypeById(1));
	}

}
