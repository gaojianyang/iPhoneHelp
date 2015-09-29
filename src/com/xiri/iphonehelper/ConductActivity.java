package com.xiri.iphonehelper;

import android.annotation.SuppressLint;

import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiri.activity.BaseActivity;
import com.example.iphonereborn.R;

import com.xiri.util.DisplayUtil;

public class ConductActivity extends BaseActivity {
	private LinearLayout ll_state;
	private TextView tv_help;
	private TextView tv_start;

	private ImageView iv_swipeup;
	private boolean isShow = false;
	/**
	 * 装ImageView数组
	 */
	private ImageView[] mImageViews;

	/**
	 * 图片资源id
	 */
	private static int[] imgIdArray = new int[] { R.drawable.help1,
			R.drawable.help2, R.drawable.help3, R.drawable.help4,
			R.drawable.help5, R.drawable.help6, R.drawable.help7,
			R.drawable.help8, R.drawable.help9, R.drawable.help10 ,R.drawable.lastpager};

	private ViewPager vp;

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_conduct;
	}

	@Override
	protected void initView() {

		// TODO Auto-generated method stub
		vp = (ViewPager) findViewById(R.id.conduct_vp);
		ll_state = (LinearLayout) findViewById(R.id.ll_state);
		iv_swipeup = (ImageView) findViewById(R.id.iv_swipeup);
		tv_help = (TextView) findViewById(R.id.tv_help);
		tv_start = (TextView) findViewById(R.id.start_content);

		final Animation amdismiss = AnimationUtils.loadAnimation(this,
				R.anim.push_top_out);
		final Animation amshow = AnimationUtils.loadAnimation(this,
				R.anim.push_top_in);
		final Animation amleftin = AnimationUtils.loadAnimation(this,
				R.anim.push_left_in);
		tv_start.setOnTouchListener(new OnTouchListener() {

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
					case R.id.start_content:
						startToOtherActivity(MainActivity.class);
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
		});
		iv_swipeup.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ll_state.startAnimation(amdismiss);
				ll_state.setVisibility(View.GONE);
				isShow = false;
			}
		});
		mImageViews = new ImageView[imgIdArray.length];
		for (int i = 0; i < mImageViews.length; i++) {
			ImageView imageView = new ImageView(this);
			mImageViews[i] = imageView;
			imageView.setLayoutParams(new LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			imageView.setScaleType(ScaleType.FIT_XY);
			// 防止出现内存溢出

			Bitmap bm = DisplayUtil.readBitMap(getApplicationContext(),
					imgIdArray[i]);
			imageView.setImageBitmap(bm);
		}

		vp.setAdapter(new MyAdapter());
		// 设置ViewPager自定义滑动效果
		vp.setPageTransformer(true, new DepthPageTransformer());
		vp.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				if (isShow == false&&arg0<10) {

					ll_state.setVisibility(View.VISIBLE);
					ll_state.startAnimation(amshow);
				} else {
				}

				switch (arg0) {
				case 0:
					tv_help.setText(R.string.help1_toast);
					break;
				case 1:
					tv_help.setText(R.string.help2_toast);
					break;
				case 2:
					tv_help.setText(R.string.help3_toast);
					break;
				case 3:
					tv_help.setText(R.string.help4_toast);
					break;
				case 4:
					tv_help.setText(R.string.help5_toast);
					break;
				case 5:
					tv_help.setText(R.string.help6_toast);
					break;
				case 6:
					tv_help.setText(R.string.help7_toast);
					break;
				case 7:
					tv_help.setText(R.string.help8_toast);
					break;
				case 8:
					tv_help.setText(R.string.help9_toast);
					break;
				case 9:
					tv_help.setText(R.string.help10_toast);
					break;
				case 10:
					ll_state.setVisibility(View.INVISIBLE);

tv_start.setVisibility(View.VISIBLE);
tv_start.setAnimation(amleftin);
					break;
				default:
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

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

	}

	public class MyAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return mImageViews.length;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(mImageViews[position]);
		}

		/**
		 * 载入图片进去，用当前的position 除以 图片数组长度取余数是关键
		 */
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(mImageViews[position]);

			return mImageViews[position];
		}

		//

	}

	private class DepthPageTransformer implements ViewPager.PageTransformer {
		private static final float MIN_SCALE = 0.75f;

		public void transformPage(View view, float position) {
			int pageWidth = view.getWidth();

			if (position < -1) { // [-Infinity,-1)
				// This page is way off-screen to the left.
				view.setAlpha(0);

			} else if (position <= 0) { // [-1,0]
				// Use the default slide transition when moving to the left page
				view.setAlpha(1);
				view.setTranslationX(0);
				view.setScaleX(1);
				view.setScaleY(1);

			} else if (position <= 1) { // (0,1]
				// Fade the page out.
				view.setAlpha(1 - position);

				// Counteract the default slide transition
				view.setTranslationX(pageWidth * -position);

				// Scale the page down (between MIN_SCALE and 1)
				float scaleFactor = MIN_SCALE + (1 - MIN_SCALE)
						* (1 - Math.abs(position));
				view.setScaleX(scaleFactor);
				view.setScaleY(scaleFactor);

			} else { // (1,+Infinity]
				// This page is way off-screen to the right.
				view.setAlpha(0);
			}
		}
	}

}
