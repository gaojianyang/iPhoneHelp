package com.xiri.appactivity;


import com.xiri.activity.BaseActivity;
import com.xiri.application.LocalApplication;
import com.example.iphonereborn.R;
import com.xiri.nextactivity.NoteNew;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class NoteActivity extends BaseActivity {

	private TextView tv_new;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_note;
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		tv_new = (TextView) findViewById(R.id.noto_new);
		tv_new.setOnTouchListener(new OnTouchListener() {

			@SuppressLint("ClickableViewAccessibility") @Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN: {
					tv_new.setAlpha(0.5f);
					break;
				}
				case MotionEvent.ACTION_UP:
					tv_new.setAlpha(1.0f);
					switch (v.getId()) {
					case R.id.noto_new:
						startToOtherActivity(NoteNew.class);
						break;

					default:
						break;
					}

					break;

				case MotionEvent.ACTION_CANCEL: {
					// clear the overlay
					v.setAlpha(1.0f);
					break;
				}
				}

				return true;
			}
		});
	}

	@Override
	protected void initParams() {
		// TODO Auto-generated method stub

	}
	@Override
	protected void showFisrtDialog() {
		// TODO Auto-generated method stub
		boolean isFirst=LocalApplication.getInstance().sharereferences.getBoolean("note", false);
	      if(isFirst){	showAlertDialog(showString(R.string.app_notes),
			showString(R.string.note_dialog),
			new String[] {showString(R.string.no_dialog), showString(R.string.yes_dialog)}, true, true, null);}
		     LocalApplication.getInstance().sharereferences.edit().putBoolean("note", false).commit();

	}
}
