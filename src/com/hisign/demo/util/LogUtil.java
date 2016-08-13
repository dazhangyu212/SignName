package com.hisign.demo.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.os.Environment;
import android.util.Log;

public class LogUtil {

	public static void logE(String tag, String msg) {
		Log.e(tag, msg);
	};

	public static void logV(String tag, String msg) {
		Log.v(tag, msg);
	};

	/**
	 * 以文件的形式插入系统错误日志
	 * 
	 * @param SysLogModel
	 * @return 日志id
	 */
	public static void insertSysLogTOFile(Exception e) {
		saveCrashInfo2File(e);
	}

	/**
	 * 保存错误信息到文件中
	 * 
	 * @param ex
	 * @return 返回文件名称,便于将文件传送到服务�?
	 */
	@SuppressWarnings("finally")
	private static String saveCrashInfo2File(Exception e) {
		StringWriter sw = null;
		PrintWriter pw = null;
		FileOutputStream fos = null;

		String fileName = null;
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss",Locale.PRC);
			long timestamp = System.currentTimeMillis();
			String time = formatter.format(new Date());
			fileName = "CaughtException-" + time + "-" + timestamp + ".txt";
			if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
				String path = Constants.LOG_PATH;
				File dir = new File(path);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				sw = new StringWriter();
				pw = new PrintWriter(sw);
				// 将出错的栈信息输出到printWriter�?
				e.printStackTrace(pw);
				pw.flush();
				sw.flush();

				fos = new FileOutputStream(path + fileName);
				fos.write(sw.toString().getBytes());
			}
		} catch (Exception ex) {
			LogUtil.insertSysLogTOFile(e);
		} finally {
			try {
				if (sw != null) {

					sw.close();

				}
				if (pw != null) {
					pw.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e1) {
				LogUtil.insertSysLogTOFile(e1);
			}
			return fileName;
		}
	}
}
