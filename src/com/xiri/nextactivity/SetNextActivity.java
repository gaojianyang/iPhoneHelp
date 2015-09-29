package com.xiri.nextactivity;

import android.annotation.SuppressLint;


import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiri.activity.BaseActivity;
import com.example.iphonereborn.R;
import com.xiri.util.DisplayUtil;


public class SetNextActivity extends BaseActivity implements OnTouchListener {
	private ImageView iv_back;
	private ImageView iv_content;
	private ImageView iv_content2;

	private TextView tv_title;

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_set_next;
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		iv_back = (ImageView) findViewById(R.id.set_next_back);
		tv_title = (TextView) findViewById(R.id.set_next_title);
		iv_content = (ImageView) findViewById(R.id.set_next_content);
		iv_content2 = (ImageView) findViewById(R.id.set_next_content2);

        iv_back.setOnTouchListener(this);
        Intent intent=getIntent();
        int position=intent.getIntExtra("position", 0);
        switch (position) {
		case 0:
			iv_content.setImageBitmap( DisplayUtil.readBitMap(getApplicationContext(), R.drawable.set_img_wifi));
			tv_title.setText("无线局域网");
			break;
		case 1:
			iv_content.setImageBitmap( DisplayUtil.readBitMap(getApplicationContext(), R.drawable.set_img_blue));

			tv_title.setText("蓝牙");
			break;
		case 2:
			iv_content.setImageBitmap( DisplayUtil.readBitMap(getApplicationContext(), R.drawable.set_img_moblie1));
			iv_content2.setImageBitmap( DisplayUtil.readBitMap(getApplicationContext(), R.drawable.set_img_moblie2));

			tv_title.setText("蜂窝移动网络");
			break;	
			case 3:
				iv_content.setImageBitmap( DisplayUtil.readBitMap(getApplicationContext(), R.drawable.set_img_hotspot));
				tv_title.setText("个人热点");
				break;
			case 4:
				iv_content.setImageBitmap( DisplayUtil.readBitMap(getApplicationContext(), R.drawable.set_img_sever));

				tv_title.setText("网络选择");
				break;
			case 5:
				iv_content.setImageBitmap( DisplayUtil.readBitMap(getApplicationContext(), R.drawable.set_infofrmnext));
				tv_title.setText("微信");
				break;
			case 6:
				iv_content.setImageBitmap( DisplayUtil.readBitMap(getApplicationContext(), R.drawable.set_img_control));
				tv_title.setText("控制中心");
				break;
			case 7:
				iv_content.setImageBitmap( DisplayUtil.readBitMap(getApplicationContext(), R.drawable.set_img_disturb));
				tv_title.setText("勿扰模式");
				break;
			case 8:
				iv_content.setImageBitmap( DisplayUtil.readBitMap(getApplicationContext(), R.drawable.set_img_displaypng));
				tv_title.setText("无线局域网");
				break;
			case 9:
				
				break;
			case 10:
				
				break;
			case 11:
				iv_content.setImageBitmap( DisplayUtil.readBitMap(getApplicationContext(), R.drawable.set_img_sounds));
				tv_title.setText("声音");
				break;
			case 12:
				iv_content.setImageBitmap( DisplayUtil.readBitMap(getApplicationContext(), R.drawable.set_img_touchid));
				tv_title.setText("Touch ID 与密码");
				break;
			case 13:
				iv_content.setImageBitmap( DisplayUtil.readBitMap(getApplicationContext(), R.drawable.set_img_wallpaperpng));
				tv_title.setText("墙纸");
				break;
			case 14:
				
				break;
			case 15:
				iv_content.setImageBitmap( DisplayUtil.readBitMap(getApplicationContext(), R.drawable.set_img_app));
				tv_title.setText("iTunes Store");
				break;
			
		

		default:
			break;
		}
        iv_content.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showShortToast(R.string.image_cant_toast);
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
				iv_content2.setImageDrawable(null);
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
