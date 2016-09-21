/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.softwerke.services.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.softwerke.services.model.Book;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Book in entity cache.
 *
 * @author Sasha
 * @see Book
 * @generated
 */
public class BookCacheModel implements CacheModel<Book>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{bookId=");
		sb.append(bookId);
		sb.append(", bookName=");
		sb.append(bookName);
		sb.append(", bookDescription=");
		sb.append(bookDescription);
		sb.append(", authorId=");
		sb.append(authorId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Book toEntityModel() {
		BookImpl bookImpl = new BookImpl();

		bookImpl.setBookId(bookId);

		if (bookName == null) {
			bookImpl.setBookName(StringPool.BLANK);
		}
		else {
			bookImpl.setBookName(bookName);
		}

		if (bookDescription == null) {
			bookImpl.setBookDescription(StringPool.BLANK);
		}
		else {
			bookImpl.setBookDescription(bookDescription);
		}

		bookImpl.setAuthorId(authorId);

		bookImpl.resetOriginalValues();

		return bookImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bookId = objectInput.readLong();
		bookName = objectInput.readUTF();
		bookDescription = objectInput.readUTF();
		authorId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(bookId);

		if (bookName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bookName);
		}

		if (bookDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bookDescription);
		}

		objectOutput.writeLong(authorId);
	}

	public long bookId;
	public String bookName;
	public String bookDescription;
	public long authorId;
}