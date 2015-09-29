package com.xiri.model;

import android.graphics.drawable.Drawable;


public class Icon {
	private Drawable appIcon;
	public Icon(){
		
	}
	public Icon(Drawable appIcon, String appText) {
		super();
		this.appIcon = appIcon;
		this.appText = appText;
	}
	public Drawable getAppIcon() {
		return appIcon;
	}
	public void setAppIcon(Drawable appIcon) {
		this.appIcon = appIcon;
	}
	public String getAppText() {
		return appText;
	}
	public void setAppText(String appText) {
		this.appText = appText;
	}
	private String appText;
	
	

}
