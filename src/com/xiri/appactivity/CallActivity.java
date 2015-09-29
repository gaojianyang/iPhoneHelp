package com.xiri.appactivity;

import android.graphics.Color;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xiri.activity.BaseActivity;
import com.example.iphonereborn.R;
import com.xiri.util.DisplayUtil;

public class CallActivity extends BaseActivity implements OnClickListener{
	private ImageView iv_favorite;
	private ImageView iv_recent;
	private ImageView iv_contact;
	private ImageView iv_keyboard;
	private ImageView iv_content;

	private TextView tv_favorite;
	private TextView tv_recent;
	private TextView tv_contact;
	private TextView tv_keyboard;
	private LinearLayout ll_bottom;
	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_call;
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		ll_bottom = (LinearLayout) findViewById(R.id.phone_bottom);

		iv_content = (ImageView) findViewById(R.id.phone_content);

		iv_favorite = (ImageView) findViewById(R.id.phone_collect_iv);
		iv_recent = (ImageView) findViewById(R.id.phone_recent_iv);
		iv_contact = (ImageView) findViewById(R.id.phone_contact_iv);
		iv_keyboard = (ImageView) findViewById(R.id.phone_call_iv);
		tv_favorite = (TextView) findViewById(R.id.phone_collect_tv);
		tv_recent = (TextView) findViewById(R.id.phone_recent_tv);
		tv_contact = (TextView) findViewById(R.id.phone_contact_tv);
		tv_keyboard = (TextView) findViewById(R.id.phone_call_tv);
iv_content.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(), R.drawable.phone1));
		iv_favorite.setOnClickListener(this);
		iv_recent.setOnClickListener(this);
		iv_contact.setOnClickListener(this);
		iv_keyboard.setOnClickListener(this);
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
		case R.id.phone_collect_iv:
			ll_bottom.setBackgroundColor(Color.parseColor("#ccffffff"));
			iv_content.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(), R.drawable.phone1));
			iv_favorite.setImageResource(R.drawable.featured_pressed);
			iv_recent.setImageResource(R.drawable.recents_unpressed);
			iv_contact.setImageResource(R.drawable.contacts_unpressd);
			iv_keyboard.setImageResource(R.drawable.keypad_unpressed);
			tv_favorite.setTextColor(getResources().getColor(
					R.color.selected_photo_text));
			tv_recent.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_contact.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_keyboard.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			
			showLongToast(R.string.phone_collect_toast);
			break;
		case R.id.phone_recent_iv:
			ll_bottom.setBackgroundColor(Color.parseColor("#ccffffff"));

			iv_content.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(), R.drawable.phone2));

			iv_favorite.setImageResource(R.drawable.featured_unpressed);
			iv_recent.setImageResource(R.drawable.recents_pressed);
			iv_contact.setImageResource(R.drawable.contacts_unpressd);
			iv_keyboard.setImageResource(R.drawable.keypad_unpressed);			
			tv_favorite.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_recent.setTextColor(getResources().getColor(
					R.color.selected_photo_text));
			tv_contact.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_keyboard.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			
			showLongToast(R.string.phone_recent_toast);

			break;
		case R.id.phone_contact_iv:
			ll_bottom.setBackgroundColor(Color.parseColor("#ccffffff"));

			iv_content.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(), R.drawable.phone3));

			iv_favorite.setImageResource(R.drawable.featured_unpressed);
			iv_recent.setImageResource(R.drawable.recents_unpressed);
			iv_contact.setImageResource(R.drawable.contacts_phone);
			iv_keyboard.setImageResource(R.drawable.keypad_unpressed);
			tv_favorite.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_recent.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_contact.setTextColor(getResources().getColor(
					R.color.selected_photo_text));
			tv_keyboard.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			
			showLongToast(R.string.phone_contact_toast);

			break;
		case R.id.phone_call_iv:
			ll_bottom.setBackgroundColor(Color.parseColor("#efebef"));

			iv_content.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(), R.drawable.phone4));

			iv_favorite.setImageResource(R.drawable.featured_unpressed);
			iv_recent.setImageResource(R.drawable.recents_unpressed);
			iv_contact.setImageResource(R.drawable.contacts_unpressd);
			iv_keyboard.setImageResource(R.drawable.keypad_pressed);
			tv_favorite.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_recent.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_contact.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_keyboard.setTextColor(getResources().getColor(
					R.color.selected_photo_text));
			
			showLongToast(R.string.phone_call_toast);

			break;
	
	
		default:
			break;
		}
	}

}
