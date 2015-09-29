package com.xiri.appactivity;

import com.xiri.activity.BaseActivity;

import com.xiri.application.LocalApplication;
import com.example.iphonereborn.R;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

public class TimeActivity extends BaseActivity implements OnClickListener,
		OnTouchListener {
	private ImageView iv_alarm;
	private ImageView iv_clock;
	private ImageView iv_stopwatch;
	private ImageView iv_timer;
	private ImageView iv_center;
	private ImageView iv_add;
	private TextView tv_alarm;
	private TextView tv_clock;
	private TextView tv_stopwatch;
	private TextView tv_timer;
	private TextView tv_title;
	private TextView tv_edit;
	private int nowPage = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	protected void initView() {
		iv_alarm = (ImageView) findViewById(R.id.iv_time_bottom_alarm);
		iv_add = (ImageView) findViewById(R.id.time_add);
		iv_clock = (ImageView) findViewById(R.id.iv_time_bottom_clock);
		iv_stopwatch = (ImageView) findViewById(R.id.iv_time_bottom_stopwatch);
		iv_timer = (ImageView) findViewById(R.id.iv_time_bottom_timer);
		iv_center = (ImageView) findViewById(R.id.time_centerview);
		tv_alarm = (TextView) findViewById(R.id.tv_time_bottom_alarm);
		tv_clock = (TextView) findViewById(R.id.tv_time_bottom_clock);
		tv_stopwatch = (TextView) findViewById(R.id.tv_time_bottom_stopwatch);
		tv_timer = (TextView) findViewById(R.id.tv_time_bottom_timer);
		tv_title = (TextView) findViewById(R.id.time_title);
		tv_edit = (TextView) findViewById(R.id.time_edit_tv);

		iv_alarm.setOnClickListener(this);
		iv_clock.setOnClickListener(this);
		iv_stopwatch.setOnClickListener(this);
		iv_timer.setOnClickListener(this);
tv_edit.setOnTouchListener(this);
iv_add.setOnTouchListener(this);
	}

  

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.iv_time_bottom_alarm:
			tv_title.setText("闹钟");
			iv_alarm.setImageResource(R.drawable.alarm_pressed);
			iv_clock.setImageResource(R.drawable.world_colck_unpressed);
			iv_stopwatch.setImageResource(R.drawable.stopwatch_unpressd);
			iv_timer.setImageResource(R.drawable.timer_unpressd);
			iv_center.setImageResource(R.drawable.time2);
			tv_alarm.setTextColor(getResources().getColor(
					R.color.selected_calendar_text));
			tv_stopwatch.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_clock.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_timer.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			iv_add.setVisibility(View.VISIBLE);
			tv_edit.setVisibility(View.VISIBLE);
			nowPage = 1;
			break;
		case R.id.iv_time_bottom_clock:

			nowPage = 0;
			tv_title.setText("世界时钟");

			iv_alarm.setImageResource(R.drawable.alarm_unpressd);
			iv_clock.setImageResource(R.drawable.world_clock_pressed);
			iv_stopwatch.setImageResource(R.drawable.stopwatch_unpressd);
			iv_timer.setImageResource(R.drawable.timer_unpressd);
			iv_center.setImageResource(R.drawable.time1);
			tv_alarm.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_stopwatch.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_clock.setTextColor(getResources().getColor(
					R.color.selected_calendar_text));
			tv_timer.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			iv_add.setVisibility(View.VISIBLE);
			tv_edit.setVisibility(View.VISIBLE);

			break;
		case R.id.iv_time_bottom_stopwatch:
			tv_title.setText("秒表");
			iv_alarm.setImageResource(R.drawable.alarm_unpressd);
			iv_clock.setImageResource(R.drawable.world_colck_unpressed);
			iv_stopwatch.setImageResource(R.drawable.stopwatch_pressed);
			iv_timer.setImageResource(R.drawable.timer_unpressd);
			iv_center.setImageResource(R.drawable.time3);
			tv_alarm.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_stopwatch.setTextColor(getResources().getColor(
					R.color.selected_calendar_text));
			tv_clock.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_timer.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			iv_add.setVisibility(View.INVISIBLE);
			tv_edit.setVisibility(View.INVISIBLE);

			break;
		case R.id.iv_time_bottom_timer:
			tv_title.setText("计时器");
			iv_alarm.setImageResource(R.drawable.alarm_unpressd);
			iv_clock.setImageResource(R.drawable.world_colck_unpressed);
			iv_stopwatch.setImageResource(R.drawable.stopwatch_unpressd);
			iv_timer.setImageResource(R.drawable.timer_pressd);
			iv_center.setImageResource(R.drawable.time4);
			tv_alarm.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_stopwatch.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_clock.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_timer.setTextColor(getResources().getColor(
					R.color.selected_calendar_text));
			iv_add.setVisibility(View.INVISIBLE);
			tv_edit.setVisibility(View.INVISIBLE);
			break;

		default:
			break;
		}
	}

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_time;
	}

	@Override
	protected void initParams() {
		// TODO Auto-generated method stub

	}

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
			case R.id.time_add:
				if (nowPage == 0) {
					showShortToast(R.string.time_add0_toast);
				} else {
					showShortToast(R.string.time_add1_toast);
				}

				break;
			case R.id.time_edit_tv:
				if (nowPage == 0) {
					showShortToast(R.string.time_edit0_toast);
				} else {
					showShortToast(R.string.time_edit1_toast);
				}
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
	@Override
	protected void showFisrtDialog() {
		// TODO Auto-generated method stub
		boolean isFirst=LocalApplication.getInstance().sharereferences.getBoolean("time", false);
	      if(isFirst){	showAlertDialog(showString(R.string.app_clock),
			showString(R.string.time_dialog),
			new String[] {showString(R.string.no_dialog), showString(R.string.yes_dialog)}, true, true, null);}
		     LocalApplication.getInstance().sharereferences.edit().putBoolean("time", false).commit();

	}
}
