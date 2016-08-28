package com.hisign.demo.fragment;

import com.octopus.demo.R;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

/**
 * 选择时间对话框
 * @author octopus
 * @description 
 *
 */
public class SignInTimeDialogFragment extends BasicDialogFragment implements OnClickListener{
	
	TimePicker tpSignin;
	
	Button btnSave;
	
	Button btnCancel;
	/**
	 * 当前时
	 */
	private int currentHour;
	/**
	 * 当前分钟
	 */
	private int currentMinute;
	
	private String timeStr;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setCancelable(false);
		int style = DialogFragment.STYLE_NO_TITLE,theme = 0;
		setStyle(style, theme);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.dialog_fragment_time, container, true);
		initView(view);
		return view;
	}

	private void initView(View view) {
		tpSignin = (TimePicker) view.findViewById(R.id.timepicker_sign_in);
		btnSave = (Button) view.findViewById(R.id.btn_confirm);
		btnCancel = (Button) view.findViewById(R.id.btn_cancel);
		view.findViewById(R.id.iv_close).setOnClickListener(this);
		btnSave.setOnClickListener(this);
		btnCancel.setOnClickListener(this);
		tpSignin.setIs24HourView(true);
		tpSignin.setOnTimeChangedListener(new OnTimeChangedListener() {
			
			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				currentHour = hourOfDay;
				currentMinute = minute;
				timeStr = hourOfDay+":"+minute;
			}
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_confirm:
			if (clickEvent != null) {
				clickEvent.onConfirm();
			}
			break;
		case R.id.btn_cancel:
			if (clickEvent != null) {
				clickEvent.onCancel();
			}
			break;
		case R.id.iv_close:
			if (clickEvent != null) {
				clickEvent.onDismiss();
			}
			break;
		default:
			break;
		}
		dismiss();
	}

	
	/**
	 * 获取当前时间
	 * @return 形如--16:21
	 */
	public String getTimeStr() {
		return timeStr;
	}

	public void show(FragmentTransaction beginTransaction, String string) {

		this.show(getFragmentManager(), string);
	}

	
	
	
}
