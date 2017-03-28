//这里只是模拟一下（用不了）
//package com.uni.may.library.dao.impl.redis;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.util.Stack;
//
//import org.junit.Test;
//
//import redis.clients.jedis.Jedis;
//import redis.clients.util.Pool;
//
//public class RedisManager {
//	final static int port = 0;
//	final static String host = null;
//	boolean isshutdown=false;
//	private static RedisManager instance = null;
//	private Stack<Jedis> pools = new Stack<Jedis>();
//
//	private RedisManager() {
//		for (int i = 0; i < 5; i++) {
//			try {
//				Jedis jedis = new Jedis("127.0.0.1", 6379);
////				if (isshutdown) {
////					pools.push(jedis);
////				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	public static synchronized RedisManager getInstance() {
//		if (null == instance) {
//			instance = new RedisManager();
//		}
//		return instance;
//	}
//
//	public Jedis getConnection() {
//		return pools.pop();
//	}
//
//	public void shutdown() {
//		isshutdown = true;
//		Jedis jedis = null;
//		while ((jedis = pools.pop()) != null) {
//			jedis.close();
//		}
//	}
//	
//	@Test
//	public void testGet() {
//		RedisManager rm = new RedisManager();
//		rm.getInstance().getConnection();
//		System.out.println(pools);
//	}
//	
//}
