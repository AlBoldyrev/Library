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

package builder.service.persistence;

import builder.model.Table;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sasha
 * @see TablePersistenceImpl
 * @see TableUtil
 * @generated
 */
public interface TablePersistence extends BasePersistence<Table> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TableUtil} to access the table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the table in the entity cache if it is enabled.
	*
	* @param table the table
	*/
	public void cacheResult(builder.model.Table table);

	/**
	* Caches the tables in the entity cache if it is enabled.
	*
	* @param tables the tables
	*/
	public void cacheResult(java.util.List<builder.model.Table> tables);

	/**
	* Creates a new table with the primary key. Does not add the table to the database.
	*
	* @param tableId the primary key for the new table
	* @return the new table
	*/
	public builder.model.Table create(long tableId);

	/**
	* Removes the table with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tableId the primary key of the table
	* @return the table that was removed
	* @throws builder.NoSuchTableException if a table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public builder.model.Table remove(long tableId)
		throws builder.NoSuchTableException,
			com.liferay.portal.kernel.exception.SystemException;

	public builder.model.Table updateImpl(builder.model.Table table)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the table with the primary key or throws a {@link builder.NoSuchTableException} if it could not be found.
	*
	* @param tableId the primary key of the table
	* @return the table
	* @throws builder.NoSuchTableException if a table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public builder.model.Table findByPrimaryKey(long tableId)
		throws builder.NoSuchTableException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the table with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tableId the primary key of the table
	* @return the table, or <code>null</code> if a table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public builder.model.Table fetchByPrimaryKey(long tableId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tables.
	*
	* @return the tables
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<builder.model.Table> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<builder.model.Table> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link builder.model.impl.TableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tables
	* @param end the upper bound of the range of tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tables
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<builder.model.Table> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tables from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tables.
	*
	* @return the number of tables
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}