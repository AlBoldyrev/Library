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

import builder.model.Table;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Table in entity cache.
 *
 * @author Sasha
 * @see Table
 * @generated
 */
public class TableCacheModel implements CacheModel<Table>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{tableId=");
		sb.append(tableId);
		sb.append(", tableBookName=");
		sb.append(tableBookName);
		sb.append(", tableBookDescription=");
		sb.append(tableBookDescription);
		sb.append(", tableAuthorName=");
		sb.append(tableAuthorName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Table toEntityModel() {
		TableImpl tableImpl = new TableImpl();

		tableImpl.setTableId(tableId);

		if (tableBookName == null) {
			tableImpl.setTableBookName(StringPool.BLANK);
		}
		else {
			tableImpl.setTableBookName(tableBookName);
		}

		if (tableBookDescription == null) {
			tableImpl.setTableBookDescription(StringPool.BLANK);
		}
		else {
			tableImpl.setTableBookDescription(tableBookDescription);
		}

		if (tableAuthorName == null) {
			tableImpl.setTableAuthorName(StringPool.BLANK);
		}
		else {
			tableImpl.setTableAuthorName(tableAuthorName);
		}

		tableImpl.resetOriginalValues();

		return tableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tableId = objectInput.readLong();
		tableBookName = objectInput.readUTF();
		tableBookDescription = objectInput.readUTF();
		tableAuthorName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(tableId);

		if (tableBookName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tableBookName);
		}

		if (tableBookDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tableBookDescription);
		}

		if (tableAuthorName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tableAuthorName);
		}
	}

	public long tableId;
	public String tableBookName;
	public String tableBookDescription;
	public String tableAuthorName;
}