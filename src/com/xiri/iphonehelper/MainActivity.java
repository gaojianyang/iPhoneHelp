package com.xiri.iphonehelper;

import java.util.ArrayList;



import java.util.List;
import com.xiri.appactivity.CallActivity;
import com.xiri.appactivity.MailActivity;
import com.xiri.appactivity.MusicActivity;
import com.xiri.appactivity.SafariActivity;
import com.xiri.application.LocalApplication;
import com.xiri.fragment.AppFirstMainFragment;
import com.xiri.fragment.AppSearchFragment;
import com.xiri.fragment.AppSecondMainFragment;
import com.xiri.view.DialogMaker;
import com.xiri.view.ToastMaker;
import com.xiri.view.DialogMaker.DialogCallBack;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Gravity;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.example.iphonereborn.R;

import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnClickListener, DialogCallBack{
	private Dialog dialog;

	private ViewPager mViewPager;
	private ImageView pageIndicator1;
	private ImageView pageIndicator2;
	private TextView tv_call;
	private TextView tv_mail;
	private TextView tv_safari;
	private TextView tv_music;

	private FragmentPagerAdapter mAdapter;
	private Fragment mMain1;
	private Fragment mMain2;
	private Fragment mMainsearch;
	private View up;
	private FrameLayout fl;
	private LinearLayout ll;
	
	int height;
	int width;
	int displayHeight;
	int displayWidth;
	private LinearLayout upView;
	private RelativeLayout rel;

	private View view;
	private View topview;
	int currentitem = 0;
	private List<Fragment> list = new ArrayList<Fragment>();
	PopupWindow bottomwindow;
	PopupWindow topwindow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();

		mViewPager.setAdapter(mAdapter);
		mViewPager.setCurrentItem(1);
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				System.out.println(arg0 + "_________-----");
				currentitem = arg0;
				if (arg0 == 1) {
					if (fl.getScrollX() != 0) {
						;
						fl.scrollTo(0, 0);
					}
					ll.setVisibility(View.VISIBLE);
					upView.setBackgroundResource(R.drawable.wallpaper);
				} else if (arg0 == 0) {
					ll.setVisibility(View.GONE);

				}
				resetImg();

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				System.out.println(displayWidth);
				System.out.println(arg0 + "    arg0");
				System.out.println(arg1 + "----arg1");
				System.out.println(arg2 + "----arg2");

				if (arg0 == 0) {
					fl.scrollTo(-(displayWidth - arg2), 0);
					if (arg1 < 0.85) {
						upView.setBackgroundResource(R.drawable.wuming);

					} else {
						upView.setBackgroundResource(R.drawable.wallpaper);

					}
				}
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

	@SuppressWarnings("deprecation")
	private void initView() {
		displayWidth = this.getWindowManager().getDefaultDisplay().getWidth();
		upView = (LinearLayout) findViewById(R.id.main_ll);
		ll = (LinearLayout) findViewById(R.id.ll_pick);
		rel = (RelativeLayout) findViewById(R.id.statusbar);
		fl = (FrameLayout) findViewById(R.id.fl);
		
		
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		pageIndicator1 = (ImageView) findViewById(R.id.pageindicator1);
		pageIndicator2 = (ImageView) findViewById(R.id.pageindicator2);
		tv_call = (TextView) findViewById(R.id.app_call);
		tv_safari = (TextView) findViewById(R.id.app_safari);
		tv_mail = (TextView) findViewById(R.id.app_mail);
		tv_music = (TextView) findViewById(R.id.app_music);
		tv_call.setOnClickListener(this);
		tv_safari.setOnClickListener(this);
		tv_mail.setOnClickListener(this);
		tv_music.setOnClickListener(this);
		up = findViewById(R.id.up_view);
		mMainsearch = new AppSearchFragment();
		mMain1 = new AppFirstMainFragment();
		mMain2 = new AppSecondMainFragment();
		list.add(mMainsearch);
		list.add(mMain1);
		list.add(mMain2);
		showFisrtDialog();
		rel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showtopWindow();
			}
		});
		up.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showbottomWindow();
			}
		});
		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return list.size();
			}

			@Override
			public Fragment getItem(int arg0) {
				// TODO Auto-generated method stub
				return list.get(arg0);
			}
		};
	}

	private void resetImg() {
		int currentItem = mViewPager.getCurrentItem();
		switch (currentItem) {
		case 1:
			pageIndicator1.setImageResource(R.drawable.pageindicator_active);
			pageIndicator2.setImageResource(R.drawable.pageindicator_notactive);
			break;
		case 2:
			pageIndicator1.setImageResource(R.drawable.pageindicator_notactive);
			pageIndicator2.setImageResource(R.drawable.pageindicator_active);
			break;

		default:
			break;
		}

	}

	@SuppressWarnings("deprecation")
	@SuppressLint("InflateParams")
	private void showbottomWindow() {
		
		view = LayoutInflater.from(getApplicationContext()).inflate(
				R.layout.ios_control_center, null);
		initPopupWindowView();

		view.measure(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		height = view.getMeasuredHeight();
		width = view.getMeasuredWidth();
		bottomwindow = new PopupWindow(view, LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT, true);
		bottomwindow.setTouchable(true);
		bottomwindow.setAnimationStyle(R.style.PopupAnimation);
		bottomwindow.setBackgroundDrawable(new BitmapDrawable());
		bottomwindow.showAtLocation(upView, Gravity.RIGHT | Gravity.TOP,
				height, width);

	}

	@SuppressLint("InflateParams") @SuppressWarnings("deprecation")
	private void showtopWindow() {

		topview = LayoutInflater.from(getApplicationContext()).inflate(
				R.layout.ios_notificition_center, null);
		initTopWindowView();
		topview.measure(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		int topheight = topview.getMeasuredHeight();
		int topwidth = topview.getMeasuredWidth();

		topwindow = new PopupWindow(topview, LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT, true);
		topwindow.setTouchable(true);
		topwindow.setAnimationStyle(R.style.PopupTopAnimation);
		topwindow.setBackgroundDrawable(new BitmapDrawable());
		topwindow.showAtLocation(upView, Gravity.RIGHT | Gravity.BOTTOM,
				topheight, topwidth);

	}

	private void initTopWindowView() {
		ImageView iv_dismiss2 = (ImageView) topview
				.findViewById(R.id.swipedown2);
		ImageView iv_segment = (ImageView) topview
				.findViewById(R.id.segmentcontrol);

		iv_dismiss2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				topwindow.dismiss();
			}
		});

		iv_segment.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ToastMaker.showShortToast(R.string.notification_segment_toast);
			}
		});
	}
@Override
protected void onPause() {
	// TODO Auto-generated method stub
	super.onPause();
	 if(topwindow != null) {
		 topwindow.dismiss(); 
    }
	 if(bottomwindow != null) {
		 bottomwindow.dismiss(); 
    }
	
	
}
	// window的点击事件一个个写的，因为activity继承接口会导致点击事件紊乱，而单独写却没问题，省时间就这样写了
	private void initPopupWindowView() {
		// TODO Auto-generated method stub
		ImageView iv_dismiss = (ImageView) view.findViewById(R.id.swipedwon);

		ImageView iv_air = (ImageView) view.findViewById(R.id.airplane);
		ImageView iv_wifi = (ImageView) view.findViewById(R.id.wifi);
		ImageView iv_bluetooth = (ImageView) view.findViewById(R.id.bluetooth);
		ImageView iv_disturb = (ImageView) view.findViewById(R.id.disturb);
		ImageView iv_lock = (ImageView) view.findViewById(R.id.lock);
		ImageView iv_brightness = (ImageView) view
				.findViewById(R.id.brightness);
		ImageView iv_music = (ImageView) view.findViewById(R.id.musiccontrols);
		ImageView iv_airdrop = (ImageView) view.findViewById(R.id.airdrop);
		ImageView iv_light = (ImageView) view.findViewById(R.id.light);
		ImageView iv_timer = (ImageView) view.findViewById(R.id.timer);
		ImageView iv_calculator = (ImageView) view
				.findViewById(R.id.calculator);
		ImageView iv_camera = (ImageView) view.findViewById(R.id.camera);


		iv_air.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ToastMaker.showShortToast(R.string.control_air_toast);
			}
		});
		iv_wifi.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ToastMaker.showShortToast(R.string.control_wifi_toast);
			}
		});
		iv_bluetooth.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ToastMaker.showShortToast(R.string.control_blue_toast);
			}
		});
		iv_disturb.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ToastMaker.showShortToast(R.string.control_disturb_toast);
			}
		});
		iv_lock.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ToastMaker.showShortToast(R.string.control_lock_toast);
			}
		});
		iv_brightness.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ToastMaker.showShortToast(R.string.control_bight_toast);
			}
		});
		iv_music.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ToastMaker.showShortToast(R.string.control_music_toast);
			}
		});
		iv_airdrop.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ToastMaker.showShortToast(R.string.control_airdrop_toast);
			}
		});
		iv_light.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ToastMaker.showShortToast(R.string.control_light_toast);
			}
		});
		iv_timer.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ToastMaker.showShortToast(R.string.control_timer_toast);
			}
		});
		iv_calculator.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ToastMaker.showShortToast(R.string.control_calculate_toast);
			}
		});
		iv_camera.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ToastMaker.showShortToast(R.string.control_camera_toast);
			}
		});
		iv_dismiss.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bottomwindow.dismiss();
			}
		});
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

		view = null;
	}

	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.app_call:
			StarttoOtherActivity(CallActivity.class);
			
			break;
		case R.id.app_safari:
			StarttoOtherActivity(SafariActivity.class);

			break;
		case R.id.app_mail:
			StarttoOtherActivity(MailActivity.class);

			break;
		case R.id.app_music:
			StarttoOtherActivity(MusicActivity.class);

			break;

		default:
			break;
		}
	}
	private void StarttoOtherActivity(Class<?> a){
		Intent intent=new Intent();
		intent.setClass(getApplicationContext(), a);
		startActivity(intent);
		
	}
	protected void showFisrtDialog() {
		// TODO Auto-generated method stub
		boolean isFirst = LocalApplication.getInstance().sharereferences
				.getBoolean("main", false);
		if (isFirst) {
			showAlertDialog(showString(R.string.app_content),
					showString(R.string.main_dialog), new String[] {
							showString(R.string.no_dialog),
							showString(R.string.yes_dialog) }, true, true, null);
		}
		LocalApplication.getInstance().sharereferences.edit()
				.putBoolean("main", false).commit();

	}
	private String showString(int id){
		String str=getApplicationContext().getResources().getString(id);
		return str;
	}
	private Dialog showAlertDialog(String title, String msg, String[] btns, boolean isCanCancelabel, final boolean isDismissAfterClickBtn, Object tag)
	{
		if (null == dialog || !dialog.isShowing())
		{
			dialog = DialogMaker.showCommonAlertDialog(this, title, msg, btns, this, isCanCancelabel, isDismissAfterClickBtn, tag);
		}
		return dialog;
	}

	@Override
	public void onButtonClicked(Dialog dialog, int position, Object tag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCancelDialog(Dialog dialog, Object tag) {
		// TODO Auto-generated method stub
		
	}
	
}
