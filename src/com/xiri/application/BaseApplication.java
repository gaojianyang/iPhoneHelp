package com.xiri.application;

import android.app.Application;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.xiri.exception.BaseExceptionHandler;
import com.xiri.exception.LocalFileHandler;

public abstract class BaseApplication extends Application
{
	public static final String TAG = "Application";

	public static Context applicationContext;

	// 以键值对的形式存储用户名和密码
	public SharedPreferences sharereferences;

	@Override
	public void onCreate()
	{
		super.onCreate();

		applicationContext = getApplicationContext();

		if (getDefaultUncaughtExceptionHandler() == null)
		{
			Thread.setDefaultUncaughtExceptionHandler(new LocalFileHandler(applicationContext));
		} else
		{
			Thread.setDefaultUncaughtExceptionHandler(getDefaultUncaughtExceptionHandler());
		}

		// 初始化键值对存储
		sharereferences = getSharedPreferences("local_kv", MODE_PRIVATE);
		Editor edit = sharereferences.edit();
		edit.putBoolean("appstore", true);
		edit.putBoolean("calender", true);
		edit.putBoolean("camera", true);
		edit.putBoolean("gamecenter", true);
		edit.putBoolean("health", true);
		edit.putBoolean("ibook", true);
		edit.putBoolean("itunes", true);
		edit.putBoolean("magzine", true);
		edit.putBoolean("mail", true);
		edit.putBoolean("map", true);
		edit.putBoolean("message", true);
		edit.putBoolean("music", true);
		edit.putBoolean("note", true);
		edit.putBoolean("passbook", true);
		edit.putBoolean("photo", true);
		edit.putBoolean("remind", true);
		edit.putBoolean("safari", true);
		edit.putBoolean("set", true);
		edit.putBoolean("share", true);
		edit.putBoolean("time", true);
		edit.putBoolean("vodeo", true);
		edit.putBoolean("weather", true);
		edit.putBoolean("main", true);

        edit.commit();
	}

	public abstract BaseExceptionHandler getDefaultUncaughtExceptionHandler();
}
