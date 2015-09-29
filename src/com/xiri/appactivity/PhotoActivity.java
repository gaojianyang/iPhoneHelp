package com.xiri.appactivity;

import java.util.List;


import com.xiri.activity.BaseActivity;
import com.xiri.application.LocalApplication;
import com.xiri.fragment.PhotoFragmentOne;
import com.xiri.fragment.PhotoFragmentThree;
import com.xiri.fragment.PhotoFragmentTwo;
import com.example.iphonereborn.R;
import com.xiri.util.JListKit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class PhotoActivity extends BaseActivity implements OnClickListener {

	private List<Fragment> fragmentList = JListKit.newArrayList();
	private PhotoFragmentOne fragmentone;
	private PhotoFragmentTwo fragmenttwo;
	private PhotoFragmentThree fragmentthree;
	private FragmentTransaction ft;
	private ImageView iv_photo;
	private ImageView iv_album;
	private ImageView iv_share;
	private TextView tv_share;
	private TextView tv_album;
	private TextView tv_photo;

	private int chooseIndex = -1;
	// private long firstTime = 0;
	// 是否被回收
	private boolean isRecycle = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		iv_photo = (ImageView) findViewById((int) R.id.photo_bottom_photo);
		iv_share = (ImageView) findViewById((int) R.id.photo_bottom_share);
		iv_album = (ImageView) findViewById((int) R.id.photo_bottom_album);
		tv_share = (TextView) findViewById((int) R.id.photo_tv_share);
		tv_album = (TextView) findViewById((int) R.id.photo_tv_album);
		tv_photo = (TextView) findViewById((int) R.id.photo_tv_photo);
		iv_photo.setOnClickListener(this);
		iv_share.setOnClickListener(this);

		iv_album.setOnClickListener(this);

		if (savedInstanceState == null) {
			// 默认选中资讯
			onClick(iv_photo);
		}
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.photo, menu);
	// return true;
	// }
	//
	// @Override
	// public boolean onOptionsItemSelected(MenuItem item) {
	// // Handle action bar item clicks here. The action bar will
	// // automatically handle clicks on the Home/Up button, so long
	// // as you specify a parent activity in AndroidManifest.xml.
	// int id = item.getItemId();
	// if (id == R.id.action_settings) {
	// return true;
	// }
	// return super.onOptionsItemSelected(item);
	// }

	private void tabBgChange(int index) {
		switch (index) {
		// 照片
		case 0:

			iv_photo.setImageResource(R.drawable.photos_pressd);
			iv_share.setImageResource(R.drawable.icloud_unpressd);
			iv_album.setImageResource(R.drawable.albums_unpressd);
			tv_photo.setTextColor(getResources().getColor(
					R.color.selected_photo_text));
			tv_share.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_album.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));

			break;
		// 共享
		case 1:

			iv_photo.setImageResource(R.drawable.photos_unpressd);
			iv_share.setImageResource(R.drawable.icloud_pressd);
			iv_album.setImageResource(R.drawable.albums_unpressd);
			tv_photo.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_share.setTextColor(getResources().getColor(
					R.color.selected_photo_text));
			tv_album.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));

			break;
		// 相簿
		case 2:

			iv_photo.setImageResource(R.drawable.photos_unpressd);
			iv_share.setImageResource(R.drawable.icloud_unpressd);
			iv_album.setImageResource(R.drawable.albums_pressed);
			tv_photo.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_share.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_album.setTextColor(getResources().getColor(
					R.color.selected_photo_text));
			break;

		}

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		// 记录fragment索引,防止activity被系统回收时，fragment错乱的问题
		outState.putBoolean("isRecycle", true);
		outState.putInt("index", chooseIndex);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		isRecycle = savedInstanceState.getBoolean("isRecycle");
		chooseIndex = savedInstanceState.getInt("index");
	}

	@Override
	protected void onResume() {
		super.onResume();
		// 如果activity被系统回收了
		if (isRecycle) {
			tabBgChange(chooseIndex);
		}
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		fragmentone = new PhotoFragmentOne();
		fragmenttwo = new PhotoFragmentTwo();
		fragmentthree = new PhotoFragmentThree();
		fragmentList.add(fragmentone);
		fragmentList.add(fragmenttwo);
		fragmentList.add(fragmentthree);
	}

	@Override
	protected void initParams() {
		// TODO Auto-generated method stub

	}

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_photo;
	}

	@Override
	protected void showFisrtDialog() {
		// TODO Auto-generated method stub
		boolean isFirst = LocalApplication.getInstance().sharereferences
				.getBoolean("photo", false);
		if (isFirst) {
			showAlertDialog(showString(R.string.app_photos),
					showString(R.string.photo_dialog), new String[] {
							showString(R.string.no_dialog),
							showString(R.string.yes_dialog) }, true, true, null);
		}
		LocalApplication.getInstance().sharereferences.edit()
				.putBoolean("photo", false).commit();

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		ft = getSupportFragmentManager().beginTransaction();
		System.out.println(iv_photo.getId() + "------------");
		switch (v.getId()) {
		case R.id.photo_bottom_photo:

			if (chooseIndex != 0) {
				chooseIndex = 0;
				tabBgChange(chooseIndex);
				ft.replace(R.id.photo_vp, PhotoFragmentOne.instantiate(
						getApplicationContext(),
						PhotoFragmentOne.class.getName(), null),
						"photofragmentone");
			}

			break;
		case R.id.photo_bottom_share:

			if (chooseIndex != 1) {
				chooseIndex = 1;
				tabBgChange(chooseIndex);
				ft.replace(R.id.photo_vp, PhotoFragmentTwo.instantiate(
						getApplicationContext(),
						PhotoFragmentTwo.class.getName(), null),
						"photofragmenttwo");
			}

			break;
		case R.id.photo_bottom_album:

			if (chooseIndex != 2) {
				chooseIndex = 2;
				tabBgChange(chooseIndex);
				ft.replace(R.id.photo_vp, PhotoFragmentThree.instantiate(
						getApplicationContext(),
						PhotoFragmentThree.class.getName(), null),
						"photofragmentthree");
			}

			break;

		default:
			break;
		}
		ft.commit();
	}

	//
	// @Override
	// public void onBackPressed()
	// {
	// long secondTime = System.currentTimeMillis();
	// // 如果两次按键时间间隔大于1000毫秒，则不退出
	// if (secondTime - firstTime > 1000)
	// {
	// ToastMaker.showShortToast("再按一次退出客户端");
	// firstTime = secondTime;// 更新firstTime
	// } else
	// {
	// finish();
	// }
	// }
}
