package com.xiri.nextactivity;

import android.annotation.SuppressLint;



import android.app.Dialog;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

import com.xiri.activity.BaseActivity;
import com.example.iphonereborn.R;
import com.xiri.util.DisplayUtil;

public class AppStoreNextActivity extends BaseActivity implements
		OnTouchListener {
	private ImageView iv_set;
	private ImageView iv_bottom1;
	private ImageView iv_bottom2;
	private ImageView iv_bottom3;

	private int clicktime = 0;

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_appstorenext;
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		iv_set = (ImageView) findViewById(R.id.app_next_get);
		iv_bottom1 = (ImageView) findViewById(R.id.app_next_bottom1);
		iv_bottom2 = (ImageView) findViewById(R.id.app_next_bottom2);
		iv_bottom3 = (ImageView) findViewById(R.id.app_next_bottom3);
		iv_set.setOnTouchListener(this);
		iv_bottom1.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(), R.drawable.app_nextbottom1));
		iv_bottom2.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(), R.drawable.app_nextbottom2));
		iv_bottom3.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(), R.drawable.app_nextbottom3));
		iv_bottom1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showShortToast(R.string.appstore_bottom_toast);
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
			case R.id.app_next_get:
				if (clicktime == 0) {

					iv_set.setImageResource(R.drawable.app_launch);
					showLongToast(R.string.appstore_get_toast);
					clicktime = 1;

				} else if(clicktime==1) {
					showAlertDialog(showString(R.string.login_title_dialog),
							showString(R.string.login_content_dialog),
							new String[] {showString(R.string.no_dialog), showString(R.string.yes_dialog)}, true, true, null);
clicktime=2;
				}else{
				showLongToast(R.string.appstore_open_toast);	
					
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
	public void onButtonClicked(Dialog dialog, int position, Object tag) {
		// TODO Auto-generated method stub
		super.onButtonClicked(dialog, position, tag);
		showShortToast(R.string.appstore_lanuch_toast);
		iv_set.setImageResource(R.drawable.app_open);

	}
	@Override
	protected void showFisrtDialog() {
		// TODO Auto-generated method stub
	
	}

}
