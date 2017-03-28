package com.uni.may.library.equipment;

import java.io.Serializable;

import com.uni.may.library.command.BaseCommand;
import com.uni.may.library.command.Context;
import com.uni.may.library.dao.impl.JSONDaoImpl;
import com.uni.may.library.util.Utility;

public class Library extends BaseEquipment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3408378958695067215L;

	private Room[] rooms;
	private static boolean flag=true;

	private static Library instance;

	private Library() {

	}
	//单例模式不能实现cloneable接口
	//防止序列化破坏单例模式
    private Object readResolve() {
        return instance;
    }

	public static Library getInstance() {
		synchronized (Library.class) {//防止反射破坏单例模式
			if (flag) {
				flag=false;
			}else {
				System.out.println("单例模式差点被破坏了");
				throw new RuntimeException();
			}
			if (instance == null) {
				instance = (Library) new JSONDaoImpl().getById("");
			}
		}

		return instance;
	}

	@Override
	public String ls() {
		if (rooms == null) {
			return "图书馆[" + id + "]， 目前是空的";
		}
		String rs = "图书馆拥有" + rooms.length + "个图书室:\n\t";
		rs = Utility.combineLsResult(rs, rooms);

		return rs;
	}

	@Override
	public String cd(String path) {
		Context cntxt = BaseCommand.THREAD_CONTEXT.get();
		if (cntxt.getEqu() instanceof Library) {
			Library liber = (Library) cntxt.getEqu();
			for (Room room : liber.getRooms()) {
				if (room.getId().equals(path)) {
					cntxt.setEqu(room);
					return "上下文切换成功， 当前当下文：在图书室【" + room.getName() +"】";
				}
			}
		}
		return "上下文切换失败，当前上下文：" + cntxt.getEqu().getName();
	}

	public Room[] getRooms() {
		return rooms;
	}

	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}

}
