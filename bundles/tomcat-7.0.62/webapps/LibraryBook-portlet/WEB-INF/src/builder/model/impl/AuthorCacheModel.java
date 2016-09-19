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

package builder.model.impl;

import builder.model.Author;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Author in entity cache.
 *
 * @author Sasha
 * @see Author
 * @generated
 */
public class AuthorCacheModel implements CacheModel<Author>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{authorId=");
		sb.append(authorId);
		sb.append(", authorName=");
		sb.append(authorName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Author toEntityModel() {
		AuthorImpl authorImpl = new AuthorImpl();

		authorImpl.setAuthorId(authorId);

		if (authorName == null) {
			authorImpl.setAuthorName(StringPool.BLANK);
		}
		else {
			authorImpl.setAuthorName(authorName);
		}

		authorImpl.resetOriginalValues();

		return authorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		authorId = objectInput.readLong();
		authorName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(authorId);

		if (authorName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(authorName);
		}
	}

	public long authorId;
	public String authorName;
}