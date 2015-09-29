package com.xiri.appactivity;

import android.widget.ImageView;


import com.xiri.activity.BaseActivity;
import com.xiri.application.LocalApplication;
import com.example.iphonereborn.R;
import com.xiri.util.DisplayUtil;

public class MailActivity extends BaseActivity{
private ImageView iv_content;
	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_mail;
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		iv_content=(ImageView) findViewById(R.id.mail_content);
		iv_content.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(), R.drawable.mail_content));
	}

	@Override
	protected void initParams() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void showFisrtDialog() {
		// TODO Auto-generated method stub
		boolean isFirst=LocalApplication.getInstance().sharereferences.getBoolean("mail", false);
	      if(isFirst){	showAlertDialog(showString(R.string.app_mail),
			showString(R.string.mail_dialog),
			new String[] {showString(R.string.no_dialog), showString(R.string.yes_dialog)}, true, true, null);}
		     LocalApplication.getInstance().sharereferences.edit().putBoolean("mail", false).commit();
		
	}

}
