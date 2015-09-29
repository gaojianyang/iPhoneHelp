package com.xiri.activity;



import android.app.Dialog;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.iphonereborn.R;
import com.xiri.util.ActivityStack;
import com.xiri.view.DialogMaker;
import com.xiri.view.ToastMaker;
import com.xiri.view.DialogMaker.DialogCallBack;

/**
 * BaseActivity
 * 
 * @author blue
 */
public abstract class BaseActivity extends FragmentActivity implements DialogCallBack
{
	protected Dialog dialog;
	
	private boolean isCreate = false;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		ActivityStack.getInstance().addActivity(this);
		setContentView(getLayoutId());
		initView();
		showFisrtDialog();
		isCreate = true;
	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
		if (isCreate)
		{
			isCreate = false;
			initParams();
		}
	}

	/**
	 * 初始化布局
	 * 
	 * @author blue
	 */
	protected abstract int getLayoutId();
	
	/**
	 * 参数设置
	 * 
	 * @author blue
	 */
	protected abstract void initView();
	protected abstract void initParams();
    protected abstract void showFisrtDialog();
	/**
	 * 弹出对话框
	 * 
	 * @author blue
	 */
	public Dialog showAlertDialog(String title, String msg, String[] btns, boolean isCanCancelabel, final boolean isDismissAfterClickBtn, Object tag)
	{
		if (null == dialog || !dialog.isShowing())
		{
			dialog = DialogMaker.showCommonAlertDialog(this, title, msg, btns, this, isCanCancelabel, isDismissAfterClickBtn, tag);
		}
		return dialog;
	}

	/**
	 * 等待对话框
	 * 
	 * @author blue
	 */
	public Dialog showWaitDialog(String msg, boolean isCanCancelabel, Object tag)
	{
		if (null == dialog || !dialog.isShowing())
		{
			dialog = DialogMaker.showCommenWaitDialog(this, msg, this, isCanCancelabel, tag);
		}
		return dialog;
	}

	/**
	 * 关闭对话框
	 * 
	 * @author blue
	 */
	public void dismissDialog()
	{
		if (null != dialog && dialog.isShowing())
		{
			dialog.dismiss();
		}
	}

	@Override
	public void onButtonClicked(Dialog dialog, int position, Object tag)
	{
	}

	@Override
	public void onCancelDialog(Dialog dialog, Object tag)
	{
	}
	public void showShortToast(int str){
		ToastMaker.showShortToast(str);
		
	}
	public void showLongToast(int str){
		ToastMaker.showLongToast(str);
		
	}
	@Override
	protected synchronized void onDestroy()
	{
		dismissDialog();
		ActivityStack.getInstance().removeActivity(this);
		super.onDestroy();
	}
	public String showString(int id){
		String str=getApplicationContext().getResources().getString(id);
		return str;
	}
	
	public void startToExistedActivity(Class<?> a){
		Intent intent=new Intent();
		intent.setClass(getApplicationContext(), a);
		intent.setFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY);
		startActivity(intent);
		
		
	}
	public void startToOtherActivity(Class<?> a){
		Intent intent=new Intent();
		intent.setClass(getApplicationContext(), a);
		startActivity(intent);
		
		
	}
	public void startToOtherActivityWithInt(Class<?> a,int params){
		Intent intent=new Intent();
		intent.putExtra("position", params);
		intent.setClass(getApplicationContext(), a);
		startActivity(intent);
		overridePendingTransition(R.anim.push_left_out, R.anim.push_left_in);  

		
	}
//	@Override  
//    public boolean onKeyDown(int keyCode, KeyEvent event) {  
//        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {  
//        	showShortToast(R.string.application_back);
//            return super.onKeyDown(keyCode, event);  
//
//        } else 
//            return super.onKeyDown(keyCode, event);  
//    }  
//	 @Override
//	    public void onAttachedToWindow () {
//	        System.out.println("Page01 -->onAttachedToWindow");
//	        this.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD); 
//	        super.onAttachedToWindow();
//	    }
}
