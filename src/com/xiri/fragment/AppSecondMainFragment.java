package com.xiri.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.iphonereborn.R;
import com.xiri.adapter.GridViewAdapter;
import com.xiri.appactivity.ShortCutActivity;
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

public class AppSecondMainFragment extends Fragment {
	private GridView gd;
	public static int[] images = new int[] { R.drawable.ios9_icon};
public static int[] texts = new int[] { R.string.app_shortcut };
public List<Icon> iconList;
@Override
public View onCreateView(LayoutInflater inflater,
		@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
	iconList = new ArrayList<Icon>();
	gd = (GridView) inflater.inflate(R.layout.app_ui_main2, container,
			false).findViewById(R.id.gd2);
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
public void onStart() {
	// TODO Auto-generated method stub
	super.onStart();
	gd.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			if(position==0){
				Intent intent=new Intent();
				intent.setClass(getActivity(), ShortCutActivity.class);
				startActivity(intent);
				
			}
		}
	});
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
	
}
