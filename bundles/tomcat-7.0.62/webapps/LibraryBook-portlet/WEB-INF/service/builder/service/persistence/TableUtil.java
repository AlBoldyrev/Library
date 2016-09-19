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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the table service. This utility wraps {@link TablePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sasha
 * @see TablePersistence
 * @see TablePersistenceImpl
 * @generated
 */
public class TableUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Table table) {
		getPersistence().clearCache(table);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Table> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Table> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Table> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Table update(Table table) throws SystemException {
		return getPersistence().update(table);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Table update(Table table, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(table, serviceContext);
	}

	/**
	* Caches the table in the entity cache if it is enabled.
	*
	* @param table the table
	*/
	public static void cacheResult(builder.model.Table table) {
		getPersistence().cacheResult(table);
	}

	/**
	* Caches the tables in the entity cache if it is enabled.
	*
	* @param tables the tables
	*/
	public static void cacheResult(java.util.List<builder.model.Table> tables) {
		getPersistence().cacheResult(tables);
	}

	/**
	* Creates a new table with the primary key. Does not add the table to the database.
	*
	* @param tableId the primary key for the new table
	* @return the new table
	*/
	public static builder.model.Table create(long tableId) {
		return getPersistence().create(tableId);
	}

	/**
	* Removes the table with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tableId the primary key of the table
	* @return the table that was removed
	* @throws builder.NoSuchTableException if a table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static builder.model.Table remove(long tableId)
		throws builder.NoSuchTableException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(tableId);
	}

	public static builder.model.Table updateImpl(builder.model.Table table)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(table);
	}

	/**
	* Returns the table with the primary key or throws a {@link builder.NoSuchTableException} if it could not be found.
	*
	* @param tableId the primary key of the table
	* @return the table
	* @throws builder.NoSuchTableException if a table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static builder.model.Table findByPrimaryKey(long tableId)
		throws builder.NoSuchTableException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(tableId);
	}

	/**
	* Returns the table with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tableId the primary key of the table
	* @return the table, or <code>null</code> if a table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static builder.model.Table fetchByPrimaryKey(long tableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(tableId);
	}

	/**
	* Returns all the tables.
	*
	* @return the tables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<builder.model.Table> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<builder.model.Table> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<builder.model.Table> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tables from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tables.
	*
	* @return the number of tables
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TablePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TablePersistence)PortletBeanLocatorUtil.locate(builder.service.ClpSerializer.getServletContextName(),
					TablePersistence.class.getName());

			ReferenceRegistry.registerReference(TableUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TablePersistence persistence) {
	}

	private static TablePersistence _persistence;
}