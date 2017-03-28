package com.uni.may.library.dao;

import com.uni.may.library.equipment.BaseEquipment;

public interface IBaseDao {
	
	public BaseEquipment getById(String id);
	
	public BaseEquipment[]	listAll(String pid);

}
