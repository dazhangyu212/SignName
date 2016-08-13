package com.hisign.demo.widget;

import android.content.Context;
import android.widget.Toast;

/**
 *
 * @author octopus
 * @description 
 *
 */
public class CustomToast {

	/**
	 * ��toast��ʾ
	 * @param context
	 * @param msg
	 */
	public static void showLongToast(Context context,String msg){
		Toast.makeText(context, msg,  
                Toast.LENGTH_LONG).show();
	}
	
	/**
	 * ��toast��ʾ
	 * 
	 * @param context
	 * @param msg
	 */
	public static void showShortToast(Context context,String msg){
		Toast.makeText(context, msg,  
                Toast.LENGTH_SHORT).show();
	}
	
}
