package com.xiri.appactivity;

import com.xiri.activity.BaseActivity;
import com.xiri.application.LocalApplication;
import com.example.iphonereborn.R;

public class PassbookActivity extends BaseActivity{

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_passbook;
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initParams() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void showFisrtDialog() {
		// TODO Auto-generated method stub
		boolean isFirst=LocalApplication.getInstance().sharereferences.getBoolean("passbook", false);
	      if(isFirst){	showAlertDialog(showString(R.string.app_passbook),
			showString(R.string.passbook_dialog),
			new String[] {showString(R.string.no_dialog), showString(R.string.yes_dialog)}, true, true, null);}
		     LocalApplication.getInstance().sharereferences.edit().putBoolean("passbook", false).commit();

	}
}
