package com.hisign.demo.fragment;

import com.hisign.demo.event.DialogInterface;

import android.support.v4.app.DialogFragment;

/**
 *
 * @author octopus
 * @description 
 *
 */
public class BasicDialogFragment extends DialogFragment {

	protected DialogInterface clickEvent;

	public DialogInterface getClickEvent() {
		return clickEvent;
	}

	public void setClickEvent(DialogInterface clickEvent) {
		this.clickEvent = clickEvent;
	}
	
	
	
}
