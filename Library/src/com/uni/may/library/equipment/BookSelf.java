package com.uni.may.library.equipment;

import com.uni.may.library.util.Utility;

public class BookSelf extends BaseEquipment {

	private Book[] books;

	@Override
	public String ls() {
		if (null == books) {
			return "书架[" + id + "]， 为空书架";
		}
		String rs = "书架[" + id + "]里面共有" + this.books.length + "本书:\n";
		
		rs = Utility.combineLsResult(rs, books);
		
		return rs;
	}

	@Override
	public String cd(String path) {

		return null;
	}

	public Book[] getBooks() {
		return books;
	}

	public void setBooks(Book[] books) {
		this.books = books;
	}
}
