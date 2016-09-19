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

import builder.NoSuchTableException;

import builder.model.Table;

import builder.model.impl.TableImpl;
import builder.model.impl.TableModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sasha
 * @see TablePersistence
 * @see TableUtil
 * @generated
 */
public class TablePersistenceImpl extends BasePersistenceImpl<Table>
	implements TablePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TableUtil} to access the table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TableImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TableModelImpl.ENTITY_CACHE_ENABLED,
			TableModelImpl.FINDER_CACHE_ENABLED, TableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TableModelImpl.ENTITY_CACHE_ENABLED,
			TableModelImpl.FINDER_CACHE_ENABLED, TableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TableModelImpl.ENTITY_CACHE_ENABLED,
			TableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TablePersistenceImpl() {
		setModelClass(Table.class);
	}

	/**
	 * Caches the table in the entity cache if it is enabled.
	 *
	 * @param table the table
	 */
	@Override
	public void cacheResult(Table table) {
		EntityCacheUtil.putResult(TableModelImpl.ENTITY_CACHE_ENABLED,
			TableImpl.class, table.getPrimaryKey(), table);

		table.resetOriginalValues();
	}

	/**
	 * Caches the tables in the entity cache if it is enabled.
	 *
	 * @param tables the tables
	 */
	@Override
	public void cacheResult(List<Table> tables) {
		for (Table table : tables) {
			if (EntityCacheUtil.getResult(TableModelImpl.ENTITY_CACHE_ENABLED,
						TableImpl.class, table.getPrimaryKey()) == null) {
				cacheResult(table);
			}
			else {
				table.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tables.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TableImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TableImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the table.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Table table) {
		EntityCacheUtil.removeResult(TableModelImpl.ENTITY_CACHE_ENABLED,
			TableImpl.class, table.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Table> tables) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Table table : tables) {
			EntityCacheUtil.removeResult(TableModelImpl.ENTITY_CACHE_ENABLED,
				TableImpl.class, table.getPrimaryKey());
		}
	}

	/**
	 * Creates a new table with the primary key. Does not add the table to the database.
	 *
	 * @param tableId the primary key for the new table
	 * @return the new table
	 */
	@Override
	public Table create(long tableId) {
		Table table = new TableImpl();

		table.setNew(true);
		table.setPrimaryKey(tableId);

		return table;
	}

	/**
	 * Removes the table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tableId the primary key of the table
	 * @return the table that was removed
	 * @throws builder.NoSuchTableException if a table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Table remove(long tableId)
		throws NoSuchTableException, SystemException {
		return remove((Serializable)tableId);
	}

	/**
	 * Removes the table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the table
	 * @return the table that was removed
	 * @throws builder.NoSuchTableException if a table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Table remove(Serializable primaryKey)
		throws NoSuchTableException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Table table = (Table)session.get(TableImpl.class, primaryKey);

			if (table == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(table);
		}
		catch (NoSuchTableException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Table removeImpl(Table table) throws SystemException {
		table = toUnwrappedModel(table);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(table)) {
				table = (Table)session.get(TableImpl.class,
						table.getPrimaryKeyObj());
			}

			if (table != null) {
				session.delete(table);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (table != null) {
			clearCache(table);
		}

		return table;
	}

	@Override
	public Table updateImpl(builder.model.Table table)
		throws SystemException {
		table = toUnwrappedModel(table);

		boolean isNew = table.isNew();

		Session session = null;

		try {
			session = openSession();

			if (table.isNew()) {
				session.save(table);

				table.setNew(false);
			}
			else {
				session.merge(table);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(TableModelImpl.ENTITY_CACHE_ENABLED,
			TableImpl.class, table.getPrimaryKey(), table);

		return table;
	}

	protected Table toUnwrappedModel(Table table) {
		if (table instanceof TableImpl) {
			return table;
		}

		TableImpl tableImpl = new TableImpl();

		tableImpl.setNew(table.isNew());
		tableImpl.setPrimaryKey(table.getPrimaryKey());

		tableImpl.setTableId(table.getTableId());
		tableImpl.setTableBookName(table.getTableBookName());
		tableImpl.setTableBookDescription(table.getTableBookDescription());
		tableImpl.setTableAuthorName(table.getTableAuthorName());

		return tableImpl;
	}

	/**
	 * Returns the table with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the table
	 * @return the table
	 * @throws builder.NoSuchTableException if a table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Table findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTableException, SystemException {
		Table table = fetchByPrimaryKey(primaryKey);

		if (table == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return table;
	}

	/**
	 * Returns the table with the primary key or throws a {@link builder.NoSuchTableException} if it could not be found.
	 *
	 * @param tableId the primary key of the table
	 * @return the table
	 * @throws builder.NoSuchTableException if a table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Table findByPrimaryKey(long tableId)
		throws NoSuchTableException, SystemException {
		return findByPrimaryKey((Serializable)tableId);
	}

	/**
	 * Returns the table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the table
	 * @return the table, or <code>null</code> if a table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Table fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Table table = (Table)EntityCacheUtil.getResult(TableModelImpl.ENTITY_CACHE_ENABLED,
				TableImpl.class, primaryKey);

		if (table == _nullTable) {
			return null;
		}

		if (table == null) {
			Session session = null;

			try {
				session = openSession();

				table = (Table)session.get(TableImpl.class, primaryKey);

				if (table != null) {
					cacheResult(table);
				}
				else {
					EntityCacheUtil.putResult(TableModelImpl.ENTITY_CACHE_ENABLED,
						TableImpl.class, primaryKey, _nullTable);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TableModelImpl.ENTITY_CACHE_ENABLED,
					TableImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return table;
	}

	/**
	 * Returns the table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tableId the primary key of the table
	 * @return the table, or <code>null</code> if a table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Table fetchByPrimaryKey(long tableId) throws SystemException {
		return fetchByPrimaryKey((Serializable)tableId);
	}

	/**
	 * Returns all the tables.
	 *
	 * @return the tables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Table> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Table> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Table> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Table> list = (List<Table>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TABLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TABLE;

				if (pagination) {
					sql = sql.concat(TableModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Table>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Table>(list);
				}
				else {
					list = (List<Table>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the tables from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Table table : findAll()) {
			remove(table);
		}
	}

	/**
	 * Returns the number of tables.
	 *
	 * @return the number of tables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TABLE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the table persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.builder.model.Table")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Table>> listenersList = new ArrayList<ModelListener<Table>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Table>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TableImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TABLE = "SELECT table FROM Table table";
	private static final String _SQL_COUNT_TABLE = "SELECT COUNT(table) FROM Table table";
	private static final String _ORDER_BY_ENTITY_ALIAS = "table.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Table exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TablePersistenceImpl.class);
	private static Table _nullTable = new TableImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Table> toCacheModel() {
				return _nullTableCacheModel;
			}
		};

	private static CacheModel<Table> _nullTableCacheModel = new CacheModel<Table>() {
			@Override
			public Table toEntityModel() {
				return _nullTable;
			}
		};
}