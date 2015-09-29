package com.xiri.appactivity;

import java.util.ArrayList;


import java.util.List;


import com.xiri.activity.BaseActivity;
import com.xiri.application.LocalApplication;
import com.example.iphonereborn.R;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;


public class ShareActivity extends BaseActivity implements OnTouchListener{
	private ViewPager mVp;
	private ImageView iv_add;
	private ImageView iv_yahoo;
	private List<ImageView> list;
	private int[] imageId=new int[]{R.drawable.share_bottom1,R.drawable.share_bottom2,R.drawable.share_bottom3};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_share;
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		mVp=(ViewPager) findViewById(R.id.share_vp);
		iv_add=(ImageView) findViewById(R.id.share_add);
		iv_yahoo=(ImageView) findViewById(R.id.share_yahoo);
		list=new ArrayList<ImageView>();
		for (int i = 0; i < imageId.length; i++) {
			ImageView mViewPagerImageView = new ImageView(getApplicationContext());
	         ViewGroup.LayoutParams viewPagerImageViewParams =
	               new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
	                     ViewGroup.LayoutParams.MATCH_PARENT);
	         mViewPagerImageView.setLayoutParams(viewPagerImageViewParams);
	         mViewPagerImageView.setScaleType(ScaleType.FIT_XY);
	         mViewPagerImageView.setImageResource(imageId[i]);
	         list.add(mViewPagerImageView);
		}
	mVp.setAdapter(new MyAdapter());
	iv_add.setOnTouchListener(this);
	iv_yahoo.setOnTouchListener(this);
	}

	@Override
	protected void initParams() {
		// TODO Auto-generated method stub
		
	}
	 public class MyAdapter extends PagerAdapter{  
		  
	        @Override  
	        public int getCount() {  
	            return list.size();  
	        }  
	  
	        @Override  
	        public boolean isViewFromObject(View arg0, Object arg1) {  
	            return arg0 == arg1;  
	        }  
	  
	        @Override  
	        public void destroyItem(ViewGroup container, int position, Object object) {  
	        	container.removeView( list.get(position));
	        }  
	  
	        /** 
	         * 载入图片进去，用当前的position 除以 图片数组长度取余数是关键 
	         */  
	        @Override  
	        public Object instantiateItem(ViewGroup container, int position) { 
	        	
	        	container.addView(list.get(position));
	        	
	            return list.get(position);  
	        }  
	       
//		  
	          
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
     		case R.id.share_add:
     		showShortToast(R.string.share_add_toast);
     			break;
     		case R.id.share_yahoo:
     			showShortToast(R.string.share_yahoo_toast);
     			break;
     		
     		default:
     			break;
     		}
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
		boolean isFirst=LocalApplication.getInstance().sharereferences.getBoolean("share", false);
	      if(isFirst){	showAlertDialog(showString(R.string.app_stocks),
			showString(R.string.share_dialog),
			new String[] {showString(R.string.no_dialog), showString(R.string.yes_dialog)}, true, true, null);}
		     LocalApplication.getInstance().sharereferences.edit().putBoolean("share", false).commit();

	}
}
