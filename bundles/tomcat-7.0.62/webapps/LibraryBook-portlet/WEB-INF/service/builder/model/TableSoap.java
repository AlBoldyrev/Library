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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link builder.service.http.TableServiceSoap}.
 *
 * @author Sasha
 * @see builder.service.http.TableServiceSoap
 * @generated
 */
public class TableSoap implements Serializable {
	public static TableSoap toSoapModel(Table model) {
		TableSoap soapModel = new TableSoap();

		soapModel.setTableId(model.getTableId());
		soapModel.setTableBookName(model.getTableBookName());
		soapModel.setTableBookDescription(model.getTableBookDescription());
		soapModel.setTableAuthorName(model.getTableAuthorName());

		return soapModel;
	}

	public static TableSoap[] toSoapModels(Table[] models) {
		TableSoap[] soapModels = new TableSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TableSoap[][] toSoapModels(Table[][] models) {
		TableSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TableSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TableSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TableSoap[] toSoapModels(List<Table> models) {
		List<TableSoap> soapModels = new ArrayList<TableSoap>(models.size());

		for (Table model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TableSoap[soapModels.size()]);
	}

	public TableSoap() {
	}

	public long getPrimaryKey() {
		return _tableId;
	}

	public void setPrimaryKey(long pk) {
		setTableId(pk);
	}

	public long getTableId() {
		return _tableId;
	}

	public void setTableId(long tableId) {
		_tableId = tableId;
	}

	public String getTableBookName() {
		return _tableBookName;
	}

	public void setTableBookName(String tableBookName) {
		_tableBookName = tableBookName;
	}

	public String getTableBookDescription() {
		return _tableBookDescription;
	}

	public void setTableBookDescription(String tableBookDescription) {
		_tableBookDescription = tableBookDescription;
	}

	public String getTableAuthorName() {
		return _tableAuthorName;
	}

	public void setTableAuthorName(String tableAuthorName) {
		_tableAuthorName = tableAuthorName;
	}

	private long _tableId;
	private String _tableBookName;
	private String _tableBookDescription;
	private String _tableAuthorName;
}