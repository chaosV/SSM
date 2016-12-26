package com.qk1031.learnmybatis;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

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
		String resource = "mybatis_conf.xml";
		InputStream is = App.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionfactory = new SqlSessionFactoryBuilder().build(is);
		
		SqlSession session=sessionfactory.openSession();
		
//		ExamplePlayer(session);
//		System.out.println("-----------------------------");
//		playerHashMap(session,3);
//		
//		System.out.println("-----------------------------");
//		getPlayerById(session,3);
//		
//		System.out.println("-----------------------------");
//		Player player=new Player();
//		player.setName("zcc");
//		player.setScore(10);
//		player.setUsername("zcc");
//		player.setPassword("qqq111");
//		insertPlayer(session,player);
		
//		Player player=getPlayerById(session,6);
//		player.setName("ccc");
//		updataPlayer(session, player);
//		getPlayerById(session,6);
		
		Player player=getPlayerById(session,6);
		deletePlayer(session, player);
		ExamplePlayer(session);
		
		
		session.close();
	}
	
	public static Player getPlayerById(SqlSession session,int id){
		String statement="test.mapping.UserMapper.getPlayerById";
		Player player=session.selectOne(statement,id);
		System.out.println("getPlayerById"+player);
		return player;
	}
	
	private static void ExamplePlayer(SqlSession session){
		String statement="test.mapping.UserMapper.getALLUsers";
		List<Player> users=session.selectList(statement);
		
		for(Player player:users){
			System.out.println(player);
		}
	}
	
	private static void playerHashMap(SqlSession session,int id){
		String satement="test.mapping.UserMapper.getPlayerAttrMapById";
		Map<String,Object> player=session.selectOne(satement,id);
		for(String key:player.keySet()){
			System.out.println("key="+key+",value="+player.get(key)+",vt="+player.get(key).getClass().getSimpleName());
		}
	}
	
	private static void insertPlayer(SqlSession session ,Player player){
		String satement="test.mapping.UserMapper.insertPlayer";
		session.insert(satement,player);
		session.commit();
	}

	private static void updataPlayer(SqlSession session ,Player player){
		String satement="test.mapping.UserMapper.updataPlayer";
		session.update(satement,player);
		session.commit();
	}
	
	private static void deletePlayer(SqlSession session ,Player player){
		String satement="test.mapping.UserMapper.deletePlayer";
		session.delete(satement, player);
		session.commit();
	}
}
