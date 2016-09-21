package com.softwerke;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.softwerke.services.service.AuthorLocalServiceUtil;
import com.softwerke.services.model.Author;
import com.softwerke.services.model.Book;

public class BookModel {
	private Book book;
	private Author author;
	private long authorId;

	public BookModel(Book book) {
		this.book = book;	
	}
	
	public String getBookName() {
		return book.getBookName();
	}

	public String getBookDescription() {
		return book.getBookDescription();
	}

	public String getAuthorName() throws PortalException, SystemException {
		this.authorId = book.getAuthorId();
		author = AuthorLocalServiceUtil.getAuthor(authorId);
		String authorName = author.getAuthorName();
		return authorName;
	}
	
	public long getBookId() {
		return book.getBookId();
	}


}
