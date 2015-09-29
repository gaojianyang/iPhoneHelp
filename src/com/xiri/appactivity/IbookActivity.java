package com.xiri.appactivity;


import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.wandoujia.ads.sdk.Ads;
import com.xiri.activity.BaseActivity;
import com.xiri.application.LocalApplication;
import com.example.iphonereborn.R;

public class IbookActivity extends BaseActivity{
	private static final String APP_ID = "100032577";
	  private static final String SECRET_KEY = "eb84493f8a2d7bfa9ecc3cfcfacd23fe";
	  private static final String BANNER = "02dad1e59b5431cd9273fdaf5f42c0e4";
	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_ibook;
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		

		ImageView iv_content=	(ImageView) findViewById(R.id.ibook_content);
	iv_content.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		
		showShortToast(R.string.image_cant_toast);
			
		}
	});

	 final ViewGroup container = (ViewGroup) findViewById(R.id.banner_container);
	 
	 		
	 			new AsyncTask<Void, Void, Boolean>() {
	 			      @Override
	 			      protected Boolean doInBackground(Void... params) {
	 			        try {
	 			          Ads.init(IbookActivity.this, APP_ID, SECRET_KEY);
	 			          return true;
	 			        } catch (Exception e) {
	 			          Log.e("ads-sample", "error", e);
	 			          return false;
	 			        }
	 			      }
	 
	 			      @Override
	 			      protected void onPostExecute(Boolean success) {
	 
	 			        if (success) {
	 			          /**
	 			           * pre load
	 			           */
	 			          Ads.preLoad(BANNER, Ads.AdFormat.banner);
	 			         
	 
	 			          /**
	 			           * add ad views
	 			           */
	 			     View  bannerView = Ads.createBannerView(IbookActivity.this, BANNER);
	 			          container.addView(bannerView, new ViewGroup.LayoutParams(
	 			              ViewGroup.LayoutParams.MATCH_PARENT,
	 			              ViewGroup.LayoutParams.WRAP_CONTENT
	 			          ));
	 
	 			       
	 			        } else {
	 			        }
	 			      }
	 			    }.execute();
	 			  
	 	
		  

	}

	@Override
	protected void initParams() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void showFisrtDialog() {
		// TODO Auto-generated method stub
		boolean isFirst=LocalApplication.getInstance().sharereferences.getBoolean("ibook", false);
	      if(isFirst){	showAlertDialog(showString(R.string.app_ibooks),
			showString(R.string.ibook_dialog),
			new String[] {showString(R.string.no_dialog), showString(R.string.yes_dialog)}, true, true, null);}
		     LocalApplication.getInstance().sharereferences.edit().putBoolean("ibook", false).commit();

	}
}
