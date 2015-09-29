package com.xiri.nextactivity;

import android.annotation.SuppressLint;


import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

import com.xiri.activity.BaseActivity;
import com.example.iphonereborn.R;


public class NoteNew extends BaseActivity implements OnTouchListener {

	private ImageView iv_back;
	private ImageView iv_done;

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_note_new;
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		iv_back = (ImageView) findViewById(R.id.notenew_back);
		iv_done = (ImageView) findViewById(R.id.notenew_done);
		iv_back.setOnTouchListener(this);
		iv_done.setOnTouchListener(this);

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
			case R.id.notenew_back:
				finish();
				break;
			case R.id.notenew_done:
				finish();
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
		
	}

}
