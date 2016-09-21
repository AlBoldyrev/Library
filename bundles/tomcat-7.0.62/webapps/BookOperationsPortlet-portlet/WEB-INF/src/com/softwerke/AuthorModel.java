package com.softwerke;

import com.softwerke.services.model.Author;
import com.softwerke.services.service.BookLocalServiceUtil;

public class AuthorModel {
	private Author author;
	private int count;
	public AuthorModel(Author author) {
		this.author = author;
		this.count = BookLocalServiceUtil.countByAuthor(author.getAuthorId());
	}
	
	public String getAuthorName() {
		return author.getAuthorName();
	}
	
	public long getAuthorId() {
		return author.getAuthorId();
	}
	
	public int getCount() {
		return count;
	}
}
