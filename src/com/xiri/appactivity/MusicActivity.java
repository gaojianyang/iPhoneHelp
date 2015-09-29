package com.xiri.appactivity;

import android.graphics.Bitmap;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiri.activity.BaseActivity;
import com.xiri.application.LocalApplication;
import com.example.iphonereborn.R;
import com.xiri.util.DisplayUtil;

public class MusicActivity extends BaseActivity implements OnClickListener{

	private ImageView iv_music;
	private ImageView iv_queen;
	private ImageView iv_content;

	private TextView tv_music;
	private TextView tv_queen;
	Bitmap bitmap;
	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_music;
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		iv_content = (ImageView) findViewById(R.id.music_content);
		iv_music = (ImageView) findViewById(R.id.music_me_iv);
		iv_queen = (ImageView) findViewById(R.id.music_queen_iv);
		tv_music = (TextView) findViewById(R.id.music_me_tv);
		tv_queen = (TextView) findViewById(R.id.music_queen_tv);
		iv_music.setOnClickListener(this);
		iv_queen.setOnClickListener(this);
		
		bitmap=DisplayUtil.readBitMap(getApplicationContext(), R.drawable.music_part1);
		iv_content.setImageBitmap(bitmap);

	}

	@Override
	protected void initParams() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void showFisrtDialog() {
		// TODO Auto-generated method stub
		boolean isFirst=LocalApplication.getInstance().sharereferences.getBoolean("music", false);
	      if(isFirst){	showAlertDialog(showString(R.string.app_Music),
			showString(R.string.music_dialog),
			new String[] {showString(R.string.no_dialog), showString(R.string.yes_dialog)}, true, true, null);}
		     LocalApplication.getInstance().sharereferences.edit().putBoolean("music", false).commit();

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.music_me_iv:
			iv_content.setImageBitmap(bitmap);
			iv_music.setImageResource(R.drawable.music_pressed);
			iv_queen.setImageResource(R.drawable.queen);
			tv_music.setTextColor(getResources().getColor(
					R.color.selected_music_text));
			tv_queen.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			
			break;
		case R.id.music_queen_iv:
			iv_content.setImageBitmap(DisplayUtil.readBitMap(getApplicationContext(), R.drawable.music_part2));
			iv_music.setImageResource(R.drawable.music_unpressed);
			iv_queen.setImageResource(R.drawable.queen_unpressed);
			tv_music.setTextColor(getResources().getColor(
					R.color.unselected_calendar_text));
			tv_queen.setTextColor(getResources().getColor(
					R.color.selected_music_text));
			
			break;
		}
	}

}
