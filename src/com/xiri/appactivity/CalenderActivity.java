package com.xiri.appactivity;

import com.xiri.activity.BaseActivity;


import com.xiri.application.LocalApplication;
import com.example.iphonereborn.R;
import com.xiri.nextactivity.CalendarRiliActivity;
import com.xiri.util.DisplayUtil;

import android.annotation.SuppressLint;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

public class CalenderActivity extends BaseActivity implements OnTouchListener {

	private ImageView iv_add;
	private ImageView iv_search;
	private TextView tv_today;
	private TextView tv_recevie;
	private TextView tv_rili;

	
	@Override
	protected void initView() {
	ImageView	iv_content1 = (ImageView) findViewById(R.id.calendar_content1);
	ImageView	iv_content2 = (ImageView) findViewById(R.id.calendar_content2);
	ImageView	iv_content3 = (ImageView) findViewById(R.id.calendar_content3);

	iv_content1.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(),R.drawable.calendar_content1));
	iv_content2.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(),R.drawable.calendar_content2));
	iv_content3.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(),R.drawable.calendar_content3));

		iv_add = (ImageView) findViewById(R.id.calendar_add);
		iv_search = (ImageView) findViewById(R.id.calendar_search);
		tv_today = (TextView) findViewById(R.id.calendar_today);
		tv_recevie = (TextView) findViewById(R.id.calendar_recieve);
		tv_rili = (TextView) findViewById(R.id.calendar_rili);

		iv_add.setOnTouchListener(this);
		iv_search.setOnTouchListener(this);
		tv_today.setOnTouchListener(this);
		tv_recevie.setOnTouchListener(this);
		tv_rili.setOnTouchListener(this);

	}

	
	@Override
	protected void initParams() {
		// TODO Auto-generated method stub

	}

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_calender;
	}

	/* 定义点击黯淡效果 */

	@SuppressLint("ClickableViewAccessibility") @Override
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
			case R.id.calendar_add:
				showShortToast(R.string.calendar_add_toast);
				break;
			case R.id.calendar_search:
				showShortToast(R.string.calendar_search_toast);
				break;
			case R.id.calendar_today:
				showShortToast(R.string.calendar_toady_toast);
				break;
			case R.id.calendar_recieve:
				showShortToast(R.string.calendar_recevie_toast);
				break;
			case R.id.calendar_rili:
				startToOtherActivity(CalendarRiliActivity.class);
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
@Override
protected synchronized void onDestroy() {
	// TODO Auto-generated method stub
	super.onDestroy();
	System.gc();
}
	@Override
	protected void showFisrtDialog() {
		// TODO Auto-generated method stub
		boolean isFirst=LocalApplication.getInstance().sharereferences.getBoolean("calender", false);
		if(isFirst){	showAlertDialog(showString(R.string.app_calendar),
				showString(R.string.calender_dialog),
				new String[] {showString(R.string.no_dialog), showString(R.string.yes_dialog)}, true, true, null);}
	     LocalApplication.getInstance().sharereferences.edit().putBoolean("calender", false).commit();

	}

}
