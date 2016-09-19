package com.softwerke;

import builder.model.Author;
import builder.service.BookLocalServiceUtil;

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
