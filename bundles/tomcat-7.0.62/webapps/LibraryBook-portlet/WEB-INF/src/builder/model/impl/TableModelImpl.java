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
import builder.model.TableModel;
import builder.model.TableSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Table service. Represents a row in the &quot;librarian_Table&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link builder.model.TableModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TableImpl}.
 * </p>
 *
 * @author Sasha
 * @see TableImpl
 * @see builder.model.Table
 * @see builder.model.TableModel
 * @generated
 */
@JSON(strict = true)
public class TableModelImpl extends BaseModelImpl<Table> implements TableModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a table model instance should use the {@link builder.model.Table} interface instead.
	 */
	public static final String TABLE_NAME = "librarian_Table";
	public static final Object[][] TABLE_COLUMNS = {
			{ "tableId", Types.BIGINT },
			{ "tableBookName", Types.VARCHAR },
			{ "tableBookDescription", Types.VARCHAR },
			{ "tableAuthorName", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table librarian_Table (tableId LONG not null primary key,tableBookName VARCHAR(75) null,tableBookDescription VARCHAR(75) null,tableAuthorName VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table librarian_Table";
	public static final String ORDER_BY_JPQL = " ORDER BY table.tableId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY librarian_Table.tableId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.builder.model.Table"), false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.builder.model.Table"), false);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Table toModel(TableSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Table model = new TableImpl();

		model.setTableId(soapModel.getTableId());
		model.setTableBookName(soapModel.getTableBookName());
		model.setTableBookDescription(soapModel.getTableBookDescription());
		model.setTableAuthorName(soapModel.getTableAuthorName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Table> toModels(TableSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Table> models = new ArrayList<Table>(soapModels.length);

		for (TableSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.builder.model.Table"));

	public TableModelImpl() {
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
	public Class<?> getModelClass() {
		return Table.class;
	}

	@Override
	public String getModelClassName() {
		return Table.class.getName();
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

	@JSON
	@Override
	public long getTableId() {
		return _tableId;
	}

	@Override
	public void setTableId(long tableId) {
		_tableId = tableId;
	}

	@JSON
	@Override
	public String getTableBookName() {
		if (_tableBookName == null) {
			return StringPool.BLANK;
		}
		else {
			return _tableBookName;
		}
	}

	@Override
	public void setTableBookName(String tableBookName) {
		_tableBookName = tableBookName;
	}

	@JSON
	@Override
	public String getTableBookDescription() {
		if (_tableBookDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _tableBookDescription;
		}
	}

	@Override
	public void setTableBookDescription(String tableBookDescription) {
		_tableBookDescription = tableBookDescription;
	}

	@JSON
	@Override
	public String getTableAuthorName() {
		if (_tableAuthorName == null) {
			return StringPool.BLANK;
		}
		else {
			return _tableAuthorName;
		}
	}

	@Override
	public void setTableAuthorName(String tableAuthorName) {
		_tableAuthorName = tableAuthorName;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Table.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Table toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Table)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TableImpl tableImpl = new TableImpl();

		tableImpl.setTableId(getTableId());
		tableImpl.setTableBookName(getTableBookName());
		tableImpl.setTableBookDescription(getTableBookDescription());
		tableImpl.setTableAuthorName(getTableAuthorName());

		tableImpl.resetOriginalValues();

		return tableImpl;
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

		if (!(obj instanceof Table)) {
			return false;
		}

		Table table = (Table)obj;

		long primaryKey = table.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Table> toCacheModel() {
		TableCacheModel tableCacheModel = new TableCacheModel();

		tableCacheModel.tableId = getTableId();

		tableCacheModel.tableBookName = getTableBookName();

		String tableBookName = tableCacheModel.tableBookName;

		if ((tableBookName != null) && (tableBookName.length() == 0)) {
			tableCacheModel.tableBookName = null;
		}

		tableCacheModel.tableBookDescription = getTableBookDescription();

		String tableBookDescription = tableCacheModel.tableBookDescription;

		if ((tableBookDescription != null) &&
				(tableBookDescription.length() == 0)) {
			tableCacheModel.tableBookDescription = null;
		}

		tableCacheModel.tableAuthorName = getTableAuthorName();

		String tableAuthorName = tableCacheModel.tableAuthorName;

		if ((tableAuthorName != null) && (tableAuthorName.length() == 0)) {
			tableCacheModel.tableAuthorName = null;
		}

		return tableCacheModel;
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

	private static ClassLoader _classLoader = Table.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Table.class };
	private long _tableId;
	private String _tableBookName;
	private String _tableBookDescription;
	private String _tableAuthorName;
	private Table _escapedModel;
}