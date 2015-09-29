package com.xiri.appactivity;

import com.xiri.activity.BaseActivity;

import com.xiri.application.LocalApplication;
import com.example.iphonereborn.R;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class GameCenterActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_game_center;
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
ImageView iv_content=(ImageView) findViewById(R.id.game_content);
iv_content.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		showShortToast(R.string.image_cant_toast);
	}
});
	}

	@Override
	protected void initParams() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void showFisrtDialog() {
		// TODO Auto-generated method stub
		boolean isFirst = LocalApplication.getInstance().sharereferences
				.getBoolean("gamecenter", false);
		if (isFirst) {
			showAlertDialog(showString(R.string.app_gamecenter),
					showString(R.string.gamecenter_dialog), new String[] {
							showString(R.string.no_dialog),
							showString(R.string.yes_dialog) }, true, true, null);
		}
		LocalApplication.getInstance().sharereferences.edit()
				.putBoolean("gamecenter", false).commit();

	}
}
