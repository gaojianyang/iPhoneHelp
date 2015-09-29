package com.xiri.fragment;

import android.annotation.SuppressLint;


import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;


import com.xiri.activity.BaseFragment;
import com.example.iphonereborn.R;

public class PhotoFragmentOne extends BaseFragment implements OnTouchListener{
  
   
	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.photo_part_first;
	}

	@Override
	protected void initParams() {
		// TODO Auto-generated method stub
		
		   ImageView iv_search=(ImageView) mView.findViewById(R.id.photo_search_iv);
		   ImageView iv_center=(ImageView) mView.findViewById(R.id.photo_one_center);

		iv_search.setOnTouchListener(this);
		iv_center.setOnTouchListener(this);

	}

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
			case R.id.photo_search_iv:
				showShortToast(R.string.photo_search1_toast);
				break;
			case R.id.photo_one_center:
				showShortToast(R.string.photo_center1_toast);

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

}
