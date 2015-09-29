package com.xiri.util;

import java.io.InputStream;




import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


/**
 * dp、sp 转换为 px 的工具类 
 * 
 * @author blue
 *
 */
public class DisplayUtil
{
	/**
	 * 将px值转换为dip或dp值，保证尺寸大小不变
	 * 
	 * @param pxValue
	 * @param scale
	 *            （DisplayMetrics类中属性density）
	 * @return
	 */
	public static int px2dip(Context context, float pxValue)
	{
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * 将dip或dp值转换为px值，保证尺寸大小不变
	 * 
	 * @param dipValue
	 * @param scale
	 *            （DisplayMetrics类中属性density）
	 * @return
	 */
	public static int dip2px(Context context, float dipValue)
	{
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}

	/**
	 * 将px值转换为sp值，保证文字大小不变
	 * 
	 * @param pxValue
	 * @param fontScale
	 *            （DisplayMetrics类中属性scaledDensity）
	 * @return
	 */
	public static int px2sp(Context context, float pxValue)
	{
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (pxValue / fontScale + 0.5f);
	}

	/**
	 * 将sp值转换为px值，保证文字大小不变
	 * 
	 * @param spValue
	 * @param fontScale
	 *            （DisplayMetrics类中属性scaledDensity）
	 * @return
	 */
	public static int sp2px(Context context, float spValue)
	{
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (spValue * fontScale + 0.5f);
	}
	 /**
     * 以最省内存的方式读取本地资源的图片
     * @param context
     * @param resId
    * @return
    */ 
public static Bitmap readBitMap(Context context, int resId){  
	     BitmapFactory.Options opt = new BitmapFactory.Options();  
	     opt.inPreferredConfig = Bitmap.Config.RGB_565;   
	     opt.inPurgeable = true;  
	     opt.inInputShareable = true;  
	        //获取资源图片  
	     InputStream is = context.getResources().openRawResource(resId);  
	        return BitmapFactory.decodeStream(is,null,opt);  
	   }
//@SuppressWarnings("deprecation")
//public  void blur(Context context,Bitmap bkg, View view) {
//    
//    
//	float  scaleFactor = 8;
//	float   radius = 50;
//    
//
//    Bitmap overlay = Bitmap.createBitmap((int) (view.getMeasuredWidth()/scaleFactor),
//            (int) (view.getMeasuredHeight()/scaleFactor), Bitmap.Config.ARGB_8888);
//    Canvas canvas = new Canvas(overlay);
//    canvas.translate(-view.getLeft()/scaleFactor, -view.getTop()/scaleFactor);
//    canvas.scale(1 / scaleFactor, 1 / scaleFactor);
//    Paint paint = new Paint();
//    paint.setFlags(Paint.FILTER_BITMAP_FLAG);
//    canvas.drawBitmap(bkg, 0, 0, paint);
//
//    overlay = FastBlur.doBlur(overlay, (int)radius, true);
//    view.setBackgroundDrawable(new BitmapDrawable(context.getResources(), overlay));
//}
}
