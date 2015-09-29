package com.xiri.iphonehelper;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

import com.xiri.activity.BaseActivity;
import com.example.iphonereborn.R;

public class SignInActivity extends BaseActivity implements OnTouchListener{
private ImageView iv_new;
private ImageView iv_content;

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_signin;
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		iv_new=(ImageView) findViewById(R.id.sign_new);
		iv_content=(ImageView) findViewById(R.id.sign_content);
		iv_content.setOnTouchListener(this);
		iv_new.setOnTouchListener(this);

	}

	@Override
	protected void initParams() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void showFisrtDialog() {
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
			case R.id.sign_new:
				Intent intent=new Intent();
				intent.setClass(getApplicationContext(), ConductActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);  
	
				finish();
				break;
			case R.id.sign_content:
				
				Intent intent2=new Intent();
				intent2.setClass(getApplicationContext(), MainActivity.class);
				startActivity(intent2);
				overridePendingTransition(R.anim.fade, R.anim.hold);  

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
