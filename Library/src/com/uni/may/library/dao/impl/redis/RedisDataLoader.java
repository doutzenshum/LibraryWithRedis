package com.uni.may.library.dao.impl.redis;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import redis.clients.jedis.Jedis;

public class RedisDataLoader {

	private ObjectMapper om;

	private Jedis jedis;

	private Map<String, Object> data;

	@BeforeTest
	public void init() {
		om = new ObjectMapper();

		jedis = new Jedis("127.0.0.1", 6379);
		jedis.select(1);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void loadDataFromJson() throws JsonParseException, JsonMappingException, IOException {
		data = om.readValue(new File("E:\\myeclipse2014\\gzkj\\Library\\resources\\liber.json"), Map.class);

		Assert.assertNotNull(data);
	}

	@Test(dependsOnMethods = { "loadDataFromJson" })
	public void putData2Redis() throws JsonGenerationException, JsonMappingException, IOException {
		putElem2Redis("librarys", data);
	}

	@SuppressWarnings({ "unchecked" })
	private void putElem2Redis(String key, Map<String, Object> map) throws JsonGenerationException, JsonMappingException, IOException {
		if (map == null || map.size() == 0) {
			return;
		}

		Object value = null;
		Map<String, Object> entity = new HashMap<>();
		String id = null;
		for (String field : map.keySet()) {
			value = map.get(field);
			if (value instanceof String) {
				entity.put(field, value);
				if ("id".equals(field)) {
					id = value.toString();
				}
			} else if (value instanceof List) {
				List<Map<String, Object>> items = (List<Map<String, Object>>) value;
				List<String> keyList = null;
				if (entity.containsKey(field)) {
					keyList = (List<String>) entity.get(field);
				} else {
					keyList = new ArrayList<>();
					entity.put(field, keyList);
				}

				for (Map<String, Object> item : items) {
					if (item.containsKey("id")) {
						keyList.add(item.get("id").toString());
					}

					putElem2Redis(field, item);
				}
			} else {
				System.out.println("unknow action, field:" + field + "\tvalueType:" + value.getClass().getName()
						+ "\tvalue:" + value);
			}

		}
		String json = om.writeValueAsString(entity);
		System.out.println("Begin write entity to Redis key: " + key + "\tid:" + id + "\tvalue:" + json);
		jedis.hset(key, id, json);
	}

}
