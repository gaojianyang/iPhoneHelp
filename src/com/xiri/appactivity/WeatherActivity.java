package com.xiri.appactivity;

import java.util.ArrayList;

import java.util.List;


import com.xiri.activity.BaseActivity;
import com.xiri.application.LocalApplication;
import com.example.iphonereborn.R;
import com.xiri.util.DisplayUtil;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

public class WeatherActivity extends BaseActivity implements OnClickListener {
	private ViewPager mVp;
	private TextView tv_left;
	private TextView tv_right;
	private List<ImageView> list;
	private int[] imageId = new int[] { R.drawable.weather_img1,
			R.drawable.weather_img_2, R.drawable.weather_img_3 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub

		mVp = (ViewPager) findViewById(R.id.weather_vp);
		tv_left = (TextView) findViewById(R.id.weather_left);
		tv_right = (TextView) findViewById(R.id.weather_right);
		list = new ArrayList<ImageView>();
		for (int i = 0; i < imageId.length; i++) {
			ImageView mViewPagerImageView = new ImageView(
					getApplicationContext());
			ViewGroup.LayoutParams viewPagerImageViewParams = new ViewGroup.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT,
					ViewGroup.LayoutParams.MATCH_PARENT);
			mViewPagerImageView.setLayoutParams(viewPagerImageViewParams);
			mViewPagerImageView.setScaleType(ScaleType.FIT_XY);
			mViewPagerImageView.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(),imageId[i]));
			list.add(mViewPagerImageView);
		}
		mVp.setAdapter(new MyAdapter());
		tv_left.setOnClickListener(this);
		tv_right.setOnClickListener(this);
	}

	@Override
	protected void initParams() {
		// TODO Auto-generated method stub

	}

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub

		return R.layout.activity_weather;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.weather_left:
			showShortToast(R.string.weather_left_toast);
			break;
		case R.id.weather_right:
			showShortToast(R.string.weather_right_toast);

			break;

		default:
			break;
		}
	}

	public class MyAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(list.get(position));
		}

		/**
		 * 载入图片进去，用当前的position 除以 图片数组长度取余数是关键
		 */
		@Override
		public Object instantiateItem(ViewGroup container, int position) {

			container.addView(list.get(position));

			return list.get(position);
		}

		//

	}
	@Override
	protected void showFisrtDialog() {
		// TODO Auto-generated method stub
		boolean isFirst=LocalApplication.getInstance().sharereferences.getBoolean("weather", false);
	      if(isFirst){	showAlertDialog(showString(R.string.app_weather),
			showString(R.string.weather_dialog),
			new String[] {showString(R.string.no_dialog), showString(R.string.yes_dialog)}, true, true, null);}
		     LocalApplication.getInstance().sharereferences.edit().putBoolean("weather", false).commit();

	}
}
