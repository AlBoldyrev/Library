/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.softwerke.services.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.softwerke.services.model.Book;
import com.softwerke.services.service.base.BookLocalServiceBaseImpl;
import com.softwerke.services.service.persistence.BookUtil;

/**
 * The implementation of the book local service. <p> All custom service methods should be put in this class. Whenever
 * methods are added, rerun ServiceBuilder to copy their definitions into the {@link builder.service.BookLocalService}
 * interface. <p> This is a local service. Methods of this service will not have security checks based on the propagated
 * JAAS credentials because this service can only be accessed from within the same VM. </p>
 * 
 * @author Sasha
 * @see builder.service.base.BookLocalServiceBaseImpl
 * @see builder.service.BookLocalServiceUtil
 */
public class BookLocalServiceImpl extends BookLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use {@link
	 * builder.service.BookLocalServiceUtil} to access the book local service.
	 */
	
	private static Log log = LogFactoryUtil.getLog(BookLocalServiceImpl.class);
	
	public List<Book> getByAuthor(long authorId) {
		
		List<Book> books = new ArrayList<Book>();
		try {
			return BookUtil.findByAuthor(authorId);
		} catch (SystemException ex) {
			log.error(ex.getMessage());
		}

		return books;
	}

	public int countByAuthor(long authorId) {
		
		int count = 0;
		try {
			count = BookUtil.countByAuthor(authorId);
		} catch (SystemException ex) {
			log.error(ex.getMessage());
		}
		return count;
	}
}