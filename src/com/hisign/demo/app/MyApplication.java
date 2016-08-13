package com.hisign.demo.app;

import java.io.File;

import com.hisign.demo.data.DatabaseHelper;
import com.hisign.demo.exception.CrashHandler;
import com.hisign.demo.util.Constants;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.octopus.demo.R;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;

/**
 *
 * @author octopus
 * @description 
 *
 */
public class MyApplication extends Application {
	private static MyApplication myApplication = null;

	@Override
	public void onCreate() {
		super.onCreate();
		myApplication = this;
		CrashHandler crashHandler = CrashHandler.getInstance();
		crashHandler.init(getApplicationContext());
		initDir();
		initDB();
		initImageLoader();
	}

	private void initImageLoader() {

		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.ic_launcher)
				.showImageOnFail(R.drawable.ic_launcher)
				.cacheInMemory(false)
				.cacheOnDisk(false)
				.bitmapConfig(Bitmap.Config.RGB_565).build();


		ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(getApplicationContext()).defaultDisplayImageOptions(options).build());
	}

	private void initDir() {
		File dbs = new File(Constants.DATA_PATH);
		if (!dbs.exists()) {
			dbs.mkdirs();
		}
		File temp = new File(Constants.LOG_PATH );
		if (!temp.exists()) {
			temp.mkdirs();
		}
		File dishes = new File(Constants.DISHES_PATH);
		if (!dishes.exists()) {
			dishes.mkdirs();
		}

	}

	private void initDB() {
		File file = new File(Constants.COLLECT_DB_PATH);
		if (!file.exists()) {
//			if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
				File parent = file.getParentFile();
				parent.mkdirs();
				SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(Constants.COLLECT_DB_PATH, null);
				DatabaseHelper orm;
				orm = DatabaseHelper.getHelper();
				orm.onCreate(db);
				db.close();
//			}
		} else {

		}
	
	}

	/**
	 * 
	 * @return
	 */
	public static MyApplication getMyApplication() {
		return myApplication;
	}
}
