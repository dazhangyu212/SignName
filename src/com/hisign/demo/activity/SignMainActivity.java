package com.hisign.demo.activity;

import com.hisign.demo.event.DialogInterface;
import com.hisign.demo.fragment.SignInTimeDialogFragment;
import com.octopus.demo.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 * @author octopus
 * @description 
 *
 */
public class SignMainActivity extends BaseActivity implements OnClickListener{
	
	private TextView tvSigninTime;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signmain);
		initView();
	}
	
	private void initView() {
		findViewById(R.id.btn_sign_in_save).setOnClickListener(this);
		findViewById(R.id.btn_sign_in_now).setOnClickListener(this);
		findViewById(R.id.btn_sign_in_type).setOnClickListener(this);
		tvSigninTime = (TextView) findViewById(R.id.tv_today_signin);
	}

	/**
	 * 退出标记时间
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
     * 退出
     */  
    private void exitApp() {  
        Intent intent = new Intent();  
        intent.setAction("com.octopus.demo");  
        this.sendBroadcast(intent);  
    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_sign_in_now:
			SignInTimeDialogFragment signinFragment = new SignInTimeDialogFragment();
			signinFragment.setClickEvent(new DialogInterface() {
				
				@Override
				public void onDismiss() {
					
				}
				
				@Override
				public void onConfirm() {
					tvSigninTime.setText(signinFragment.);
				}
				
				@Override
				public void onCancel() {
					// TODO Auto-generated method stub
					
				}
			});
			signinFragment.show(this.getFragmentManager().beginTransaction(), "Sign in");
			break;
		case R.id.btn_sign_in_save:
			
			break;
		case R.id.btn_sign_in_type:
			
			break;
		default:
			break;
		}
	}  
}
