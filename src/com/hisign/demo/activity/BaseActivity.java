package com.hisign.demo.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/**
 *
 * @author octopus
 * @description 
 *
 */
public class BaseActivity extends Activity {
	/** 
     * 退出程序
     */
	protected BroadcastReceiver finishAppReceiver = new BroadcastReceiver(){
		public void onReceive(android.content.Context context, android.content.Intent intent) {
			finish();
		};
		
	};
	
	protected void onResume() {
		super.onResume();
		// 接受消息
		IntentFilter filter= new IntentFilter();
		filter.addAction("com.octopus.demo");
		this.registerReceiver(this.finishAppReceiver, filter);
	};
	
	@Override  
    protected void onDestroy() {  
        super.onDestroy();  
        this.unregisterReceiver(this.finishAppReceiver);  
    }  
}
