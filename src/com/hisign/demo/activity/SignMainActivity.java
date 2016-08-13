package com.hisign.demo.activity;

import com.octopus.demo.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

/**
 *
 * @author octopus
 * @description 
 *
 */
public class SignMainActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signmain);
	}
	
	/**
	 * ��¼����˳���ť��ʱ��
	 */
	private long exitTime = 0;
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (KeyEvent.KEYCODE_BACK == keyCode) {
			if (System.currentTimeMillis() - exitTime > 2000) {
				Toast.makeText(getApplicationContext(), getResources().getString(R.string.str_exit_app), Toast.LENGTH_LONG).show();
				exitTime = System.currentTimeMillis();
			}else {
				exitApp();
			}
			return true;
		}
		
		return super.onKeyDown(keyCode, event);
	}
	
	/** 
     * �˳�Ӧ�ó���ķ����������˳�����Ĺ㲥 
     */  
    private void exitApp() {  
        Intent intent = new Intent();  
        intent.setAction("com.stone.ordering");  
        this.sendBroadcast(intent);  
    }  
}
