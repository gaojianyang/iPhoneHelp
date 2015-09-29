package com.xiri.iphonehelper;




import android.annotation.SuppressLint;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import com.example.iphonereborn.R;

public class StartApp extends Activity {

 Animation amshow ;
 MyThread thread;
	@SuppressLint("HandlerLeak") Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			
			if(msg.what==1){
				Intent intent=new Intent();
				intent.setClass(getApplicationContext(), SignInActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);  

				finish();

			}
			
		};
		
	};  
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
setContentView(R.layout.app_start);
//RelativeLayout re=(RelativeLayout) findViewById(R.id.start_re);
//re.setBackgroundResource(R.drawable.app_start);

thread=new MyThread();
new Thread(thread).start();

}

@Override
protected void onDestroy() {
	// TODO Auto-generated method stub
	super.onDestroy();
	handler.removeCallbacks(thread);
	thread=null;
}

 class MyThread implements Runnable {  
    @Override  
    public void run() {  
        // TODO Auto-generated method stub  
      
            Message message = new Message();  
			message.what = 1;  
			handler.sendMessageDelayed(message, 2000);// 发送消息    
        
    }  
}


}
