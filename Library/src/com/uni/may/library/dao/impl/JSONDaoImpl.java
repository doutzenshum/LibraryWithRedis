package com.uni.may.library.dao.impl;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import com.uni.may.library.dao.IBaseDao;
import com.uni.may.library.equipment.BaseEquipment;
import com.uni.may.library.equipment.Library;

public class JSONDaoImpl implements IBaseDao {

	ObjectMapper om = new ObjectMapper();

	Library liber = null;

	public JSONDaoImpl() {
		try {
			liber = om.readValue(new File("E:\\myeclipse2014\\gzkj\\Library\\resources\\liber.json"), Library.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public BaseEquipment getById(String id) {
		
		return liber;
	}

	@Override
	public BaseEquipment[] listAll(String pid) {

		return null;
	}
	
	@Test
	public void selfTest() {
		JSONDaoImpl jdao = new JSONDaoImpl();
		
		Assert.assertNotNull(jdao);
	}

}
