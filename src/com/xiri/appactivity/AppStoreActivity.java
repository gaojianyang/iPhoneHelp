package com.xiri.appactivity;

import android.content.Context;


import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiri.activity.BaseActivity;
import com.xiri.application.LocalApplication;
import com.example.iphonereborn.R;
import com.xiri.nextactivity.AppStoreNextActivity;
import com.xiri.thrid.HorizontalListView;
import com.xiri.util.DisplayUtil;

public class AppStoreActivity extends BaseActivity implements OnClickListener {
	private HorizontalListView lv;
	private ImageView iv_menu;
	private ImageView iv_bottom1;
	private ImageView iv_bottom2;
	private ImageView iv_bottom3;
	private ImageView iv_bottom4;

	private ImageView iv_favorite;
	private ImageView iv_feature;
	private ImageView iv_search;
	private ImageView iv_safari;
	private ImageView iv_update;
	private TextView tv_favorite;
	private TextView tv_feature;
	private TextView tv_search;
	private TextView tv_safari;
	private TextView tv_update;

	private int[] imageid = new int[] { R.drawable.app_content1,
			R.drawable.app_content2, R.drawable.app_content3,
			R.drawable.app_content4, R.drawable.app_content5 };

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_appstore;
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		iv_menu = (ImageView) findViewById(R.id.appstore_menu);
		iv_bottom1 = (ImageView) findViewById(R.id.appstore_bottom1);
		iv_bottom2 = (ImageView) findViewById(R.id.appstore_bottom2);
		iv_bottom3 = (ImageView) findViewById(R.id.appstore_bottom3);
		iv_bottom4 = (ImageView) findViewById(R.id.appstore_bottom4);

		iv_favorite = (ImageView) findViewById(R.id.app_bottom_favorite_iv);
		iv_feature = (ImageView) findViewById(R.id.app_bottom_feature_iv);
		iv_search = (ImageView) findViewById(R.id.app_bottom_search_iv);
		iv_safari = (ImageView) findViewById(R.id.app_bottom_safari_iv);
		iv_update = (ImageView) findViewById(R.id.app_bottom_update_iv);
		tv_favorite = (TextView) findViewById(R.id.app_bottom_favorite_tv);
		tv_feature = (TextView) findViewById(R.id.app_bottom_feature_tv);
		tv_search = (TextView) findViewById(R.id.app_bottom_search_tv);
		tv_safari = (TextView) findViewById(R.id.app_bottom_safari_tv);
		tv_update = (TextView) findViewById(R.id.app_bottom_update_tv);

		iv_menu.setOnClickListener(this);
		iv_favorite.setOnClickListener(this);
		iv_feature.setOnClickListener(this);
		iv_search.setOnClickListener(this);
		iv_safari.setOnClickListener(this);
		iv_update.setOnClickListener(this);
		iv_bottom1.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(), R.drawable.app_bottom1));
		iv_bottom2.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(), R.drawable.app_bottom2));
		iv_bottom3.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(), R.drawable.app_bottom3));
		iv_bottom4.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(), R.drawable.app_bottom4));
		
		lv = (HorizontalListView) findViewById(R.id.horizontalListView1);
		lv.setAdapter(new TestAdapter(getApplicationContext()));
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				view.setAlpha(0.5f);
				if (position == 0) {
					startToOtherActivity(AppStoreNextActivity.class);

				}
			}
		});
	}

	@Override
	protected void initParams() {
		// TODO Auto-generated method stub

	}

	class TestAdapter extends BaseAdapter {

		private Context context;

		public TestAdapter(Context context) {

			this.context = context;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return imageid.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return imageid[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub

			ViewHolder holder;
			if (convertView == null) {
				LayoutInflater li = (LayoutInflater) context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = li.inflate(R.layout.hori_adapterview, parent,
						false);
				holder = new ViewHolder();
				holder.ivapp = (ImageView) convertView
						.findViewById(R.id.imageview);

				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			holder.ivapp.setImageResource(imageid[position]);

			return convertView;
		}

		class ViewHolder {
			ImageView ivapp;

		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.app_bottom_favorite_iv:
			iv_favorite.setImageResource(R.drawable.favorites_pressed);
			iv_feature.setImageResource(R.drawable.featured_unpressed);
			iv_search.setImageResource(R.drawable.search_unpressed);
			iv_safari.setImageResource(R.drawable.safari_compass_unpressed);
			iv_update.setImageResource(R.drawable.update_unpressed);
			tv_favorite.setTextColor(getResources().getColor(
					R.color.selected_photo_text));
			tv_feature.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_search.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_safari.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_update.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			showLongToast(R.string.appstore_favorite_toast);
			break;
		case R.id.app_bottom_feature_iv:
			iv_favorite.setImageResource(R.drawable.favorites_unpressed);
			iv_feature.setImageResource(R.drawable.featured_pressed);
			iv_search.setImageResource(R.drawable.search_unpressed);
			iv_safari.setImageResource(R.drawable.safari_compass_unpressed);
			iv_update.setImageResource(R.drawable.update_unpressed);
			tv_favorite.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_feature.setTextColor(getResources().getColor(
					R.color.selected_photo_text));
			tv_search.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_safari.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_update.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));

			break;
		case R.id.app_bottom_search_iv:
			iv_favorite.setImageResource(R.drawable.favorites_unpressed);
			iv_feature.setImageResource(R.drawable.featured_unpressed);
			iv_search.setImageResource(R.drawable.search_blue);
			iv_safari.setImageResource(R.drawable.safari_compass_unpressed);
			iv_update.setImageResource(R.drawable.update_unpressed);
			tv_favorite.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_feature.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_search.setTextColor(getResources().getColor(
					R.color.selected_photo_text));
			tv_safari.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_update.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			showShortToast(R.string.appstore_search_toast);

			break;
		case R.id.app_bottom_safari_iv:
			iv_favorite.setImageResource(R.drawable.favorites_unpressed);
			iv_feature.setImageResource(R.drawable.featured_unpressed);
			iv_search.setImageResource(R.drawable.search_unpressed);
			iv_safari.setImageResource(R.drawable.safari_compass_pressed);
			iv_update.setImageResource(R.drawable.update_unpressed);
			tv_favorite.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_feature.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_search.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_safari.setTextColor(getResources().getColor(
					R.color.selected_photo_text));
			tv_update.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			showShortToast(R.string.appstore_safari_toast);

			break;
		case R.id.app_bottom_update_iv:
			iv_favorite.setImageResource(R.drawable.favorites_unpressed);
			iv_feature.setImageResource(R.drawable.featured_unpressed);
			iv_search.setImageResource(R.drawable.search_unpressed);
			iv_safari.setImageResource(R.drawable.safari_compass_unpressed);
			iv_update.setImageResource(R.drawable.update_pressed);
			tv_favorite.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_feature.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_search.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_safari.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_update.setTextColor(getResources().getColor(
					R.color.selected_photo_text));
			showShortToast(R.string.appstore_update_toast);

			break;
		case R.id.appstore_menu:
			showShortToast(R.string.appstore_menu_toast);
			break;
		default:
			break;
		}
	}

	@Override
	protected void showFisrtDialog() {
		// TODO Auto-generated method stub
		boolean isFirst = LocalApplication.getInstance().sharereferences
				.getBoolean("appstore", false);
		if (isFirst) {
			showAlertDialog(showString(R.string.app_appstore),
					showString(R.string.appstore_dialog), new String[] {
							showString(R.string.no_dialog),
							showString(R.string.yes_dialog) }, true, true, null);
		}
		LocalApplication.getInstance().sharereferences.edit()
				.putBoolean("appstore", false).commit();

	}

}
