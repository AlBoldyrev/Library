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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Table}.
 * </p>
 *
 * @author Sasha
 * @see Table
 * @generated
 */
public class TableWrapper implements Table, ModelWrapper<Table> {
	public TableWrapper(Table table) {
		_table = table;
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

	/**
	* Returns the primary key of this table.
	*
	* @return the primary key of this table
	*/
	@Override
	public long getPrimaryKey() {
		return _table.getPrimaryKey();
	}

	/**
	* Sets the primary key of this table.
	*
	* @param primaryKey the primary key of this table
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_table.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the table ID of this table.
	*
	* @return the table ID of this table
	*/
	@Override
	public long getTableId() {
		return _table.getTableId();
	}

	/**
	* Sets the table ID of this table.
	*
	* @param tableId the table ID of this table
	*/
	@Override
	public void setTableId(long tableId) {
		_table.setTableId(tableId);
	}

	/**
	* Returns the table book name of this table.
	*
	* @return the table book name of this table
	*/
	@Override
	public java.lang.String getTableBookName() {
		return _table.getTableBookName();
	}

	/**
	* Sets the table book name of this table.
	*
	* @param tableBookName the table book name of this table
	*/
	@Override
	public void setTableBookName(java.lang.String tableBookName) {
		_table.setTableBookName(tableBookName);
	}

	/**
	* Returns the table book description of this table.
	*
	* @return the table book description of this table
	*/
	@Override
	public java.lang.String getTableBookDescription() {
		return _table.getTableBookDescription();
	}

	/**
	* Sets the table book description of this table.
	*
	* @param tableBookDescription the table book description of this table
	*/
	@Override
	public void setTableBookDescription(java.lang.String tableBookDescription) {
		_table.setTableBookDescription(tableBookDescription);
	}

	/**
	* Returns the table author name of this table.
	*
	* @return the table author name of this table
	*/
	@Override
	public java.lang.String getTableAuthorName() {
		return _table.getTableAuthorName();
	}

	/**
	* Sets the table author name of this table.
	*
	* @param tableAuthorName the table author name of this table
	*/
	@Override
	public void setTableAuthorName(java.lang.String tableAuthorName) {
		_table.setTableAuthorName(tableAuthorName);
	}

	@Override
	public boolean isNew() {
		return _table.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_table.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _table.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_table.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _table.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _table.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_table.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _table.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_table.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_table.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_table.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TableWrapper((Table)_table.clone());
	}

	@Override
	public int compareTo(builder.model.Table table) {
		return _table.compareTo(table);
	}

	@Override
	public int hashCode() {
		return _table.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<builder.model.Table> toCacheModel() {
		return _table.toCacheModel();
	}

	@Override
	public builder.model.Table toEscapedModel() {
		return new TableWrapper(_table.toEscapedModel());
	}

	@Override
	public builder.model.Table toUnescapedModel() {
		return new TableWrapper(_table.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _table.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _table.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_table.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TableWrapper)) {
			return false;
		}

		TableWrapper tableWrapper = (TableWrapper)obj;

		if (Validator.equals(_table, tableWrapper._table)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Table getWrappedTable() {
		return _table;
	}

	@Override
	public Table getWrappedModel() {
		return _table;
	}

	@Override
	public void resetOriginalValues() {
		_table.resetOriginalValues();
	}

	private Table _table;
}