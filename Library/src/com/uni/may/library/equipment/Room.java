package com.uni.may.library.equipment;

import com.uni.may.library.command.BaseCommand;
import com.uni.may.library.command.Context;
import com.uni.may.library.util.Utility;

public class Room extends BaseEquipment {

	private BookSelf[] bookSelfs;

	@Override
	public String ls() {
		if (bookSelfs == null) {
			return "图书室[" + id + "]，目前是空置的。";
		}

		String rs = "图书室[" + id + "] 拥有书架：";
		rs = Utility.combineLsResult(rs, bookSelfs);

		return rs;
	}

	@Override
	public String cd(String path) {
		Context cntxt = BaseCommand.THREAD_CONTEXT.get();
		if (cntxt.getEqu() instanceof Room) {
			Room room = (Room) cntxt.getEqu();
			for (BookSelf shelf : room.getBookSelfs()) {
				if (shelf.getId().equals(path)) {
					cntxt.setEqu(shelf);
					return "上下文切换成功， 当前当下文：在图书架【" + shelf.getName() +"】";
				}
			}
		}
		return "上下文切换失败，当前上下文：" + cntxt.getEqu().getName();
	}

	public BookSelf[] getBookSelfs() {
		return bookSelfs;
	}

	public void setBookSelfs(BookSelf[] bookSelfs) {
		this.bookSelfs = bookSelfs;
	}
	
}
