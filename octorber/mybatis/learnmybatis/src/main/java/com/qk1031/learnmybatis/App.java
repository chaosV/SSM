package com.qk1031.learnmybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import test.pojo.Player;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		//mybatis配置文件
		String resource = "mybatis_conf.xml"; 
		//使用类加载器加载配置文件（也加载关联的映射文件）
		InputStream is = App.class.getClassLoader().getResourceAsStream(resource);
		//构建sqlsession工厂
		SqlSessionFactory sessionfactory = new SqlSessionFactoryBuilder().build(is);
		//创建能执行映射文件中的sqlsession
		SqlSession session=sessionfactory.openSession();
		
		String statement="test.mapping.UserMapper.getALLUsers";  //映射sql标识字符串
		List<Player> users=session.selectList(statement);
		
		for(Player player:users){
			System.out.println(player);
		}
		System.out.println("-----------------------------");
		statement="test.mapping.UserMapper.getPlayerById";
		Player player=session.selectOne(statement,3);
		System.out.println("getPlayerById"+player);
		
		
		
		session.close();
	}
}
