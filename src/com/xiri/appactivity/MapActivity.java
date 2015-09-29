package com.xiri.appactivity;

import uk.co.senab.photoview.PhotoViewAttacher;



import com.xiri.activity.BaseActivity;
import com.xiri.application.LocalApplication;
import com.example.iphonereborn.R;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class MapActivity extends BaseActivity implements OnTouchListener {
	private ImageView iv_right_turn;
	private ImageView iv_share;
	private ImageView iv_detail;
	private ImageView iv_location;
	private ImageView iv_center;

	private EditText et_content;
	PhotoViewAttacher mAttacher;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	@Override
	protected void initView(){
		iv_right_turn = (ImageView) findViewById(R.id.map_right_turn);
		iv_share=(ImageView) findViewById(R.id.map_share);
		iv_detail=(ImageView) findViewById(R.id.map_detail);
		iv_location=(ImageView) findViewById(R.id.map_location);
		iv_center=(ImageView) findViewById(R.id.map_center);

		et_content = (EditText) findViewById(R.id.map_et);
		iv_center.setImageDrawable(getResources().getDrawable(R.drawable.map_img1));
	    mAttacher = new PhotoViewAttacher(iv_center);
		mAttacher.setScaleType(ScaleType.FIT_XY);

		
		iv_right_turn.setOnTouchListener(this);
		iv_share.setOnTouchListener(this);
		iv_detail.setOnTouchListener(this);
		iv_location.setOnTouchListener(this);
		et_content.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
     			showShortToast(R.string.map_search_toast);
	
			}
		});
	}

	
	@Override
	protected void initParams() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_map;
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
     		case R.id.map_right_turn:
     			showShortToast(R.string.map_rightturn_toast);
     			break;
     		case R.id.map_share:
     			showShortToast(R.string.map_share_toast);
     			break;
     		case R.id.map_detail:
     			
     			break;
     		case R.id.map_location:
     			showShortToast(R.string.map_location_toast);
     			break;
     		default:
     			break;}
             
break;
        	 
         case MotionEvent.ACTION_CANCEL: {
             //clear the overlay
         v.setAlpha(1.0f);
             break;
         }
     }
		
		
		return true;
	}
	@Override
	protected void showFisrtDialog() {
		// TODO Auto-generated method stub
		boolean isFirst=LocalApplication.getInstance().sharereferences.getBoolean("map", false);
	      if(isFirst){	showAlertDialog(showString(R.string.app_maps),
			showString(R.string.map_dialog),
			new String[] {showString(R.string.no_dialog), showString(R.string.yes_dialog)}, true, true, null);}
		     LocalApplication.getInstance().sharereferences.edit().putBoolean("map", false).commit();

	}
}
