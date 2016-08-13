package com.hisign.demo.data;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hisign.demo.app.MyApplication;
import com.hisign.demo.model.Authority;
import com.hisign.demo.model.SignRecord;
import com.hisign.demo.model.User;
import com.hisign.demo.util.Constants;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDatabase;

/**
 * 类名：DatabaseHelper 
 * 描述：数据库操作帮助�? 
 * 公司:北京海鑫科金高科�?股份有限公司 
 * 作�?�：zhangyu 
 * 版本：V1.0
 * 创建时间�?2015�?9�?10�? 
 * �?后修改时间：2015�?9�?10�?
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	private static DatabaseHelper instance;

	private Map<String, Dao> daos = new HashMap<String, Dao>();
	
	private static final int DB_VERSION = 1;
	
	public DatabaseHelper(Context context) throws NameNotFoundException {
		super(context, Constants.COLLECT_DB_PATH, null, context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
	}

	@Override
	public synchronized SQLiteDatabase getReadableDatabase() {
		return SQLiteDatabase.openDatabase(Constants.COLLECT_DB_PATH, null, SQLiteDatabase.OPEN_READONLY);
	}

	@Override
	public synchronized SQLiteDatabase getWritableDatabase() {
		return SQLiteDatabase.openDatabase(Constants.COLLECT_DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
	}

	@Override
	public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
		try {
			TableUtils.createTable(connectionSource, Authority.class);
			TableUtils.createTable(connectionSource, SignRecord.class);
			TableUtils.createTable(connectionSource, User.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
		try {
			TableUtils.createTable(connectionSource, Authority.class);
			TableUtils.createTable(connectionSource, SignRecord.class);
			TableUtils.createTable(connectionSource, User.class);
			onCreate(database, connectionSource);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static synchronized DatabaseHelper getHelper() {
		Context context = MyApplication.getMyApplication().getApplicationContext();
		if (instance == null) {
			synchronized (DatabaseHelper.class) {
				if (instance == null)
					try {
						instance = new DatabaseHelper(context);
					} catch (NameNotFoundException e) {
						e.printStackTrace();
					}
			}
		}
		
		return instance;
	}

	public synchronized Dao getDao(Class clazz) throws SQLException {
		Dao dao = null;
		String className = clazz.getSimpleName();

		if (daos.containsKey(className)) {
			dao = daos.get(className);
		}
		if (dao == null) {
			dao = super.getDao(clazz);
			daos.put(className, dao);
		}
		return dao;
	}

	@Override
	public void close() {
		super.close();

		for (String key : daos.keySet()) {
			Dao dao = daos.get(key);
			dao = null;
		}
	}

}
