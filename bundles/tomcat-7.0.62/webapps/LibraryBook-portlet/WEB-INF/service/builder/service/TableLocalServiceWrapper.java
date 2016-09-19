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

package builder.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TableLocalService}.
 *
 * @author Sasha
 * @see TableLocalService
 * @generated
 */
public class TableLocalServiceWrapper implements TableLocalService,
	ServiceWrapper<TableLocalService> {
	public TableLocalServiceWrapper(TableLocalService tableLocalService) {
		_tableLocalService = tableLocalService;
	}

	/**
	* Adds the table to the database. Also notifies the appropriate model listeners.
	*
	* @param table the table
	* @return the table that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public builder.model.Table addTable(builder.model.Table table)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tableLocalService.addTable(table);
	}

	/**
	* Creates a new table with the primary key. Does not add the table to the database.
	*
	* @param tableId the primary key for the new table
	* @return the new table
	*/
	@Override
	public builder.model.Table createTable(long tableId) {
		return _tableLocalService.createTable(tableId);
	}

	/**
	* Deletes the table with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tableId the primary key of the table
	* @return the table that was removed
	* @throws PortalException if a table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public builder.model.Table deleteTable(long tableId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tableLocalService.deleteTable(tableId);
	}

	/**
	* Deletes the table from the database. Also notifies the appropriate model listeners.
	*
	* @param table the table
	* @return the table that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public builder.model.Table deleteTable(builder.model.Table table)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tableLocalService.deleteTable(table);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tableLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tableLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link builder.model.impl.TableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _tableLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link builder.model.impl.TableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tableLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tableLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tableLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public builder.model.Table fetchTable(long tableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tableLocalService.fetchTable(tableId);
	}

	/**
	* Returns the table with the primary key.
	*
	* @param tableId the primary key of the table
	* @return the table
	* @throws PortalException if a table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public builder.model.Table getTable(long tableId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tableLocalService.getTable(tableId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tableLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link builder.model.impl.TableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tables
	* @param end the upper bound of the range of tables (not inclusive)
	* @return the range of tables
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<builder.model.Table> getTables(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tableLocalService.getTables(start, end);
	}

	/**
	* Returns the number of tables.
	*
	* @return the number of tables
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTablesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tableLocalService.getTablesCount();
	}

	/**
	* Updates the table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param table the table
	* @return the table that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public builder.model.Table updateTable(builder.model.Table table)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tableLocalService.updateTable(table);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tableLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tableLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tableLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TableLocalService getWrappedTableLocalService() {
		return _tableLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTableLocalService(TableLocalService tableLocalService) {
		_tableLocalService = tableLocalService;
	}

	@Override
	public TableLocalService getWrappedService() {
		return _tableLocalService;
	}

	@Override
	public void setWrappedService(TableLocalService tableLocalService) {
		_tableLocalService = tableLocalService;
	}

	private TableLocalService _tableLocalService;
}