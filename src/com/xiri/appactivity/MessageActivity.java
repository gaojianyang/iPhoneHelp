package com.xiri.appactivity;

import java.util.ArrayList;




import java.util.List;

import com.xiri.activity.BaseActivity;
import com.xiri.adapter.MessageAdapter;
import com.xiri.application.LocalApplication;
import com.example.iphonereborn.R;
import com.xiri.model.MessageInfo;
import com.xiri.thrid.BaseSwipeListViewListener;
import com.xiri.thrid.SwipeListView;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MessageActivity extends BaseActivity {
	private List<MessageInfo> list = new ArrayList<MessageInfo>();
	private SwipeListView mSwipeListView;
	private TextView tv_left;
	private ImageView iv_right;
	public static int deviceWidth;
	BaseAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		deviceWidth = getDeviceWidth();
		
		MessageInfo m1 = new MessageInfo(10086, getResources().getString(R.string.message_time1), getResources().getString(R.string.message_content1));
		MessageInfo m2 = new MessageInfo(10086, getResources().getString(R.string.message_time1), getResources().getString(R.string.message_content2));
		MessageInfo m3 = new MessageInfo(10086, getResources().getString(R.string.message_time2), getResources().getString(R.string.message_content3));
		MessageInfo m4 = new MessageInfo(10086, getResources().getString(R.string.message_time2), getResources().getString(R.string.message_content4));
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		adapter = new MessageAdapter(getApplicationContext(), list);
		mSwipeListView.setAdapter(adapter);

		reload();
		mSwipeListView
				.setSwipeListViewListener(new BaseSwipeListViewListener() {

					@Override
					public void onClickFrontView(int position) {
						super.onClickFrontView(position);
						System.out.println("dianjile");
					}

					@Override
					public void onDismiss(int[] reverseSortedPositions) {
						// for (int position : reverseSortedPositions) {
						// }

					}

				});
	}

	private int getDeviceWidth() {
		return getResources().getDisplayMetrics().widthPixels;
	}

	private void reload() {
		mSwipeListView.setSwipeMode(SwipeListView.SWIPE_MODE_LEFT);
		mSwipeListView.setSwipeActionLeft(SwipeListView.SWIPE_ACTION_REVEAL);
		mSwipeListView.setOffsetLeft(deviceWidth*2/3);
		// mSwipeListView.setSwipeActionRight(settings.getSwipeActionRight());
		// mSwipeListView.setOffsetRight(convertDpToPixel(settings.getSwipeOffsetRight()));
		mSwipeListView.setAnimationTime(0);
		mSwipeListView.setSwipeOpenOnLongPress(false);
	}

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_message;
	}

	@SuppressLint("ClickableViewAccessibility") @Override
	protected void initView() {
		// TODO Auto-generated method stub
	
		mSwipeListView = (SwipeListView) findViewById(R.id.example_lv_list);
		tv_left = (TextView) findViewById(R.id.tv_navigation_left);
		iv_right = (ImageView) findViewById(R.id.iv_navigation_right);
	

		tv_left.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN: {
					v.setAlpha(0.5f);
					break;
				}
				case MotionEvent.ACTION_UP:
					v.setAlpha(1.0f);
					showShortToast(R.string.message_left_toast);
	

					break;

				case MotionEvent.ACTION_CANCEL: {
					v.setAlpha(1.0f);
					break;
				}
				}

				return true;
	
			}
		});
		iv_right.setOnTouchListener(new OnTouchListener() {

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
					showShortToast(R.string.message_right_toast);

					break;

				case MotionEvent.ACTION_CANCEL: {
					v.setAlpha(1.0f);
					break;
				}
				}

				return true;
	
			}
		});
	}

	@Override
	protected void initParams() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void showFisrtDialog() {
		// TODO Auto-generated method stub
		 boolean isFirst = LocalApplication.getInstance().sharereferences
		 .getBoolean("message", false);
		 if (isFirst) {
		 showAlertDialog(showString(R.string.app_messages),
		 showString(R.string.message_dialog), new String[] {
		 showString(R.string.no_dialog),
		 showString(R.string.yes_dialog) }, true, true, null);
		 }
		 LocalApplication.getInstance().sharereferences.edit()
		 .putBoolean("message", false).commit();
		
	}

}
