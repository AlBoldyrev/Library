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

package builder.model;

import builder.service.ClpSerializer;
import builder.service.TableLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sasha
 */
public class TableClp extends BaseModelImpl<Table> implements Table {
	public TableClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Table.class;
	}

	@Override
	public String getModelClassName() {
		return Table.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _tableId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTableId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tableId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tableId", getTableId());
		attributes.put("tableBookName", getTableBookName());
		attributes.put("tableBookDescription", getTableBookDescription());
		attributes.put("tableAuthorName", getTableAuthorName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tableId = (Long)attributes.get("tableId");

		if (tableId != null) {
			setTableId(tableId);
		}

		String tableBookName = (String)attributes.get("tableBookName");

		if (tableBookName != null) {
			setTableBookName(tableBookName);
		}

		String tableBookDescription = (String)attributes.get(
				"tableBookDescription");

		if (tableBookDescription != null) {
			setTableBookDescription(tableBookDescription);
		}

		String tableAuthorName = (String)attributes.get("tableAuthorName");

		if (tableAuthorName != null) {
			setTableAuthorName(tableAuthorName);
		}
	}

	@Override
	public long getTableId() {
		return _tableId;
	}

	@Override
	public void setTableId(long tableId) {
		_tableId = tableId;

		if (_tableRemoteModel != null) {
			try {
				Class<?> clazz = _tableRemoteModel.getClass();

				Method method = clazz.getMethod("setTableId", long.class);

				method.invoke(_tableRemoteModel, tableId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTableBookName() {
		return _tableBookName;
	}

	@Override
	public void setTableBookName(String tableBookName) {
		_tableBookName = tableBookName;

		if (_tableRemoteModel != null) {
			try {
				Class<?> clazz = _tableRemoteModel.getClass();

				Method method = clazz.getMethod("setTableBookName", String.class);

				method.invoke(_tableRemoteModel, tableBookName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTableBookDescription() {
		return _tableBookDescription;
	}

	@Override
	public void setTableBookDescription(String tableBookDescription) {
		_tableBookDescription = tableBookDescription;

		if (_tableRemoteModel != null) {
			try {
				Class<?> clazz = _tableRemoteModel.getClass();

				Method method = clazz.getMethod("setTableBookDescription",
						String.class);

				method.invoke(_tableRemoteModel, tableBookDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTableAuthorName() {
		return _tableAuthorName;
	}

	@Override
	public void setTableAuthorName(String tableAuthorName) {
		_tableAuthorName = tableAuthorName;

		if (_tableRemoteModel != null) {
			try {
				Class<?> clazz = _tableRemoteModel.getClass();

				Method method = clazz.getMethod("setTableAuthorName",
						String.class);

				method.invoke(_tableRemoteModel, tableAuthorName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTableRemoteModel() {
		return _tableRemoteModel;
	}

	public void setTableRemoteModel(BaseModel<?> tableRemoteModel) {
		_tableRemoteModel = tableRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _tableRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_tableRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TableLocalServiceUtil.addTable(this);
		}
		else {
			TableLocalServiceUtil.updateTable(this);
		}
	}

	@Override
	public Table toEscapedModel() {
		return (Table)ProxyUtil.newProxyInstance(Table.class.getClassLoader(),
			new Class[] { Table.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TableClp clone = new TableClp();

		clone.setTableId(getTableId());
		clone.setTableBookName(getTableBookName());
		clone.setTableBookDescription(getTableBookDescription());
		clone.setTableAuthorName(getTableAuthorName());

		return clone;
	}

	@Override
	public int compareTo(Table table) {
		long primaryKey = table.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TableClp)) {
			return false;
		}

		TableClp table = (TableClp)obj;

		long primaryKey = table.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{tableId=");
		sb.append(getTableId());
		sb.append(", tableBookName=");
		sb.append(getTableBookName());
		sb.append(", tableBookDescription=");
		sb.append(getTableBookDescription());
		sb.append(", tableAuthorName=");
		sb.append(getTableAuthorName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("builder.model.Table");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tableId</column-name><column-value><![CDATA[");
		sb.append(getTableId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tableBookName</column-name><column-value><![CDATA[");
		sb.append(getTableBookName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tableBookDescription</column-name><column-value><![CDATA[");
		sb.append(getTableBookDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tableAuthorName</column-name><column-value><![CDATA[");
		sb.append(getTableAuthorName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _tableId;
	private String _tableBookName;
	private String _tableBookDescription;
	private String _tableAuthorName;
	private BaseModel<?> _tableRemoteModel;
	private Class<?> _clpSerializerClass = builder.service.ClpSerializer.class;
}