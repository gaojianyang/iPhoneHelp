package com.xiri.appactivity;

import android.graphics.Color;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiri.activity.BaseActivity;
import com.example.iphonereborn.R;
  import com.xiri.util.DisplayUtil;

public class ShortCutActivity extends BaseActivity implements OnClickListener{
private TextView tv_phone;
private TextView tv_wear;
private ImageView iv_bottom;
private ImageView iv_head;

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activtiy_shortcut;
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		tv_phone=(TextView) findViewById(R.id.shortcut_phone);
		tv_wear=(TextView) findViewById(R.id.shortcut_wear);
		iv_bottom=(ImageView) findViewById(R.id.shortcut_bottom);
		iv_head=(ImageView) findViewById(R.id.shortcut_head);

		tv_phone.setOnClickListener(this);
		tv_wear.setOnClickListener(this);

		tv_phone.setBackgroundColor(Color.parseColor("#c5bed3"));
		tv_phone.setTextColor(Color.parseColor("#ffffff"));
		iv_bottom.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(), R.drawable.phonebottom));
	}

	@Override
	protected void initParams() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void showFisrtDialog() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.shortcut_phone:
			tv_phone.setBackgroundColor(Color.parseColor("#c5bed3"));
			tv_phone.setTextColor(Color.parseColor("#ffffff"));
			tv_wear.setBackgroundColor(Color.parseColor("#ffffff"));
			tv_wear.setTextColor(Color.parseColor("#c5bed3"));
			iv_bottom.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(), R.drawable.phonebottom));
iv_head.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(), R.drawable.phonehead));

			break;
		case R.id.shortcut_wear:
			tv_wear.setBackgroundColor(Color.parseColor("#c5bed3"));
			tv_wear.setTextColor(Color.parseColor("#ffffff"));
			tv_phone.setBackgroundColor(Color.parseColor("#ffffff"));
			tv_phone.setTextColor(Color.parseColor("#c5bed3"));
			iv_bottom.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(), R.drawable.wearbottom));
			iv_head.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(), R.drawable.wearhead));

			break;
		default:
			break;
		}
	}

}
