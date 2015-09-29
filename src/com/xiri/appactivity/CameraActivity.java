package com.xiri.appactivity;

import java.util.ArrayList;


import java.util.List;

import com.xiri.activity.BaseActivity;
import com.xiri.application.LocalApplication;
import com.example.iphonereborn.R;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CameraActivity extends BaseActivity implements OnTouchListener {
	private LinearLayout ll_flash;
	private ImageView iv_countdown;
	private ImageView iv_flip;
	private ImageView iv_photocase;
	private ImageView iv_takephoto;
	private ImageView iv_style;
	private ImageView iv_center;
	private TextView tv_hdr;
	private LinearLayout ll_bottom;
	private LinearLayout ll_top;
	private LinearLayout ll_all;
	private ViewPager vp_type;

	private List<TextView> tvlist;
	private String[] mStrarray = new String[] { "  ", "  ", "延时摄影", "慢动作",
			"视频", "照片", "正方形", "全景", "   ", "  " };
	MyAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	protected void initView() {
		ll_flash = (LinearLayout) findViewById(R.id.camera_flash);
		iv_countdown = (ImageView) findViewById(R.id.camera_countdown);
		iv_flip = (ImageView) findViewById(R.id.camera_flip);
		iv_takephoto = (ImageView) findViewById(R.id.camera_take_photo);
		iv_photocase = (ImageView) findViewById(R.id.camera_photo_case);
		iv_style = (ImageView) findViewById(R.id.camera_photo_style);
		iv_center = (ImageView) findViewById(R.id.camera_center);
		tv_hdr = (TextView) findViewById(R.id.camera_hdr);
		vp_type = (ViewPager) findViewById(R.id.camera_vp);
		ll_bottom = (LinearLayout) findViewById(R.id.camera_bottom_ll);
		ll_top = (LinearLayout) findViewById(R.id.camera_top_ll);
		ll_all = (LinearLayout) findViewById(R.id.camera_background);

		ll_flash.setOnTouchListener(this);
		iv_countdown.setOnTouchListener(this);
		iv_flip.setOnTouchListener(this);
		iv_photocase.setOnTouchListener(this);
		iv_takephoto.setOnTouchListener(this);
		iv_style.setOnTouchListener(this);
		iv_center.setOnTouchListener(this);
		tv_hdr.setOnTouchListener(this);

	}

	@Override
	protected void initParams() {
		// TODO Auto-generated method stub
		tvlist = new ArrayList<TextView>();
		for (int i = 0; i < mStrarray.length; i++) {
			TextView tv = new TextView(this);
			tv.setText(mStrarray[i]);
			tv.setTextSize(14);
			LayoutParams la = new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT);
			tv.setLayoutParams(la);
			tv.setGravity(Gravity.CENTER);
			tv.setTextColor(getResources().getColor(
					R.color.unselected_camera_text));
			tv.setPadding(8, 4, 8, 4);
			tvlist.add(tv);
		}

		vp_type.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub

				switch (arg0) {
				case 0:
					ll_top.setVisibility(View.VISIBLE);

					ll_all.setBackgroundResource(R.drawable.camera_photo);
					ll_bottom.setBackgroundColor(Color.parseColor("#22000000"));
					ll_top.setBackgroundColor(Color.parseColor("#22000000"));
					ll_flash.setVisibility(View.INVISIBLE);
					tv_hdr.setVisibility(View.INVISIBLE);
					iv_center.setImageDrawable(null);
					iv_countdown.setVisibility(View.INVISIBLE);
					iv_flip.setVisibility(View.VISIBLE);
					iv_style.setVisibility(View.INVISIBLE);

					showShortToast(R.string.camera_lapse_toast);

					break;
				case 1:
					ll_top.setVisibility(View.VISIBLE);

					ll_all.setBackgroundResource(R.drawable.camera_photo);
					iv_center.setImageDrawable(null);

					ll_bottom.setBackgroundColor(Color.parseColor("#22000000"));
					ll_top.setBackgroundColor(Color.parseColor("#22000000"));
					ll_flash.setVisibility(View.VISIBLE);
					tv_hdr.setVisibility(View.VISIBLE);
					tv_hdr.setText("00:00:00");
					iv_countdown.setVisibility(View.GONE);
					iv_flip.setVisibility(View.INVISIBLE);
					iv_style.setVisibility(View.INVISIBLE);
					showShortToast(R.string.camera_slow_toast);

					break;
				case 2:
					ll_top.setVisibility(View.VISIBLE);

					ll_all.setBackgroundResource(R.drawable.camera_photo);
					iv_center.setImageDrawable(null);

					ll_bottom.setBackgroundColor(Color.parseColor("#22000000"));
					ll_top.setBackgroundColor(Color.parseColor("#22000000"));
					ll_flash.setVisibility(View.VISIBLE);
					tv_hdr.setVisibility(View.VISIBLE);
					tv_hdr.setText("00:00:00");
					iv_countdown.setVisibility(View.GONE);
					iv_flip.setVisibility(View.VISIBLE);
					iv_style.setVisibility(View.INVISIBLE);
					showShortToast(R.string.camera_video_toast);

					break;
				case 3:
					ll_top.setVisibility(View.VISIBLE);
					tv_hdr.setText("HDR自动");

					ll_bottom.setBackgroundColor(Color.parseColor("#000000"));
					ll_top.setBackgroundColor(Color.parseColor("#000000"));
					ll_flash.setVisibility(View.VISIBLE);
					iv_center.setImageResource(R.drawable.camera_photo);
					tv_hdr.setVisibility(View.VISIBLE);
					iv_countdown.setVisibility(View.VISIBLE);
					iv_flip.setVisibility(View.VISIBLE);
					iv_style.setVisibility(View.VISIBLE);
					showShortToast(R.string.camera_photo_toast);

					break;
				case 4:
					ll_top.setVisibility(View.VISIBLE);

					ll_bottom.setBackgroundColor(Color.parseColor("#000000"));
					ll_top.setBackgroundColor(Color.parseColor("#000000"));
					ll_flash.setVisibility(View.VISIBLE);
					iv_center.setImageResource(R.drawable.camera_square);
					tv_hdr.setVisibility(View.VISIBLE);
					iv_countdown.setVisibility(View.VISIBLE);
					iv_flip.setVisibility(View.VISIBLE);
					iv_style.setVisibility(View.VISIBLE);
					showShortToast(R.string.camera_square_toast);

					break;
				case 5:
					ll_top.setVisibility(View.GONE);
					ll_all.setBackgroundResource(R.drawable.camera_long);
					iv_center.setImageDrawable(null);

					ll_bottom.setBackgroundColor(Color.parseColor("#22000000"));
					iv_style.setVisibility(View.INVISIBLE);
					showShortToast(R.string.camera_all_toast);

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
		adapter = new MyAdapter();

		vp_type.setAdapter(adapter);
		vp_type.setCurrentItem(3);
		System.out.println(mStrarray.length);
	}

	public class MyAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return tvlist.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(tvlist.get(position));
		}

		/**
		 * 载入图片进去，用当前的position 除以 图片数组长度取余数是关键
		 */
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			setTextColor(position);
			container.addView(tvlist.get(position));

			return tvlist.get(position);
		}

		@Override
		public float getPageWidth(int position) {
			// TODO Auto-generated method stub
			return 0.2f;
		}
		//

	}

	private void setTextColor(int selectItems) {
		for (int i = 0; i < mStrarray.length; i++) {
			if (i == selectItems) {
				tvlist.get(selectItems).setTextColor(
						getResources().getColor(R.color.selected_camera_text));
			} else {
				tvlist.get(selectItems)
						.setTextColor(
								getResources().getColor(
										R.color.unselected_camera_text));

			}
		}
	}

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_camera;
	}

	// ll_flash = (LinearLayout) findViewById(R.id.camera_flash);
	// iv_countdown=(ImageView) findViewById(R.id.camera_countdown);
	// iv_flip=(ImageView) findViewById(R.id.camera_flip);
	// iv_takephoto=(ImageView) findViewById(R.id.camera_take_photo);
	// iv_photocase=(ImageView) findViewById(R.id.camera_photo_case);
	// iv_style=(ImageView) findViewById(R.id.camera_photo_style);
	// iv_center = (ImageView) findViewById(R.id.camera_center);
	// tv_hdr = (TextView) findViewById(R.id.camera_hdr);
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
			case R.id.camera_flash:
				showShortToast(R.string.camera_flash_toast);
				break;
			case R.id.camera_countdown:
				showShortToast(R.string.camera_countdown_toast);
				break;
			case R.id.camera_flip:
				showShortToast(R.string.camera_flip_toast);
				break;
			case R.id.camera_take_photo:
				showShortToast(R.string.camera_take_toast);
				break;
			case R.id.camera_photo_case:
				showShortToast(R.string.camera_case_toast);
				break;
			case R.id.camera_photo_style:
				showShortToast(R.string.camera_style_toast);
				break;
			case R.id.camera_hdr:
				showShortToast(R.string.camera_hdr_toast);
				break;
			case R.id.camera_center:
				showShortToast(R.string.camera_center_toast);
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
		boolean isFirst=LocalApplication.getInstance().sharereferences.getBoolean("camera", false);
	      if(isFirst){	showAlertDialog(showString(R.string.app_camera),
			showString(R.string.camera_dialog),
			new String[] {showString(R.string.no_dialog), showString(R.string.yes_dialog)}, true, true, null);}
		     LocalApplication.getInstance().sharereferences.edit().putBoolean("camera", false).commit();

	}
}
