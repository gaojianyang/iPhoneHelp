package com.xiri.nextactivity;

import com.xiri.activity.BaseActivity;

import com.example.iphonereborn.R;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class CalendarRiliActivity extends BaseActivity implements
		OnTouchListener {
	private TextView tv_edit;
	private TextView tv_end;

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		tv_edit = (TextView) findViewById(R.id.calendarnext_edit);
		tv_end = (TextView) findViewById(R.id.calendarnext_end);
		tv_edit.setOnTouchListener(this);
		tv_end.setOnTouchListener(this);

	}

	@Override
	protected void initParams() {
		// TODO Auto-generated method stub

	}

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_calendar_rili;
	}

	@Override
	protected void showFisrtDialog() {
		// TODO Auto-generated method stub

	}

	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN: {
			v.setAlpha(0.5f);
			break;
		}
		case MotionEvent.ACTION_UP:
			v.setAlpha(1.0f);
			switch (v.getId()) {
			case R.id.calendarnext_edit:
				showShortToast(R.string.calendarnext_edit_toast);
				break;
			case R.id.calendarnext_end:
				finish();
				break;

			default:
				break;
			}

			break;

		case MotionEvent.ACTION_CANCEL: {
			v.setAlpha(1.0f);
			break;
		}
		}

		return true;
	}
}
