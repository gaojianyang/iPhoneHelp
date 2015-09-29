package com.xiri.nextactivity;

import android.annotation.SuppressLint;


import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.xiri.activity.BaseActivity;
import com.example.iphonereborn.R;


public class SetGeneralActivity extends BaseActivity implements OnClickListener,OnTouchListener{
	private ImageView iv_back;
	private ImageView iv_bottom1;
	private ImageView iv_bottom2;
	private ImageView iv_bottom3;
	private ImageView iv_bottom4;
	private ImageView iv_bottom5;
	private LinearLayout ll_assist;
	private LinearLayout ll_self;
	private LinearLayout ll_siri;
	private LinearLayout ll_spotlight;
	private LinearLayout ll_update;

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_setgeneral;
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		iv_back=(ImageView) findViewById(R.id.set_general_back);
		iv_bottom1=(ImageView) findViewById(R.id.setgeneral_bottom1);
		iv_bottom2=(ImageView) findViewById(R.id.setgeneral_bottom2);
		iv_bottom3=(ImageView) findViewById(R.id.setgeneral_bottom3);
		iv_bottom4=(ImageView) findViewById(R.id.setgeneral_bottom4);
		iv_bottom5=(ImageView) findViewById(R.id.setgeneral_bottom5);

		ll_assist=(LinearLayout) findViewById(R.id.set_gen_assist);
		ll_self=(LinearLayout) findViewById(R.id.set_gen_self);
		ll_siri=(LinearLayout) findViewById(R.id.set_gen_siri);
		ll_spotlight=(LinearLayout) findViewById(R.id.set_gen_spotlight);
		ll_update=(LinearLayout) findViewById(R.id.set_gen_update);
		
		ll_assist.setOnClickListener(this);
		ll_self.setOnClickListener(this);
		ll_siri.setOnClickListener(this);
		ll_spotlight.setOnClickListener(this);
		ll_update.setOnClickListener(this);
		iv_bottom1.setOnTouchListener(this);
		iv_bottom2.setOnTouchListener(this);
		iv_bottom3.setOnTouchListener(this);
		iv_bottom4.setOnTouchListener(this);
		iv_bottom5.setOnTouchListener(this);
		iv_back.setOnTouchListener(this);
	}

	@Override
	protected void initParams() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
	
	case R.id.set_gen_assist:
		showLongToast(R.string.setgeneral_assist_toast);
		break;
	case R.id.set_gen_self:
		showShortToast(R.string.setgeneral_self_toast);

		break;
	case R.id.set_gen_siri:
		showLongToast(R.string.setgeneral_siri_toast);

		break;
	case R.id.set_gen_update:
		showShortToast(R.string.setgeneral_update_toast);

		break;
	case R.id.set_gen_spotlight:
		showShortToast(R.string.setgeneral_spotlight_toast);

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
			case R.id.setgeneral_bottom1:
				v.setAlpha(0.7f);
				break;
		case R.id.setgeneral_bottom2:
			v.setAlpha(0.7f);

				break;
		case R.id.setgeneral_bottom3:
			v.setAlpha(0.7f);

			break;
		case R.id.setgeneral_bottom4:
			v.setAlpha(0.7f);

			break;
		case R.id.setgeneral_bottom5:
			v.setAlpha(0.7f);

			break;
			case R.id.set_general_back:
				v.setAlpha(0.5f);
				break;
			default:
				break;
			}
			break;
		}
		case MotionEvent.ACTION_UP:
			v.setAlpha(1.0f);
			switch (v.getId()) {
			case R.id.setgeneral_bottom1:
				showShortToast(R.string.setgeneral_bo1_toast);
				break;
		case R.id.setgeneral_bottom2:
			showShortToast(R.string.setgeneral_bo2_toast);

				break;
		case R.id.setgeneral_bottom3:
			showShortToast(R.string.setgeneral_bo3_toast);

			break;
		case R.id.setgeneral_bottom4:
			showShortToast(R.string.setgeneral_bo4_toast);

			break;
		case R.id.setgeneral_bottom5:
			showShortToast(R.string.setgeneral_bo5_toast);

			break;
			case R.id.set_general_back:
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

	@Override
	protected void showFisrtDialog() {
		// TODO Auto-generated method stub
		
	}

}
