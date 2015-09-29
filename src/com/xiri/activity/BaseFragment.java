package com.xiri.activity;

import android.app.Activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiri.view.DialogMaker;
import com.xiri.view.ToastMaker;
import com.xiri.view.DialogMaker.DialogCallBack;

public abstract class BaseFragment extends Fragment
{
	public Context context;
	protected Dialog dialog;
	protected View mView;

	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);
		context = activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		if (mView == null && getActivity() != null)
		{
			mView = inflater.inflate(getLayoutId(), container, false);
			if (savedInstanceState != null)
				onRestoreInstanceState(savedInstanceState);
			initParams();
		} else if (mView != null)
		{
			ViewGroup parent = (ViewGroup) mView.getParent();
			if (parent != null)
			{
				parent.removeView(mView);
			}
		}
		return mView;
	}

	/**
	 * 恢复状态
	 * 
	 * @author blue
	 */
	protected void onRestoreInstanceState(Bundle savedInstanceState)
	{
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
	protected abstract void initParams();
	
	public void showShortToast(String str){
		ToastMaker.showShortToast(str);
		
	}

	/**
	 * 弹出对话框
	 * 
	 * @author blue
	 */
	public Dialog showAlertDialog(String title, String msg, String[] btns, final DialogCallBack callBack, boolean isCanCancelabel, final boolean isDismissAfterClickBtn, Object tag)
	{
		if (null == dialog || !dialog.isShowing())
		{
			dialog = DialogMaker.showCommonAlertDialog(context, title, msg, btns, callBack, isCanCancelabel, isDismissAfterClickBtn, tag);
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
			dialog = DialogMaker.showCommenWaitDialog(context, msg, null, isCanCancelabel, tag);
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
	public void showShortToast(int str){
		ToastMaker.showShortToast(str);
		
	}
}
