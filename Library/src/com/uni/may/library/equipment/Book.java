package com.uni.may.library.equipment;

public class Book extends BaseEquipment {

	private int pageNumber = 100;

	@Override
	public String ls() {
		return "图书[" + id + "]，【" + name + "】 共有" + pageNumber + "页";
	}

	@Override
	public String cd(String path) {
		
		return null;
	}

}
