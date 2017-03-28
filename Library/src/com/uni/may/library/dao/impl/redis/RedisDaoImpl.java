package com.uni.may.library.dao.impl.redis;

import org.junit.Test;
import org.testng.Assert;

import com.uni.may.library.dao.IBaseDao;
import com.uni.may.library.equipment.BaseEquipment;

import redis.clients.jedis.Jedis;

public class RedisDaoImpl implements IBaseDao {

	private Jedis jedis;

	public RedisDaoImpl() {
		jedis = new Jedis("127.0.0.1", 6379);
		jedis.select(1);
	}

	@Override
	public BaseEquipment getById(String id) {
		String key = "librarys";
		String json = jedis.hget(key, id);
		
		System.out.println(json);
		return null;
	}

	@Override
	public BaseEquipment[] listAll(String pid) {

		return null;
	}

	@Test
	public void testGet() {
		RedisDaoImpl dao = new RedisDaoImpl();
		
		Assert.assertNotNull(dao.jedis);
		dao.getById("LIB001");
		System.out.println("123");
	}
}
