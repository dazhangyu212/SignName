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
     * �ر�Activity�Ĺ㲥�������Զ���Ļ����У���������Activity�̳����Activity���� 
     * ��Activity�˳�ʱ,���е�Activityȫ���˳�
     */
	protected BroadcastReceiver finishAppReceiver = new BroadcastReceiver(){
		public void onReceive(android.content.Context context, android.content.Intent intent) {
			finish();
		};
		
	};
	
	protected void onResume() {
		super.onResume();
		// �ڵ�ǰ��activity��ע��㲥
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
