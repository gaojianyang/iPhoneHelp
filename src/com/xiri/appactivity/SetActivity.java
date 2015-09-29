package com.xiri.appactivity;

import android.annotation.SuppressLint;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.xiri.activity.BaseActivity;
import com.xiri.application.LocalApplication;
import com.example.iphonereborn.R;
import com.xiri.nextactivity.SetGeneralActivity;
import com.xiri.nextactivity.SetInformActivity;
import com.xiri.nextactivity.SetNextActivity;
import com.xiri.util.DisplayUtil;

public class SetActivity extends BaseActivity implements OnClickListener ,OnTouchListener{
	private LinearLayout ll_blue;
	private LinearLayout ll_hotspot;
	private LinearLayout ll_wifi;
	private LinearLayout ll_moblie;
	private LinearLayout ll_sever;
	private LinearLayout ll_control;
	private LinearLayout ll_disturb;
	private LinearLayout ll_inform;
	private LinearLayout ll_display;
	private LinearLayout ll_general;
	private LinearLayout ll_privacy;
	private LinearLayout ll_sounds;
	private LinearLayout ll_touchid;
	private LinearLayout ll_wallpaper;
	private LinearLayout ll_icloud;
	private LinearLayout ll_app;
private ImageView iv_part1;
private ImageView iv_part2;

private ImageView iv_part3;

private ImageView iv_part4;

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_set;
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		ll_blue = (LinearLayout) findViewById(R.id.set_one_blue);
		ll_hotspot = (LinearLayout) findViewById(R.id.set_one_hotspot);
		ll_wifi = (LinearLayout) findViewById(R.id.set_one_wifi);
		ll_moblie = (LinearLayout) findViewById(R.id.set_one_moblie);
		ll_sever = (LinearLayout) findViewById(R.id.set_one_sever);
		ll_control = (LinearLayout) findViewById(R.id.set_two_control);
		ll_disturb = (LinearLayout) findViewById(R.id.set_two_disturb);
		ll_inform = (LinearLayout) findViewById(R.id.set_two_inform);
		ll_display = (LinearLayout) findViewById(R.id.set_third_display);
		ll_general = (LinearLayout) findViewById(R.id.set_third_general);
		ll_privacy = (LinearLayout) findViewById(R.id.set_third_privacy);
		ll_sounds = (LinearLayout) findViewById(R.id.set_third_sounds);
		ll_touchid = (LinearLayout) findViewById(R.id.set_third_touchid);
		ll_wallpaper = (LinearLayout) findViewById(R.id.set_third_wallpaper);
		ll_icloud = (LinearLayout) findViewById(R.id.set_four_icloud);
		ll_app = (LinearLayout) findViewById(R.id.set_four_app);
iv_part1=(ImageView) findViewById(R.id.set_imgpart1);
iv_part2=(ImageView) findViewById(R.id.set_imgpart2);
iv_part3=(ImageView) findViewById(R.id.set_imgpart3);
iv_part4=(ImageView) findViewById(R.id.set_imgpart4);
iv_part1.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(),R.drawable.set_imgpart1));
iv_part2.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(),R.drawable.set_imgpart2));
iv_part3.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(),R.drawable.set_imgpart3));
iv_part4.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(),R.drawable.set_imgpart4));
		ll_blue.setOnClickListener(this);
		ll_hotspot.setOnClickListener(this);
		ll_wifi.setOnClickListener(this);
		ll_moblie.setOnClickListener(this);
		ll_sever.setOnClickListener(this);
		ll_control.setOnClickListener(this);
		ll_disturb.setOnClickListener(this);
		ll_inform.setOnClickListener(this);
		ll_display.setOnClickListener(this);
		ll_general.setOnClickListener(this);
		ll_privacy.setOnClickListener(this);
		ll_sounds.setOnClickListener(this);
		ll_touchid.setOnClickListener(this);
		ll_wallpaper.setOnClickListener(this);
		ll_icloud.setOnClickListener(this);
		ll_app.setOnClickListener(this);
		iv_part1.setOnTouchListener(this);
		iv_part2.setOnTouchListener(this);
		iv_part3.setOnTouchListener(this);
		iv_part4.setOnTouchListener(this);

		

	}

	@Override
	protected void initParams() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.set_one_wifi:
startToOtherActivityWithInt(SetNextActivity.class, 0);

			break;
		case R.id.set_one_blue:
startToOtherActivityWithInt(SetNextActivity.class, 1);
			break;
		case R.id.set_one_moblie:
			startToOtherActivityWithInt(SetNextActivity.class, 2);
			break;
		case R.id.set_one_hotspot:
			startToOtherActivityWithInt(SetNextActivity.class, 3);
			break;
		case R.id.set_one_sever:
			startToOtherActivityWithInt(SetNextActivity.class, 4);
			break;
		case R.id.set_two_inform:
			startToOtherActivity(SetInformActivity.class);
			break;
		case R.id.set_two_control:
			startToOtherActivityWithInt(SetNextActivity.class, 6);
			break;
		case R.id.set_two_disturb:
			startToOtherActivityWithInt(SetNextActivity.class, 7);
			break;
		case R.id.set_third_display:
			startToOtherActivityWithInt(SetNextActivity.class, 8);
			break;
		case R.id.set_third_general:
			startToOtherActivity(SetGeneralActivity.class);
			break;
		case R.id.set_third_privacy:
showShortToast(R.string.set_privacy_toast);			break;
		case R.id.set_third_sounds:
			startToOtherActivityWithInt(SetNextActivity.class, 11);
			break;
		case R.id.set_third_touchid:
			startToOtherActivityWithInt(SetNextActivity.class, 12);
			break;
		case R.id.set_third_wallpaper:
			startToOtherActivityWithInt(SetNextActivity.class, 13);
			break;
		case R.id.set_four_icloud:
		showLongToast(R.string.set_icloud_toast);
			break;
		case R.id.set_four_app:
			startToOtherActivityWithInt(SetNextActivity.class, 15);
			break;
		
		default:
			break;
		}

	}

	@SuppressLint("ClickableViewAccessibility") @Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN: {
			switch (v.getId()) {
			case R.id.set_imgpart1:
				v.setAlpha(0.7f);
				break;
		case R.id.set_imgpart2:
			v.setAlpha(0.7f);

				break;
		case R.id.set_imgpart3:
			v.setAlpha(0.7f);

			break;
		case R.id.set_imgpart4:
			v.setAlpha(0.7f);

			break;
	
			default:
				break;
			}
			break;
		}
		case MotionEvent.ACTION_UP:
			v.setAlpha(1.0f);
			switch (v.getId()) {
			case R.id.set_imgpart1:
				showShortToast(R.string.set_imgpart1_toast);
				break;
		case R.id.set_imgpart2:
			showShortToast(R.string.set_imgpart2_toast);

				break;
		case R.id.set_imgpart3:
			showShortToast(R.string.set_imgpart3_toast);
			break;
		case R.id.set_imgpart4:
			showShortToast(R.string.set_imgpart4_toast);
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
		boolean isFirst=LocalApplication.getInstance().sharereferences.getBoolean("set", false);
	      if(isFirst){	showAlertDialog(showString(R.string.app_settings),
			showString(R.string.set_dialog),
			new String[] {showString(R.string.no_dialog), showString(R.string.yes_dialog)}, true, true, null);}
		     LocalApplication.getInstance().sharereferences.edit().putBoolean("set", false).commit();

	}
}
