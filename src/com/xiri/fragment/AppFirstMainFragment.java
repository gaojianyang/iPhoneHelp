package com.xiri.fragment;

import java.util.ArrayList;

import java.util.List;
import com.xiri.adapter.GridViewAdapter;
import com.xiri.appactivity.AppStoreActivity;
import com.xiri.appactivity.CalenderActivity;
import com.xiri.appactivity.CameraActivity;
import com.xiri.appactivity.GameCenterActivity;
import com.xiri.appactivity.HealthActivity;
import com.xiri.appactivity.IbookActivity;
import com.xiri.appactivity.ItunesStoreActivity;
import com.xiri.appactivity.MagzineActivity;
import com.xiri.appactivity.MapActivity;
import com.xiri.appactivity.MessageActivity;
import com.xiri.appactivity.NoteActivity;
import com.xiri.appactivity.PassbookActivity;
import com.xiri.appactivity.PhotoActivity;
import com.xiri.appactivity.RemindActivity;
import com.xiri.appactivity.SetActivity;
import com.xiri.appactivity.ShareActivity;
import com.xiri.appactivity.TimeActivity;
import com.xiri.appactivity.VideoActivity;
import com.xiri.appactivity.WeatherActivity;
import com.example.iphonereborn.R;
import com.xiri.model.Icon;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class AppFirstMainFragment extends Fragment {
	private GridView gd;
	public static int[] images = new int[] { R.drawable.icon, R.drawable.icon2,
			R.drawable.icon19, R.drawable.icon3, R.drawable.icon4,
			R.drawable.icon5, R.drawable.icon6, R.drawable.icon7,
			R.drawable.icon8, R.drawable.icon9, R.drawable.icon10,
			R.drawable.icon11, R.drawable.icon12, R.drawable.icon13,
			R.drawable.icon14, R.drawable.icon15, R.drawable.icon16,
			R.drawable.icon17, R.drawable.icon18 };
	public static int[] texts = new int[] { R.string.app_messages,
			R.string.app_calendar, R.string.app_photos, R.string.app_camera,
			R.string.app_weather, R.string.app_clock, R.string.app_maps,
			R.string.app_videos, R.string.app_notes, R.string.app_reminders,
			R.string.app_stocks, R.string.app_gamecenter,
			R.string.app_newsstand, R.string.app_itunestore,
			R.string.app_appstore, R.string.app_ibooks, R.string.app_health,
			R.string.app_passbook, R.string.app_settings };
	public List<Icon> iconList;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		iconList = new ArrayList<Icon>();
		gd = (GridView) inflater.inflate(R.layout.app_ui_main1, container,
				false).findViewById(R.id.gd1);
		gd.setSelector(R.drawable.gridview_selector);
		for (int i = 0; i < images.length; i++) {
			Icon icon = new Icon(getImage(images[i]), getTexts(texts[i]));
			iconList.add(icon);
		}
		GridViewAdapter gAdapter = new GridViewAdapter(getActivity(), iconList);
		gd.setAdapter(gAdapter);
	iconList=null;
		return gd;

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}
//考虑到iphone可以更改图标大小，转换成drawable以便以后变换大小
	public Drawable getImage(int id) {
		Drawable drawable = getActivity().getResources().getDrawable(id);
		return drawable;

	}

	public String getTexts(int id) {
		String string = getActivity().getResources().getString(id);
		return string;

	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		gd.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				switch (position) {
				case 0:
					StarttoOtherActivity(MessageActivity.class);

					break;
				case 1:
					StarttoOtherActivity(CalenderActivity.class);

					break;
				case 2:
					StarttoOtherActivity(PhotoActivity.class);

					break;
				case 3:
					StarttoOtherActivity(CameraActivity.class);

					break;
				case 4:
					StarttoOtherActivity(WeatherActivity.class);

					break;

				case 5:
					StarttoOtherActivity(TimeActivity.class);

					break;

				case 6:
					StarttoOtherActivity(MapActivity.class);

					break;

				case 7:
					StarttoOtherActivity(VideoActivity.class);

					break;
				case 8:
					StarttoOtherActivity(NoteActivity.class);

					break;
				case 9:
					StarttoOtherActivity(RemindActivity.class);

					break;
				case 10:
					StarttoOtherActivity(ShareActivity.class);
					
					break;
				case 11:
					StarttoOtherActivity(GameCenterActivity.class);

			
					break;
				case 12:
					StarttoOtherActivity(MagzineActivity.class);
					break;
				case 13:
					StarttoOtherActivity(ItunesStoreActivity.class);
				
					break;
				case 14:
					StarttoOtherActivity(AppStoreActivity.class);

				
					break;
				case 15:
					StarttoOtherActivity(IbookActivity.class);

				
					break;
				case 16:
					StarttoOtherActivity(HealthActivity.class);
					break;
				case 17:
					StarttoOtherActivity(PassbookActivity.class);
				
					break;
				case 18:
					StarttoOtherActivity(SetActivity.class);
					
					break;

				default:
					break;
				}

			}
		});
	}

	/**
	 * ��˹ģ��
	 * 
	 * @param bmp
	 * @return
	 */
	private void StarttoOtherActivity(Class<?> a){
		Intent intent=new Intent();
		intent.setClass(getActivity(), a);
		startActivity(intent);
		
	}

}
