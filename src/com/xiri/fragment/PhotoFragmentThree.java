package com.xiri.fragment;

import android.view.MotionEvent;


import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiri.activity.BaseFragment;
import com.example.iphonereborn.R;

public class PhotoFragmentThree extends BaseFragment implements OnTouchListener{
 
	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.photo_part_thrid;
	}

	@Override
	protected void initParams() {
		// TODO Auto-generated method stub
		   ImageView iv_search=(ImageView) mView.findViewById(R.id.photo_add_iv);
		   ImageView iv_center=(ImageView) mView.findViewById(R.id.photo_search_iv);
		   TextView tv_edit=(TextView) mView.findViewById(R.id.photo_edit_tv);
		   iv_search.setOnTouchListener(this);  
		   iv_center.setOnTouchListener(this);  
		   tv_edit.setOnTouchListener(this);  


	}
	

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
			switch (v.getId()) {
			case R.id.photo_search_iv:
				showShortToast(R.string.photo_search3_toast);
				break;
			case R.id.photo_add_iv:
				showShortToast(R.string.photo_add3_toast);

				break;
			case R.id.photo_edit_tv:
				showShortToast(R.string.photo_edit3_toast);		
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
