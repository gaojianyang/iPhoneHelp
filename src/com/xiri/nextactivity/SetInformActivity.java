package com.xiri.nextactivity;

import android.annotation.SuppressLint;


import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiri.activity.BaseActivity;
import com.example.iphonereborn.R;


public class SetInformActivity extends BaseActivity implements OnTouchListener{
private ImageView iv_back;
private ImageView iv_handselected;
private ImageView iv_timeselected;
private LinearLayout ll_hand;
private LinearLayout ll_time;
private RelativeLayout re_weibo;
private RelativeLayout re_wechat;
private TextView tv_edit;
	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_setinform;
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
	iv_back=(ImageView) findViewById(R.id.set_next_back);
	tv_edit=(TextView) findViewById(R.id.setinform_edit);
	iv_handselected=(ImageView) findViewById(R.id.setinform_handselected);
	iv_timeselected=(ImageView) findViewById(R.id.setinform_timeselected);
	ll_hand=(LinearLayout) findViewById(R.id.setinform_hand);
	ll_time=(LinearLayout) findViewById(R.id.setinform_time);
	re_wechat=(RelativeLayout) findViewById(R.id.set_wechat_re);
	re_weibo=(RelativeLayout) findViewById(R.id.set_weibo_re);

	iv_back.setOnTouchListener(this);
	tv_edit.setOnTouchListener(this);
	iv_handselected.setVisibility(View.INVISIBLE);
ll_hand.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		iv_handselected.setVisibility(View.VISIBLE);
		iv_timeselected.setVisibility(View.INVISIBLE);
	}
});
ll_time.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		iv_handselected.setVisibility(View.INVISIBLE);
		iv_timeselected.setVisibility(View.VISIBLE);
	}
});
re_wechat.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	startToOtherActivityWithInt(SetNextActivity.class, 5);
	}
});
re_weibo.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		showShortToast(R.string.set_weibo_toast);
	}
});
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
			case R.id.set_next_back:
				finish();
				break;
			case R.id.setinform_edit:
				showShortToast(R.string.set_informedit_toast);
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
	protected void showFisrtDialog() {
		// TODO Auto-generated method stub
		
	}

}
